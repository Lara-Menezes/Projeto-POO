package teste;

import java.util.List;

import controller.LocacaoController;
import controller.PagamentoController;
import model.Locacao;

public class TesteRelatorio {
    public static void main(String[] args) {
        // Criar instância de PDFGenerator
    	PagamentoController pagamentoController = new PagamentoController();
    	LocacaoController locacaoController = new LocacaoController();

        // Exemplo de como gerar os relatórios

        // Gerar relatório de faturamento
        pagamentoController.gerarRelatorioFaturamento();

        // Gerar relatório de veículos locados no mês
        List<Locacao> locacoes = locacaoController.listarLocacoes();
        
        // Gerar o relatório de veículos locados
        locacaoController.gerarRelatorioVeiculosLocados(locacoes);
        
        // Gerar o relatório de clientes e suas locações
        locacaoController.gerarRelatorioClientesLocacoes(locacoes);
    }
}
