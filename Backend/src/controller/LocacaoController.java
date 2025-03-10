package controller;

import dao.ClienteDAO;
import dao.LocacaoDAO;
import dao.VeiculoDAO;
import model.Cliente;
import model.Locacao;
import model.Veiculo;
import utils.RelatorioPDF2;
import javax.swing.JOptionPane;

import Views.Interface.TelaDeLocacao;
import Views.Interface.TelaDevolucao;
import Views.Interface.TelaPagamentos;

import java.util.List;

public class LocacaoController {

    private LocacaoDAO locacaoDAO;
    private ClienteDAO clienteDAO;
    private VeiculoDAO veiculoDAO;
    
    private TelaDeLocacao telaDeLocacao;  
    private TelaDevolucao telaDevolucao;

    
    public LocacaoController() {
        this.locacaoDAO = LocacaoDAO.getInstance();  
        this.clienteDAO = ClienteDAO.getInstance();  
        this.veiculoDAO = VeiculoDAO.getInstance();  
    }

    // Método para associar a tela de locação ao controlador
    public void setTelaDeLocacao(TelaDeLocacao telaDeLocacao) {
        this.telaDeLocacao = telaDeLocacao;
        adicionarListeners();  // Adiciona os listeners
        popularClientes();  // Preenche o combo de clientes
        popularVeiculos();  // Preenche o combo de veículos
    }
    
    public void setTelaDevolucao(TelaDevolucao telaDevolucao) {
    	this.telaDevolucao = telaDevolucao;
    	adicionarListenerDevolucao();
    	
    }
    

    // Adiciona os listeners para os botões da tela
    private void adicionarListeners() {
        telaDeLocacao.getBtnConfirmar().addActionListener(e -> registrarLocacao());
    }
    
    private void adicionarListenerDevolucao(){
    	telaDevolucao.getBtnSalvar().addActionListener(e -> devolverVeiculo());
    }
    
    

