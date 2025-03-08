package controller;

import dao.ClienteDAO;
import model.Cliente;
import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = ClienteDAO.getInstance();
    }

    public void cadastrarCliente(String nome, String cpf, String telefone, String email) {
        Cliente cliente = new Cliente(nome, cpf, telefone, email);
        clienteDAO.salvar(cliente);
    }

    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente c : clienteDAO.listar(Cliente.class)) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null; 
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar(Cliente.class);
    }

    // Remover cliente pelo CPF
    public boolean removerCliente(String cpf) {
        for (Cliente c : clienteDAO.listar(Cliente.class)) {
            if (c.getCpf().equals(cpf)) {
                clienteDAO.excluir(c);
                return true;
            }
        }
        return false; 
    }
}
