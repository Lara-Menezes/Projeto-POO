package model;

public class Moto extends Veiculo{
	
	public Moto() {
		
	}
	
	public Moto(String tipo, String placa, String modelo, int ano, String status) {
		super(tipo, placa, modelo, ano, status);
	}
	
	public double calcularCustoLocacao(int dias) {
        double taxa = 5.0; 
        return dias * taxa;
    }

}
