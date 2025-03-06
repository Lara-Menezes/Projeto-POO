package model;

public class Caminhao extends Veiculo{
	
	public Caminhao() {
		
	}
	
	public Caminhao(String tipo, String placa, String modelo, int ano, String status) {
		super(tipo, placa, modelo, ano, status);
	}
	
	public double calcularCustoLocacao(int dias) {
        double taxa = 20.0; 
        return dias * taxa;
    }

}
