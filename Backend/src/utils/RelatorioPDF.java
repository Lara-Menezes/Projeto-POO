package utils;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

import model.Cliente;
import model.Locacao;
import model.Pagamento;

public class RelatorioPDF {

    // Método para gerar Relatório de Veículos Locados no Mês
    public void gerarRelatorioVeiculosLocados(List<Locacao> locacoes, String filePath) {
        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new com.itextpdf.layout.element.Paragraph("Relatório de Veículos Locados no Mês").setFontSize(16));

            Table table = new Table(4);  // 4 colunas: ID, Veículo, Cliente, Data de Locação
            table.addHeaderCell("Veículo");
            table.addHeaderCell("Placa");
            table.addHeaderCell("ID Locação");
            table.addHeaderCell("Data de Locação");

            for (Locacao locacao : locacoes) {
            	table.addCell(locacao.getVeiculo().getModelo());
            	table.addCell(locacao.getVeiculo().getPlaca());
                table.addCell(String.valueOf(locacao.getIdLocacao()));
                table.addCell(locacao.getDataRetirada().toString());
            }

            document.add(table);
            document.close();

            System.out.println("Relatório de Veículos Locados no Mês gerado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para gerar Relatório de Faturamento Mensal
    public void gerarRelatorioFaturamento(List<Pagamento> pagamentos, String filePath) {
        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new com.itextpdf.layout.element.Paragraph("Relatório de Faturamento Mensal").setFontSize(16));

            Table table = new Table(2);  // 3 colunas: ID Locação, Valor Pago, Cliente
            table.addHeaderCell("ID Locação");
            table.addHeaderCell("Valor Pago");

            double totalFaturamento = 0;

            // Percorrendo todos os pagamentos e organizando os dados corretamente na tabela
            for (Pagamento pagamento : pagamentos) {
                table.addCell(String.valueOf(pagamento.getIdPagamento()));  // Adicionando o ID da locação
                table.addCell(String.format("R$ %.2f", pagamento.getValorPago()));  // Adicionando o valor pago
                totalFaturamento += pagamento.getValorPago();
            }
            
            document.add(new com.itextpdf.layout.element.Paragraph("Total Faturamento: R$ " + String.format("%.2f", totalFaturamento)).setFontSize(14));

            // Definir a margem inferior para evitar o colapso da borda inferior
            table.setMarginBottom(10);

            document.add(table);
            document.close();

            System.out.println("Relatório de Faturamento Mensal gerado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para gerar Relatório de Clientes e suas Locações
    public void gerarRelatorioClientesLocacoes(List<Locacao> locacoes, String filePath) {
    	try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new com.itextpdf.layout.element.Paragraph("Relatório de Clientes e suas Locações").setFontSize(16));

            // Criando uma tabela com 3 colunas: ID Locação, Veículo, Data de Locação
            Table table = new Table(4);  // 4 colunas: Cliente, ID Locação, Veículo, Data de Locação
            table.addHeaderCell("Cliente");
            table.addHeaderCell("ID Locação");
            table.addHeaderCell("Veículo");
            table.addHeaderCell("Data de Locação");

            // Percorrendo todas as locações
            for (Locacao locacao : locacoes) {
                Cliente cliente = locacao.getCliente();  // Acessando o cliente associado à locação

                // Adicionando uma linha para cada locação do cliente
                table.addCell(cliente.getNome());  // Nome do cliente
                table.addCell(String.valueOf(locacao.getIdLocacao()));  // ID da locação
                table.addCell(locacao.getVeiculo().getModelo());  // Modelo do veículo
                table.addCell(locacao.getDataRetirada().toString());  // Data da locação
            }

            // Adicionando a tabela ao documento
            document.add(table);
            document.close();

            System.out.println("Relatório de Clientes e suas Locações gerado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
