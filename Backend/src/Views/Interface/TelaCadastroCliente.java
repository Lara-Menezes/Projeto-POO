package view;

import javax.swing.*;
import controller.ClienteController;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {
    private JTextField txtNome;
    private JButton btnCadastrar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JButton btnEditar;
    private JButton btnExcluir;

    public TelaCadastroCliente() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/Images/veiculo.png")));
        setTitle("CADASTRO DE CLIENTES");
        setSize(480, 400);  // Ajustado para tamanho mais apropriado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout para os componentes principais
        setLayout(new BorderLayout());

        // Painel de Campos
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));  // Ajustando para GridLayout
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Criando os componentes
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtNome = new JTextField();

        JLabel lblCpf = new JLabel("Cpf:");
        lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));
        textField = new JTextField();

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
        textField_1 = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
        textField_2 = new JTextField();

        // Adicionando os componentes ao painel
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblCpf);
        panel.add(textField);
        panel.add(lblTelefone);
        panel.add(textField_1);
        panel.add(lblEmail);
        panel.add(textField_2);

        // Painel de Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));  // Usando FlowLayout para alinhamento centralizado
        buttonPanel.setBackground(new Color(255, 255, 0));

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setBackground(Color.BLACK);

        btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEditar.setForeground(Color.BLACK);
        btnEditar.setBackground(new Color(0, 255, 0));

        btnExcluir = new JButton("Excluir");
        btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnExcluir.setForeground(Color.WHITE);
        btnExcluir.setBackground(new Color(255, 0, 0));

        // Adicionando os botões ao painel de botões
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnEditar);
        buttonPanel.add(btnExcluir);

        // Adicionando os painéis à janela
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public JTextField getTextField_2() {
        return textField_2;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastroCliente telaCadastro = new TelaCadastroCliente();
            ClienteController controller = new ClienteController(telaCadastro);
            telaCadastro.setVisible(true);
        });
    }
}
