package model;

public abstract class Veiculo {
	
    private String placa;
    private String modelo;
    private int ano;
    private String status; 

    public Veiculo(String placa, String modelo, int ano, String status) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.status = status; 
    }


    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    

    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    

    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }

    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    

    public abstract double calcularCustoLocacao(int dias);
    
    

    public String toString() {
        return "\nVeículo: " +
                "\nPlaca= " + placa +
                "\nModelo= " + modelo + 
                "\nAno= " + ano +
                "\nStatus= " + status ;
    }
}
