package teste;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;

public class TestePDF {
    public static void main(String[] args) {
        try {
            // Cria um documento PDF
        	String caminhoDoPdf = "seuDiretório";
        	
            PdfWriter writer = new PdfWriter(caminhoDoPdf);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Adiciona conteúdo ao documento
            document.add(new Paragraph("Hello, iText 7!"));

            // Fecha o documento
            document.close();

            System.out.println("PDF gerado com sucesso!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
