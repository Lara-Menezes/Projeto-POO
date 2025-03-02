package Interface;

import java.awt.*;
import javax.swing.*;

public class TelaCadastroCliente extends JFrame {
    private JTextField txtNome;
    private JButton btnCadastrar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public TelaCadastroCliente() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/Images/veiculo.png")));
        setTitle("CADASTRO DE CLIENTES");
        setSize(480, 552);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando o painel e definindo o layout
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 464, 383);

        // Adicionando os componentes ao painel
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNome.setBounds(57, 54, 86, 29);
        txtNome = new JTextField();
        txtNome.setBounds(224, 54, 184, 29);
        panel.setLayout(null);
        panel.add(lblNome);
        panel.add(txtNome);

        // Criando os botões
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setForeground(new Color(255, 255, 255));
        btnCadastrar.setBackground(new Color(0, 0, 0));
        btnCadastrar.setBounds(57, 39, 105, 45);

        // Adicionando os botões ao painel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setBounds(0, 394, 464, 119);
        buttonPanel.setLayout(null);
        buttonPanel.add(btnCadastrar);
        getContentPane().setLayout(null);

        // Layout final
        getContentPane().add(panel);
        
        JLabel lblCpf = new JLabel("Cpf:");
        lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCpf.setBounds(57, 123, 86, 29);
        panel.add(lblCpf);
        
        textField = new JTextField();
        textField.setBounds(224, 123, 184, 29);
        panel.add(textField);
        
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTelefone.setBounds(57, 197, 86, 29);
        panel.add(lblTelefone);
        
        textField_1 = new JTextField();
        textField_1.setBounds(224, 197, 184, 29);
        panel.add(textField_1);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEmail.setBounds(57, 272, 86, 29);
        panel.add(lblEmail);
        
        textField_2 = new JTextField();
        textField_2.setBounds(224, 272, 184, 29);
        panel.add(textField_2);
        getContentPane().add(buttonPanel);
        
        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEditar.setForeground(new Color(0, 0, 0));
        btnEditar.setBackground(new Color(0, 255, 0));
        btnEditar.setBounds(178, 39, 105, 45);
        buttonPanel.add(btnEditar);
        
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnExcluir.setForeground(new Color(255, 255, 255));
        btnExcluir.setBackground(new Color(255, 0, 0));
        btnExcluir.setBounds(293, 39, 105, 45);
        buttonPanel.add(btnExcluir);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }
}
