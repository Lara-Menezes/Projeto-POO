package controller;

import dao.PagamentoDAO;
import dao.LocacaoDAO;
import model.Pagamento;
import utils.RelatorioPDF2;
import model.Locacao;
import model.Cliente;

import java.text.SimpleDateFormat;
import java.util.List;

public class PagamentoController {

    private PagamentoDAO pagamentoDAO;
    private LocacaoDAO locacaoDAO;
    private static int idPagamentoContador = 1;

    public PagamentoController() {
        this.pagamentoDAO = PagamentoDAO.getInstance(); 
        this.locacaoDAO = LocacaoDAO.getInstance(); 
    }

    public void registrarPagamento(Locacao locacao, double valorPago, String tipoPagamento) {
        if (locacao != null) {
            Pagamento pagamento = new Pagamento();
            pagamento.setIdPagamento(idPagamentoContador++);
            pagamento.setIdLocacao(locacao.getIdLocacao()); 
            pagamento.setValorPago(valorPago);
            pagamento.setTipoPagamento(tipoPagamento); 
            String dataPagamento = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
            pagamento.setDataPagamento(dataPagamento); 

            pagamentoDAO.salvar(pagamento); 
            System.out.println("Pagamento registrado com sucesso!");
        } else {
            System.out.println("Locação não encontrada.");
        }
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoDAO.listar(Pagamento.class); 
    }

    public List<Pagamento> listarPagamentosPorLocacao(Locacao locacao) {
        List<Pagamento> pagamentos = pagamentoDAO.listar(Pagamento.class);
        return pagamentos.stream()
                .filter(p -> p.getIdLocacao() == locacao.getIdLocacao())
                .toList();
    }

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

    public void listarPagamentosPorCliente(Cliente cliente) {
        List<Locacao> locacoes = locacaoDAO.listar(Locacao.class);
        for (Locacao locacao : locacoes) {
            if (locacao.getCliente().equals(cliente)) {
                exibirHistoricoPagamentos(locacao); 
            }
        }
    }
    
    public void gerarRelatorioFaturamento() {
        // Recuperando os pagamentos para gerar o relatório
        List<Pagamento> pagamentos = listarPagamentos();

        // Criando uma instância de RelatorioPDF2 para gerar o relatório
        RelatorioPDF2 relatorioPDF = new RelatorioPDF2();

        // Gerando o relatório de faturamento mensal com os dados de pagamentos
        relatorioPDF.gerarRelatorioFaturamento(pagamentos, "seuDiretório/relatorio_faturamento.pdf");
    }
}
