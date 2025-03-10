package model;

public class Pagamento {
    private int idPagamento;
    private int idLocacao;
    private double valorPago;
    private String dataPagamento;
    private String tipoPagamento; 
    
    
    //construtor limpo para serialização e desserialização do json
    public Pagamento() {
    	
    }

    public Pagamento(int idPagamento, int idLocacao, double valorPago, String dataPagamento, String tipoPagamento) {
        this.idPagamento = idPagamento;
        this.idLocacao = idLocacao;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    
    //getters e setters
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
    	if (valorPago < 0) {
            throw new IllegalArgumentException("O valor pago não pode ser negativo."); //verifica se o valor é negativo
        }
        this.valorPago = valorPago;
    }
    

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    //Retornar os dados do objeto em String
    public String toString() {
        return "\nPagamento: " +
                "\n ID do Pagamento= " + idPagamento +
                "\n ID da Locação= " + idLocacao +
                "\n Valor Pago= " + valorPago +
                "\n Data do pagamento= " + dataPagamento +
                "\n Método de pagamento= " + tipoPagamento;
    }
}

