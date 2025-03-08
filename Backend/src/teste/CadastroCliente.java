package teste;

import controller.ClienteController;
import model.Cliente;
import java.util.List;

public class CadastroCliente {
    public static void main(String[] args) {
        ClienteController controller = new ClienteController();

        // Teste de cadastro de clientes
        System.out.println("Cadastrando clientes...");
        controller.cadastrarCliente("João Silva", "12345678900", "11999999999", "joao@email.com");
        controller.cadastrarCliente("Maria Oliveira", "98765432100", "21988888888", "maria@email.com");
        controller.cadastrarCliente("Carlos Souza", "12345678900", "31977777777", "carlos@email.com"); // Testando CPF duplicado

        // Teste de listagem de clientes
        System.out.println("\nLista de clientes cadastrados:");
        List<Cliente> clientes = controller.listarClientes();
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Teste de busca por CPF
        System.out.println("\nBuscando cliente com CPF 12345678900:");
        Cliente cliente1 = controller.buscarClientePorCPF("12345678900");
        System.out.println(cliente1 != null ? cliente1 : "Cliente não encontrado!");

        System.out.println("\nBuscando cliente com CPF inexistente:");
        Cliente cliente2 = controller.buscarClientePorCPF("00000000000");
        System.out.println(cliente2 != null ? cliente2 : "Cliente não encontrado!");

        // Teste de remoção de cliente
        System.out.println("\nRemovendo cliente com CPF 98765432100:");
        boolean removido = controller.removerCliente("98765432100");
        System.out.println(removido ? "Cliente removido com sucesso!" : "Cliente não encontrado!");

        // Exibindo lista após remoção
        System.out.println("\nLista de clientes após remoção:");
        clientes = controller.listarClientes();
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
