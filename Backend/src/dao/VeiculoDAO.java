package dao;

import java.util.List;
import model.Veiculo;


public class VeiculoDAO extends baseDAO<Veiculo> {

    private static VeiculoDAO instance;

    private VeiculoDAO() {
        super("src/data/veiculos.json", Veiculo.class);
    }

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }

    public void salvar(Veiculo veiculo) {
        // Verifica se já existe um veículo com a mesma placa
        List<Veiculo> veiculos = listar();
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                System.out.println("Veículo com essa placa já existe!");
                return; 
            }
        }

        super.salvar(veiculo);
    }
}

