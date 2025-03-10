package dao;

import java.util.List;
import model.Cliente;


public class ClienteDAO extends baseDAO<Cliente> {

    public static ClienteDAO instance;

    private ClienteDAO() {
        super("data/clientes.json", Cliente.class);
    }

    //Apenas uma instância de uma classe existe - padrão Singleton
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    //Salva o cliente
    public void salvar(Cliente cliente) {
    	List<Cliente> clientes = listar();
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                System.out.println("Cliente com esse CPF já existe!");
                return; 
            }
        }

        super.salvar(cliente);
    }
    
    //Edita o cliente
    public boolean editar(Cliente cliente) {
        List<Cliente> lista = listar();  
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCpf().equals(cliente.getCpf())) {  
                lista.set(i, cliente); 
                escreverArquivo(lista);  
                return true;  
            }
        }
        return false; 
    }

    //Busca o cliente
    public Cliente buscarClientePorCPF(String cpf) {
        List<Cliente> clientes = listar();
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;  
    }

    //Exclui o cliente
    public boolean removerCliente(String cpf) {
        List<Cliente> clientes = listar();  
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                excluir(c);  
                return true;  
            }
        }
        return false;  
    }
   
}


