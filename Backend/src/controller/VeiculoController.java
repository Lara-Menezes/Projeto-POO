package controller;

import model.Veiculo;
import Views.Interface.TelaCadastroVeiculo;
import dao.VeiculoDAO;
import model.Carro;
import model.Moto;
import model.Caminhao;
import javax.swing.*;
import java.util.List;

public class VeiculoController {

    private VeiculoDAO veiculoDAO;
    private TelaCadastroVeiculo telaCadastroVeiculo;

    public VeiculoController() {
        this.veiculoDAO = VeiculoDAO.getInstance(); 
    }
    
    public void setTelaCadastroVeiculo(TelaCadastroVeiculo telaCadastroVeiculo) {
        this.telaCadastroVeiculo = telaCadastroVeiculo;
        adicionarListeners();
    }

    //adiciona listeners 
    private void adicionarListeners() {
        telaCadastroVeiculo.getBtnSalvar().addActionListener(e -> cadastrarVeiculo());
        telaCadastroVeiculo.getBtnEditar().addActionListener(e -> atualizarVeiculo());
        telaCadastroVeiculo.getBtnExcluir().addActionListener(e -> excluirVeiculo());
    }

    // Método para cadastrar um veículo
    public void cadastrarVeiculo() {
        String tipo = (String) telaCadastroVeiculo.getComboTipo().getSelectedItem();
        String placa = telaCadastroVeiculo.getTxtPlaca().getText();
        String modelo = telaCadastroVeiculo.getTxtModelo().getText();
        int ano = Integer.parseInt(telaCadastroVeiculo.getTxtAno().getText());
        String status = (String) telaCadastroVeiculo.getComboStatus().getSelectedItem();

        Veiculo veiculo;
        switch (tipo.toLowerCase()) {
            case "carro":
                veiculo = new Carro(tipo, placa, modelo, ano, status);
                break;
            case "moto":
                veiculo = new Moto(tipo, placa, modelo, ano, status);
                break;
            case "caminhão":
                veiculo = new Caminhao(tipo, placa, modelo, ano, status);
                break;
            default:
                JOptionPane.showMessageDialog(telaCadastroVeiculo.getFrmCadastroDeVeiculos(), "Tipo de veículo inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;  
        }

        // Verifica se já tem um veículo com a mesma placa
        if (veiculoDAO.buscarPorPlaca(placa) != null) {
            JOptionPane.showMessageDialog(telaCadastroVeiculo.getFrmCadastroDeVeiculos(), "Já existe um veículo com essa placa!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        veiculoDAO.salvar(veiculo);
        JOptionPane.showMessageDialog(telaCadastroVeiculo.getFrmCadastroDeVeiculos(), "Veículo cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparCampos(telaCadastroVeiculo);
    }
    
    // Atualiza as informações do veículo
    public void atualizarVeiculo() {
        String tipo = (String) telaCadastroVeiculo.getComboTipo().getSelectedItem();
        String placa = telaCadastroVeiculo.getTxtPlaca().getText();
        String modelo = telaCadastroVeiculo.getTxtModelo().getText();
        int ano = Integer.parseInt(telaCadastroVeiculo.getTxtAno().getText());
        String status = (String) telaCadastroVeiculo.getComboStatus().getSelectedItem();

        Veiculo veiculo = veiculoDAO.buscarPorPlaca(placa); //chamada a função de buscar 

        if (veiculo != null) {
            veiculo.setModelo(modelo);
            veiculo.setAno(ano);
            veiculo.setStatus(status);
            veiculo.setTipo(tipo);

            veiculoDAO.atualizar(veiculo); // chamaa a função para atualizar se o veículo existir
            JOptionPane.showMessageDialog(telaCadastroVeiculo.getFrmCadastroDeVeiculos(), "Veículo atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos(telaCadastroVeiculo);
        } else {
            JOptionPane.showMessageDialog(telaCadastroVeiculo.getFrmCadastroDeVeiculos(), "Veículo não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Exclui um veículo com base na placa
    public void excluirVeiculo() {
        String placa = telaCadastroVeiculo.getTxtPlaca().getText();  
        boolean sucesso = veiculoDAO.removerVeiculo(placa);  //chamada da função removerVeiculo

        if (sucesso) {
            JOptionPane.showMessageDialog(telaCadastroVeiculo.getFrmCadastroDeVeiculos(), "Veículo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos(telaCadastroVeiculo);
        } else {
            JOptionPane.showMessageDialog(telaCadastroVeiculo.getFrmCadastroDeVeiculos(), "Veículo não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //lista todos os veiculos
    public List<Veiculo> Listarveiculos(){
    	return veiculoDAO.listar(); 
    }

    //lista de veículos locados
    public List<Veiculo> listarVeiculosLocados() {
        return veiculoDAO.listarLocados();  
    }

    //lista de veículos disponíveis
    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculoDAO.listarDisponiveis();  
    }
    

    // Limpa os campos da tela
    private void limparCampos(TelaCadastroVeiculo telaCadastroVeiculo) {
        telaCadastroVeiculo.getTxtPlaca().setText("");
        telaCadastroVeiculo.getTxtModelo().setText("");
        telaCadastroVeiculo.getTxtAno().setText("");
        telaCadastroVeiculo.getComboStatus().setSelectedIndex(0);
        telaCadastroVeiculo.getComboTipo().setSelectedIndex(0);
    }
}





