package utils;

import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.FileNotFoundException;
import java.util.List;
import model.Locacao;
import model.Pagamento;
import model.Cliente;

public class RelatorioPDF2 {

    // Gera o Relatório de Veículos Locados no Mês
    public void gerarRelatorioVeiculosLocados(List<Locacao> locacoes, String filePath) {
        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new com.itextpdf.layout.element.Paragraph("Relatório de Veículos Locados no Mês").setFontSize(16));

            //Construçõ da tabela
            Table table = new Table(4);  
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

            // Add tabela ao documento
            document.add(table);
            document.close();

            System.out.println("Relatório de Veículos Locados no Mês gerado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Gera Relatório de Faturamento Mensal
    public void gerarRelatorioFaturamento(List<Pagamento> pagamentos, String filePath) {
        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new com.itextpdf.layout.element.Paragraph("Relatório de Faturamento Mensal").setFontSize(16));

            //Constrói a tabela
            Table table = new Table(2);  
            table.addHeaderCell("ID Locação");
            table.addHeaderCell("Valor Pago");

            double totalFaturamento = 0;

            //Calcula o faturamento mensal total
            for (Pagamento pagamento : pagamentos) {
                table.addCell(String.valueOf(pagamento.getIdPagamento()));  
                table.addCell(String.format("R$ %.2f", pagamento.getValorPago()));  
                totalFaturamento += pagamento.getValorPago();
            }
            
            document.add(new com.itextpdf.layout.element.Paragraph("Total Faturamento: R$ " + String.format("%.2f", totalFaturamento)).setFontSize(14));

            table.setMarginBottom(10);

            // Add tabela ao documento
            document.add(table);
            document.close();

            System.out.println("Relatório de Faturamento Mensal gerado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Gera Relatório de Clientes e suas Locações
    public void gerarRelatorioClientesLocacoes(List<Locacao> locacoes, String filePath) {
    	try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new com.itextpdf.layout.element.Paragraph("Relatório de Clientes e suas Locações").setFontSize(16));

            // Criando a tabela 
            Table table = new Table(4); 
            table.addHeaderCell("Cliente");
            table.addHeaderCell("ID Locação");
            table.addHeaderCell("Veículo");
            table.addHeaderCell("Data de Locação");

            // Achando o cliente associado a locação
            for (Locacao locacao : locacoes) {
                Cliente cliente = locacao.getCliente();  

                table.addCell(cliente.getNome());  
                table.addCell(String.valueOf(locacao.getIdLocacao()));  
                table.addCell(locacao.getVeiculo().getModelo());  
                table.addCell(locacao.getDataRetirada().toString());  
            }

            // Add tabela ao documento
            document.add(table);
            document.close();

            System.out.println("Relatório de Clientes e suas Locações gerado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
