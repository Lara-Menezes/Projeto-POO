package model;

import java.util.Date;

public class Locacao {
	
    private Cliente cliente;
    private Veiculo veiculo;
    private Date veiculoRetirada;
    private Date veiculoDevolucao;
    private int diasLocados;
    private double valorTotal;
    private double multaAtraso;

    public Locacao(Cliente cliente, Veiculo veiculo, Date veiculoRetirada, Date veiculoDevolucao, int diasLocados) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.veiculoRetirada = veiculoRetirada;
        this.veiculoDevolucao = veiculoDevolucao;
        this.diasLocados = diasLocados;
        this.multaAtraso = 0.0;
        calcularValorTotal();
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    
    public Date getDataRetirada() {
        return veiculoRetirada;
    }

    public void setDataRetirada(Date veiculoRetirada) {
        this.veiculoRetirada = veiculoRetirada;
    }

    public Date getDataDevolucao() {
        return veiculoDevolucao;
    }

    public void setDataDevolucao(Date veiculoDevolucao) {
        this.veiculoDevolucao = veiculoDevolucao;
    }
    

    public int getDiasLocados() {
        return diasLocados;
    }

    public void setDiasLocados(int diasLocados) {
        this.diasLocados = diasLocados;
    }

    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(double multaAtraso) {
        this.multaAtraso = multaAtraso;
    }


    public void calcularValorTotal() {
    	valorTotal = veiculo.calcularCustoLocacao(diasLocados);
        //fazer calculo para multa!!!
    }

  
    public String toString() {
        return "\n--Locação de veículos--" +
                "\n Cliente= " + cliente.getNome() +
                "\n Veículo= " + veiculo.getModelo() +
                "\n Data de retirada= " + veiculoRetirada +
                "\n Data de devolução= " + veiculoDevolucao +
                "\n Dias locados= " + diasLocados +
                "\n Valor Total= " + valorTotal +
                "\n Multa por atraso= " + multaAtraso  ;
    }
}

