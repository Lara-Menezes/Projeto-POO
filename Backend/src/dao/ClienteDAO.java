package dao;

import java.util.List;
import model.Cliente;


public class ClienteDAO extends baseDAO<Cliente> {

    public static ClienteDAO instance;

    private ClienteDAO() {
        super("src/data/clientes.json", Cliente.class);
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }


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
}

