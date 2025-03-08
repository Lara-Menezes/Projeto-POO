package teste;

import controller.LocacaoController;
import controller.ClienteController;
import controller.VeiculoController;
import controller.PagamentoController; 
import model.Cliente;
import model.Locacao;
import model.Veiculo;
import model.Pagamento;

public class TestePagamento {

    public static void main(String[] args) {
        // Controladores
        ClienteController clienteController = new ClienteController();
        LocacaoController locacaoController = new LocacaoController();
        VeiculoController veiculoController = new VeiculoController();
        PagamentoController pagamentoController = new PagamentoController(); // Controlador de pagamento

        // Cadastrar clientes
        System.out.println("Cadastrando clientes...");
        clienteController.cadastrarCliente("João Silva", "12345678900", "999999999", "joao@exemplo.com");
        clienteController.cadastrarCliente("Maria Oliveira", "98765432100", "988888888", "maria@exemplo.com");

        // Buscar clientes
        Cliente cliente1 = clienteController.buscarClientePorCPF("12345678900");
        Cliente cliente2 = clienteController.buscarClientePorCPF("98765432100");

        // Criar veículos
        System.out.println("\nCadastrando veículos...");
        veiculoController.cadastrarVeiculo("carro", "ABC1234", "Fusca", 1980, "Disponível");
        veiculoController.cadastrarVeiculo("moto", "XYZ5678", "CB500", 2021, "Disponível");

        // Buscar veículos criados
        Veiculo carro = veiculoController.veiculoDAO.buscarPorPlaca("ABC1234");
        Veiculo moto = veiculoController.veiculoDAO.buscarPorPlaca("XYZ5678");

        // Registrar locação de João Silva
        System.out.println("\nRegistrando locação para João Silva...");
        locacaoController.registrarLocacao(carro, "12345678900", "2025-03-01", "2025-03-05", 4);

        // Registrar pagamento para a locação de João Silva
        Locacao locacaoJoao = locacaoController.listarLocacoesPorCliente("12345678900").get(0);
        System.out.println("\nRegistrando pagamento para a locação de João Silva...");
        pagamentoController.registrarPagamento(locacaoJoao, 200.00, "Cartão");

        // Registrar locação de Maria Oliveira
        System.out.println("\nRegistrando locação para Maria Oliveira...");
        locacaoController.registrarLocacao(moto, "98765432100", "2025-03-02", "2025-03-06", 4);

        // Registrar pagamento para a locação de Maria Oliveira
        Locacao locacaoMaria = locacaoController.listarLocacoesPorCliente("98765432100").get(0);
        System.out.println("\nRegistrando pagamento para a locação de Maria Oliveira...");
        pagamentoController.registrarPagamento(locacaoMaria, 150.00, "Dinheiro");

        // Consultar e exibir histórico de pagamentos de João Silva
        System.out.println("\nExibindo histórico de pagamentos de João Silva...");
        pagamentoController.exibirHistoricoPagamentos(locacaoJoao);

        // Consultar e exibir histórico de pagamentos de Maria Oliveira
        System.out.println("\nExibindo histórico de pagamentos de Maria Oliveira...");
        pagamentoController.exibirHistoricoPagamentos(locacaoMaria);

        // Teste de pagamento para locação não registrada (deve falhar)
        System.out.println("\nTentando registrar um pagamento para uma locação inexistente...");
        Locacao locacaoInexistente = null; // Garantir que a locação seja nula, ou seja, inexistente
        pagamentoController.registrarPagamento(locacaoInexistente, 100.00, "Cartão");

        // Teste de múltiplos pagamentos para a mesma locação
        System.out.println("\nRegistrando segundo pagamento para a locação de João Silva...");
        pagamentoController.registrarPagamento(locacaoJoao, 150.00, "Dinheiro");

        // Exibir novamente o histórico de pagamentos de João Silva
        System.out.println("\nHistórico de pagamentos de João Silva após segundo pagamento:");
        pagamentoController.exibirHistoricoPagamentos(locacaoJoao);

        // Testar a listagem de todos os pagamentos registrados
        System.out.println("\nLista completa de pagamentos registrados:");
        for (Pagamento pagamento : pagamentoController.listarPagamentos()) {
            System.out.println(pagamento);
        }
    }
}
