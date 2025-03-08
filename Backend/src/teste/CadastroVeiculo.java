package teste;  

import controller.VeiculoController;
import model.Veiculo;
import model.Carro;
import model.Moto;
import model.Caminhao;

public class CadastroVeiculo {

    public static void main(String[] args) {
        VeiculoController controller = new VeiculoController();

        // Teste de cadastro de veículos
        System.out.println(controller.cadastrarVeiculo("moto", "ABC1234", "Sedan", 2022, "Disponível"));
        System.out.println(controller.cadastrarVeiculo("moto", "XYZ5678", "Esportiva", 2021, "Alugado"));
        System.out.println(controller.cadastrarVeiculo("caminhao", "LMN9101", "Carga", 2020, "Disponível"));
        System.out.println(controller.cadastrarVeiculo("carro", "ABC1234", "SUV", 2023, "Disponível")); // Testando placa repetida

        // Teste de busca de veículos
        System.out.println("Buscando veículo com placa ABC1234:");
        Veiculo v1 = controller.veiculoDAO.buscarPorPlaca("ABC1234");
        System.out.println(v1 != null ? v1 : "Veículo não encontrado!");

        System.out.println("Buscando veículo inexistente:");
        Veiculo v2 = controller.veiculoDAO.buscarPorPlaca("ZZZ9999");
        System.out.println(v2 != null ? v2 : "Veículo não encontrado!");

        // Teste de atualização de veículos
        System.out.println(controller.atualizarVeiculo("carro","ABC1234", "SUV", 2023, "Disponível"));
        System.out.println(controller.atualizarVeiculo("moto","ZZZ9999", "Esportivo", 2024, "Alugado")); // Placa inexistente

        // Teste do cálculo de custo de locação
        Veiculo carro = new Carro("carro","ABC1234", "Sedan", 2022, "Disponível");
        System.out.println("Custo locação carro 5 dias: " + carro.calcularCustoLocacao(5));

        Veiculo moto = new Moto("moto","XYZ5678", "Esportiva", 2021, "Alugado");
        System.out.println("Custo locação moto 5 dias: " + moto.calcularCustoLocacao(5));

        Veiculo caminhao = new Caminhao("caminhao","LMN9101", "Carga", 2020, "Disponível");
        System.out.println("Custo locação caminhão 5 dias: " + caminhao.calcularCustoLocacao(5));
        
        //Listagem de veículos
        System.out.println("\nVeículos Locados:");
        controller.exibirVeiculosLocados();

        System.out.println("\nVeículos Disponíveis:");
        controller.exibirVeiculosDisponiveis();
    }
}