    // Registrar uma locação
    public void registrarLocacao() {
        String clienteSelecionado = (String) telaDeLocacao.getCbClientes().getSelectedItem(); 
        String veiculoSelecionado = (String) telaDeLocacao.getCbVeiculos().getSelectedItem(); 
        String dataRetirada = telaDeLocacao.getTxtDataRetirada().getText();  
        String dataDevolucao = telaDeLocacao.getTxtDataDevolucao().getText();  

        Cliente cliente = buscarClientePorCpf(clienteSelecionado);  // Busca o cliente pelo CPF

        if (cliente != null) {
            Veiculo veiculo = veiculoDAO.buscarPorModelo(veiculoSelecionado);  // Busca o veículo pelo modelo

            if (veiculo != null) {
                int idLocacao = gerarProximoId();  // Gera outro ID pra locação
                Locacao locacao = new Locacao(idLocacao, cliente, veiculo, dataRetirada, dataDevolucao, 0);
                locacaoDAO.salvar(locacao);  // Salva a locação 

                JOptionPane.showMessageDialog(telaDeLocacao.getFrmLocacao(), "Locação registrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();  
                
            } else {
                JOptionPane.showMessageDialog(telaDeLocacao.getFrmLocacao(), "Veículo não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(telaDeLocacao.getFrmLocacao(), "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para gerar um ID de locação 
    private int gerarProximoId() {
        return (int) (Math.random() * 1000);   
    }

    // Preenche o combo de clientes na tela de locação
    private void popularClientes() {
        List<Cliente> clientes = clienteDAO.listar();  // chamada ao listar cliente 
        for (Cliente cliente : clientes) {
            telaDeLocacao.getCbClientes().addItem(cliente.getCpf());  // Adiciona o CPF de cada cliente ao ComboBox
        }
    }

    // Preenche o combo de veículos na tela de locação
    private void popularVeiculos() {
        List<Veiculo> veiculos = veiculoDAO.listarDisponiveis();  // chamada ao veículos disponíveis
        for (Veiculo veiculo : veiculos) {
            telaDeLocacao.getCbVeiculos().addItem(veiculo.getModelo());  // Adiciona o modelo de cada veículo ao ComboBox
        }
    }

    // Busca o cliente pelo CPF
    private Cliente buscarClientePorCpf(String cpf) {
        List<Cliente> clientes = clienteDAO.listar();  //chamada ao listar clientes
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;  
            }
        }
        return null;  
    }
    
    //Registrar devolução
    public void devolverVeiculo() {
    	int idLocacao = Integer.parseInt(telaDevolucao.getTxtIdLocacao().getText()); 
        String dataDevolucao = telaDevolucao.getTxtDataDevolucao().getText(); 
        
        // Lista todas as locações para encontrar a que corresponde ao ID 
        List<Locacao> locacoes = locacaoDAO.listar();
        Locacao locacaoEncontrada = null;

        // Procura pela locação com o ID fornecido
        for (Locacao locacao : locacoes) {
            if (locacao.getIdLocacao() == idLocacao) {
                locacaoEncontrada = locacao;  
                break;  
            }
        }

        if (locacaoEncontrada == null) {
            JOptionPane.showMessageDialog(telaDevolucao.getFrmDevolucao(), "Locação não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //passando os dados da devolução
        locacaoEncontrada.setDataDevolucaoReal(dataDevolucao);

        locacaoEncontrada.devolverVeiculo(dataDevolucao);

        locacaoEncontrada.calcularValorTotal();

        locacaoDAO.atualizar(locacaoEncontrada);  //chamada ao método atualizar
        JOptionPane.showMessageDialog(telaDevolucao.getFrmDevolucao(), "Locação encontrada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        exibirTelaPagamento(locacaoEncontrada);
    }
    

    //faz com que a tela de pagamento sej chamada logo após a devolução de um veículo
    private void exibirTelaPagamento(Locacao locacao) {
    	
        TelaPagamentos telaPagamentos = new TelaPagamentos();
        PagamentoController pagamentoController = new PagamentoController();

        // Passar os dados da locação (id, valor, data, etc.)
        Veiculo veiculo = locacao.getVeiculo(); 

        telaPagamentos.preencherCamposLocacao(
                String.valueOf(locacao.getIdLocacao()), 
                String.valueOf(locacao.getValorTotal()), 
                locacao.getDataDevolucaoReal()
        );
        // Passar o controlador de pagamento para a tela de pagamento
        pagamentoController.setPagamentoController(telaPagamentos);

        telaPagamentos.exibirTela();
    }

    

    // Limpa os campos de texto da tela 
    private void limparCampos() {
        telaDeLocacao.getTxtDataRetirada().setText(""); 
        telaDeLocacao.getTxtDataDevolucao().setText(""); 
        
        telaDeLocacao.getCbClientes().setSelectedIndex(0); 
        telaDeLocacao.getCbVeiculos().setSelectedIndex(0); 
    }
    
    
    //Método único para gerar os dois relatórios
    public boolean gerarRelatorios() {
        try {
            
            List<Locacao> locacoes = locacaoDAO.listar();  //chamada ao método listar

            gerarRelatorioVeiculosLocados(locacoes);
            gerarRelatorioClientesLocacoes(locacoes);

            return true;  
        } catch (Exception e) {
            e.printStackTrace();  
            return false;  
        }
    }
    
    // Relatório 1
    public boolean gerarRelatorioVeiculosLocados(List<Locacao> locacoes) {
        try {
            RelatorioPDF2 relatorioPDF = new RelatorioPDF2();
            relatorioPDF.gerarRelatorioVeiculosLocados(locacoes, "C:/Users/epami/Downloads/relatorio_veiculos_locados.pdf");
            return true;  
        } catch (Exception e) {
            e.printStackTrace();
            return false;  
        }
    }

    //Relatório 2
    public boolean gerarRelatorioClientesLocacoes(List<Locacao> locacoes) {
        try {
            RelatorioPDF2 relatorioPDF = new RelatorioPDF2();
            relatorioPDF.gerarRelatorioClientesLocacoes(locacoes, "C:/Users/epami/Downloads/relatorio_clientes_locacoes.pdf");
            return true;  
        } catch (Exception e) {
            e.printStackTrace();
            return false;  
        }
    }
}


