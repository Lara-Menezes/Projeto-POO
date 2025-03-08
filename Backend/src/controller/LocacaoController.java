package controller;

import dao.ClienteDAO;
import dao.LocacaoDAO; 
import model.Cliente;
import model.Locacao;
import model.Veiculo;

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
}
