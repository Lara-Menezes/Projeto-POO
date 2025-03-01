package model;

import java.time.LocalDate;

public class Pagamento {
    private int idPagamento;
    private int idLocacao;
    private double valorPago;
    private LocalDate dataPagamento;
    private String tipoPagamento; 

    public Pagamento(int idPagamento, int idLocacao, double valorPago, LocalDate dataPagamento, String tipoPagamento) {
        this.idPagamento = idPagamento;
        this.idLocacao = idLocacao;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }
    

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    public String toString() {
        return "\nPagamento: " +
                "\n ID do Pagamento= " + idPagamento +
                "\n ID da Locação= " + idLocacao +
                "\n Valor Pago= " + valorPago +
                "\n Data do pagamento= " + dataPagamento +
                "\n Método do pagamento= " + tipoPagamento;
    }
}

