package controller;

import dao.PagamentoDAO;
import dao.LocacaoDAO;
import model.Pagamento;
import utils.RelatorioPDF2;
import model.Locacao;
import model.Cliente;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import Views.Interface.TelaPagamentos;

public class PagamentoController {

    private PagamentoDAO pagamentoDAO;
    private LocacaoDAO locacaoDAO;
    private TelaPagamentos telaPagamentos;

    public PagamentoController() {
        this.pagamentoDAO = PagamentoDAO.getInstance(); 
        this.locacaoDAO = LocacaoDAO.getInstance(); 
    }
    
    public void setPagamentoController(TelaPagamentos telaPagamentos) {
    	this.telaPagamentos = telaPagamentos;
    	adicionarListeners();
    	
    }
    
    //listeners de botão da tela pagamento
    private void adicionarListeners() {
        telaPagamentos.getBtnRegistrar().addActionListener(e -> registrarPagamento()); 
    } 

    //salva um pagamento
    public void registrarPagamento() {
    	
    	int idLocacao = Integer.parseInt(telaPagamentos.getTxtIdLocacao().getText()); 
        double valorPago = Double.parseDouble(telaPagamentos.getTxtValorPago().getText()); 
        String tipoPagamento = (String) telaPagamentos.getCbMetodoPagamento().getSelectedItem(); 

        // Procurando a locação correspondente ao ID 
        List<Locacao> locacoes = locacaoDAO.listar();
        Locacao locacaoEncontrada = null;

        for (Locacao locacao : locacoes) {
            if (locacao.getIdLocacao() == idLocacao) {
                locacaoEncontrada = locacao; 
                break;  
            }
        }
    	
        //adiciona os dados informados pela tela devolução se a locação for encontrada
        if (locacaoEncontrada != null) {
            Pagamento pagamento = new Pagamento();
            pagamento.setIdPagamento(gerarProximoId());
            pagamento.setIdLocacao(locacaoEncontrada.getIdLocacao()); 
            pagamento.setValorPago(valorPago);
            pagamento.setTipoPagamento(tipoPagamento); 
            String dataPagamento = new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date());
            pagamento.setDataPagamento(dataPagamento); 

            pagamentoDAO.salvar(pagamento); //chamada ao método salvar
            JOptionPane.showMessageDialog(telaPagamentos.getFrmPagamentos(), "Pagamento registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
        	JOptionPane.showMessageDialog(telaPagamentos.getFrmPagamentos(), "Falha ao registrar pagamento!", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //lista todos os pagamentos
    public List<Pagamento> listarPagamentos() {
        return pagamentoDAO.listar(Pagamento.class); 
    }

    //lista pagamentos pela locacao
    public List<Pagamento> listarPagamentosPorLocacao(Locacao locacao) {
        List<Pagamento> pagamentos = pagamentoDAO.listar(Pagamento.class);
        return pagamentos.stream()
                .filter(p -> p.getIdLocacao() == locacao.getIdLocacao())
                .toList();
    }
    
    //Gera o id aleatório
    private int gerarProximoId() {
        return (int) (Math.random() * 1000);  //ID aleatório 
    }

    
    //busca um pagamento pela locacao
    public void exibirHistoricoPagamentos(Locacao locacao) {
        List<Pagamento> pagamentos = listarPagamentosPorLocacao(locacao);
        if (pagamentos.isEmpty()) {
            System.out.println("Não há pagamentos registrados para a locação de ID: " + locacao.getIdLocacao());
        } else {
            System.out.println("Histórico de Pagamentos para a Locação ID " + locacao.getIdLocacao() + ":");
            for (Pagamento pagamento : pagamentos) {
                System.out.println(pagamento.toString()); 
            }
        }
    }

    //busca um pagamento pelo cliente
    public void listarPagamentosPorCliente(Cliente cliente) {
        List<Locacao> locacoes = locacaoDAO.listar(Locacao.class);
        for (Locacao locacao : locacoes) {
            if (locacao.getCliente().equals(cliente)) {
                exibirHistoricoPagamentos(locacao); 
            }
        }
    }
    
    
    //função para gerar o 3 relatório
    public boolean gerarRelatorioFaturamento() {
        try {
            List<Pagamento> pagamentos = listarPagamentos();
            
            RelatorioPDF2 relatorioPDF = new RelatorioPDF2();
            
            relatorioPDF.gerarRelatorioFaturamento(pagamentos, "C:/Users/epami/Downloads/relatorio_faturamento.pdf");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }

    
    
    
}