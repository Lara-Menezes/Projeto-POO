package teste;

import controller.LocacaoController;
import controller.ClienteController;
import controller.VeiculoController;
import model.Cliente;
import model.Locacao;
import model.Veiculo;

public class TesteLocacao {

    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        LocacaoController locacaoController = new LocacaoController();
        VeiculoController veiculoController = new VeiculoController();

        // Cadastrar clientes
        clienteController.cadastrarCliente("João Silva", "12345678900", "999999999", "joao@exemplo.com");
        clienteController.cadastrarCliente("Maria Oliveira", "98765432100", "988888888", "maria@exemplo.com");

        // Buscar clientes
        Cliente cliente1 = clienteController.buscarClientePorCPF("12345678900");
        Cliente cliente2 = clienteController.buscarClientePorCPF("98765432100");

        // Criar veículos
        System.out.println(veiculoController.cadastrarVeiculo("carro", "ABC1234", "Fusca", 1980, "Disponível"));
        System.out.println(veiculoController.cadastrarVeiculo("moto", "XYZ5678", "CB500", 2021, "Disponível"));

        // Buscar veículos criados
        Veiculo carro = veiculoController.veiculoDAO.buscarPorPlaca("ABC1234"); // Busca pelo veículo Fusca
        Veiculo moto = veiculoController.veiculoDAO.buscarPorPlaca("XYZ5678");   // Busca pela moto CB500

        // Registrar locação
        System.out.println("Registrando locação para João Silva...");
        locacaoController.registrarLocacao(carro, "12345678900", "2025-03-01", "2025-03-05", 4);

        // Listar locações
        System.out.println("\nLista de locações:");
        for (Locacao locacao : locacaoController.listarLocacoes()) {
            System.out.println(locacao);
        }

        // Registrar outra locação
        System.out.println("\nRegistrando locação para Maria Oliveira...");
        locacaoController.registrarLocacao(moto, "98765432100", "2025-03-02", "2025-03-06", 4);

        // Listar locações
        System.out.println("\nLista de locações após o segundo registro:");
        for (Locacao locacao : locacaoController.listarLocacoes()) {
            System.out.println(locacao);
        }

        // Testar devolução de veículo com atraso
        System.out.println("\nDevolvendo veículo de João Silva com atraso...");
        Locacao locacaoJoao = locacaoController.listarLocacoesPorCliente("12345678900").get(0);
        locacaoController.devolverVeiculo(locacaoJoao,"2025-03-07"); // Atraso de 2 dias

        // Listar locações após devolução
        

        // Testar atualização de locação
        System.out.println("\nAtualizando locação de João Silva...");
        locacaoController.devolverVeiculo(locacaoJoao, "2025-03-08"); // Atualizando a data de devolução real
        System.out.println("Locação após atualização: " + locacaoJoao);
        
        System.out.println("\nLista de locações após devolução com atraso:");
        for (Locacao locacao : locacaoController.listarLocacoes()) { //problema com o método listar
            System.out.println(locacao);
        }
    }
}
