package model;

public class Caminhao extends Veiculo{
	
	
	//construtor sem parametros para serialização e desserialização do json
	public Caminhao() {
		
	}
	
	public Caminhao(String tipo, String placa, String modelo, int ano, String status) {
		super(tipo, placa, modelo, ano, status);
	}
	
	//método implementado de Veículo
	public double calcularCustoLocacao(int dias) {
        double taxa = 20.0; 
        return dias * taxa;
    }
	
	//para comparação entre objetos
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Veiculo veiculo = (Veiculo) obj;
	    return placa != null ? placa.equals(veiculo.placa) : veiculo.placa == null;
	}

	public int hashCode() {
	    return placa != null ? placa.hashCode() : 0;
	}

}