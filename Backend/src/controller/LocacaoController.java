package controller;

import dao.ClienteDAO;
import dao.LocacaoDAO; 
import model.Cliente;
import model.Locacao;
import model.Veiculo;
import utils.RelatorioPDF2;

import java.time.LocalDate;
import java.util.List;

public class LocacaoController {
    
    private LocacaoDAO locacaoDAO;  
    private ClienteDAO clienteDAO;
    
    public LocacaoController() {
        this.locacaoDAO = LocacaoDAO.getInstance();  
        this.clienteDAO = ClienteDAO.getInstance();  
    }
    
    private static int proximoId = 1;
    
    public void registrarLocacao(Veiculo veiculo, String cpfCliente, String dataRetirada, String dataDevolucao, int diasLocados) {
        Cliente cliente = buscarClientePorCpf(cpfCliente);
        
        if (cliente != null) {
            int idLocacao = proximoId++; 
            Locacao locacao = new Locacao(idLocacao, cliente, veiculo, dataRetirada, dataDevolucao, diasLocados);
            locacaoDAO.salvar(locacao);  
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public Cliente buscarClientePorCpf(String cpf) {
        List<Cliente> clientes = clienteDAO.listar(Cliente.class);  // Buscar todos os clientes
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {  
                return c;
            }
        }
        return null;
    }

    public List<Locacao> listarLocacoes() {
        return locacaoDAO.listar(Locacao.class);  // Listar todas as locações
    }

    // Devolver veículo e calcular valor total
    public void devolverVeiculo(Locacao locacao, String dataDevolucaoReal) {
    	locacao.setDataDevolucaoReal(dataDevolucaoReal); // Armazena a data real de devolução
        locacao.devolverVeiculo(dataDevolucaoReal); 
        locacao.calcularValorTotal(); 
        locacaoDAO.atualizar(locacao); 
    }

    public List<Locacao> listarLocacoesPorCliente(String cpfCliente) {
        Cliente cliente = buscarClientePorCpf(cpfCliente);
        
        if (cliente != null) {
            return locacaoDAO.listarPorCliente(cliente);
        } else {
            System.out.println("Cliente não encontrado!");
            return null;
        }
    }
    
    public void gerarRelatorioVeiculosLocados(List<Locacao> locacoes) {
        // Criando uma instância de RelatorioPDF2 para gerar o relatório
        RelatorioPDF2 relatorioPDF = new RelatorioPDF2();

        // Gerando o relatório de veículos locados no mês com as locações
        relatorioPDF.gerarRelatorioVeiculosLocados(locacoes, "seuDiretório/relatorio_veiculos_locados.pdf");
    }
    
    public void gerarRelatorioClientesLocacoes(List<Locacao> locacoes) {
        // Criando uma instância de RelatorioPDF2 para gerar o relatório
        RelatorioPDF2 relatorioPDF = new RelatorioPDF2();

        // Gerando o relatório de clientes e suas locações
        relatorioPDF.gerarRelatorioClientesLocacoes(locacoes, "seuDiretório/relatorio_clientes_locacoes.pdf");
    }
}
