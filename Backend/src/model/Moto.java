package model;

public class Moto extends Veiculo{
	
	public Moto(String placa, String modelo, int ano, String status) {
		super(placa, modelo, ano, status);
	}
	
	public double calcularCustoLocacao(int dias) {
        double taxa = 5.0; 
        return dias * taxa;
    }

}
