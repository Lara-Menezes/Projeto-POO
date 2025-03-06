package model;

public class Carro extends Veiculo{
	
	public Carro() {
    }

	public Carro(String tipo, String placa, String modelo, int ano, String status) {
		super(tipo, placa, modelo, ano, status);
	}
	
	public double calcularCustoLocacao(int dias) {
        double taxa = 10.0; 
        return dias * taxa;
    }

}
