package controller;

import model.Veiculo;

import java.util.List;
import dao.VeiculoDAO;
import model.Carro;
import model.Moto;
import model.Caminhao;

public class VeiculoController {

    public VeiculoDAO veiculoDAO;

    public VeiculoController() {
        this.veiculoDAO = VeiculoDAO.getInstance(); 
    }

    public String cadastrarVeiculo(String tipo, String placa, String modelo, int ano, String status) {
        Veiculo veiculo;
        switch (tipo.toLowerCase()) {
            case "carro":
                veiculo = new Carro(tipo,placa, modelo, ano, status);
                break;
            case "moto":
                veiculo = new Moto(tipo,placa, modelo, ano, status);
                break;
            case "caminhao":
                veiculo = new Caminhao(tipo,placa, modelo, ano, status);
                break;
            default:
                return "Tipo de veículo inválido!";
        }

        if (veiculoDAO.buscarPorPlaca(placa) != null) {
            return "Já existe um veículo com essa placa!";
        }

        veiculoDAO.salvar(veiculo);
        return "Veículo cadastrado com sucesso!";
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoDAO.listar(Veiculo.class);
        }

    public String atualizarVeiculo(String tipo,String placa, String modelo, int ano, String status) {
        Veiculo veiculo = veiculoDAO.buscarPorPlaca(placa);
        if (veiculo != null) {
            veiculo.setModelo(modelo);
            veiculo.setAno(ano);
            veiculo.setStatus(status);
            veiculo.setTipo(tipo);
            veiculoDAO.atualizar(veiculo);
            return "Veículo atualizado com sucesso!";
        } else {
            return "Veículo não encontrado!";
        }
    }
}
