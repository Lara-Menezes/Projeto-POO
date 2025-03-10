package controller;

import dao.ClienteDAO;
import model.Cliente;
import Views.Interface.TelaCadastroCliente;
import javax.swing.*;

public class ClienteController {
    private ClienteDAO clienteDAO;
    private TelaCadastroCliente telaCadastroCliente;

    public ClienteController() {
        this.clienteDAO = ClienteDAO.getInstance();
    }

    // Método para associar a tela de cadastro de cliente ao controlador
    public void setTelaCadastroCliente(TelaCadastroCliente telaCadastroCliente) {
        this.telaCadastroCliente = telaCadastroCliente;
        adicionarListeners(); // Adiciona os listeners após associar a tela
    }
    
    private void adicionarListeners() {
        telaCadastroCliente.getBtnCadastrar().addActionListener(e -> cadastrarCliente());
        telaCadastroCliente.getBtnEditar().addActionListener(e -> editarCliente());
        telaCadastroCliente.getBtnExcluir().addActionListener(e -> excluirCliente());
    }

    // Cadastro de cliente
    public void cadastrarCliente() {
        String nome = telaCadastroCliente.getTxtNome().getText();
        String cpf = telaCadastroCliente.getTextField().getText();
        String telefone = telaCadastroCliente.getTextField_1().getText();
        String email = telaCadastroCliente.getTextField_2().getText();

        if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Por favor, preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Cliente cliente = new Cliente(nome, cpf, telefone, email);
            clienteDAO.salvar(cliente); //chamada ao método salvar

            JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        }
    }

    // Edição de cliente
    public void editarCliente() {
        String cpf = telaCadastroCliente.getTextField().getText();
        Cliente cliente = ClienteDAO.getInstance().buscarClientePorCPF(cpf); //chamada do método de busca

        if (cliente != null) {
            String nomeEditado = telaCadastroCliente.getTxtNome().getText();
            String telefoneEditado = telaCadastroCliente.getTextField_1().getText();
            String emailEditado = telaCadastroCliente.getTextField_2().getText();

            boolean alterado = false;

            if (!cliente.getNome().equals(nomeEditado)) {
                cliente.setNome(nomeEditado);
                alterado = true;
                System.out.println("Nome foi alterado para: " + cliente.getNome());
            }
            if (!cliente.getTelefone().equals(telefoneEditado)) {
                cliente.setTelefone(telefoneEditado);
                alterado = true;
                System.out.println("Telefone foi alterado para: " + cliente.getTelefone());
            }
            if (!cliente.getEmail().equals(emailEditado)) {
                cliente.setEmail(emailEditado);
                alterado = true;
                System.out.println("Email foi alterado para: " + cliente.getEmail());
            }

            if (alterado) {
                boolean sucesso = ClienteDAO.getInstance().editar(cliente); //chamada ao método de editar

                if (sucesso) {
                    JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Cliente editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Erro ao editar o cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    limparCampos();
                }
            } else {
                JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Nenhuma alteração foi feita.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            System.out.println("Cliente não encontrado com o CPF: " + cpf);
            JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Excluir cliente
    public void excluirCliente() {
        String cpf = telaCadastroCliente.getTextField().getText();
        boolean sucesso = clienteDAO.removerCliente(cpf); //chamada ao método remover

        if (sucesso) {
            JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(telaCadastroCliente.getFrmCadastroDeClientes(), "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Limpa os campos da tela
    private void limparCampos() {
        telaCadastroCliente.getTxtNome().setText("");
        telaCadastroCliente.getTextField().setText("");
        telaCadastroCliente.getTextField_1().setText("");
        telaCadastroCliente.getTextField_2().setText("");
    }
}



    
