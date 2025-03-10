package Views.Interface;

import javax.swing.*;
import controller.ClienteController;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame{
    private JFrame frmCadastroDeClientes;
    private JTextField txtNome;
    private JButton btnCadastrar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnVoltar;
    private ClienteController clienteController; 

    // Construtor da classe que inicializa a interface gráfica
    public TelaCadastroCliente() {
        initialize();
        clienteController = new ClienteController(); // Cria uma instância do controlador
        clienteController.setTelaCadastroCliente(this); // Associa o controlador à tela
    }

    // Método que inicializa os componentes da interface gráfica
    private void initialize() {
        frmCadastroDeClientes = new JFrame(); 
        frmCadastroDeClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/Views/Images/veiculo.png")));
        frmCadastroDeClientes.setTitle("CADASTRO DE CLIENTES");
        frmCadastroDeClientes.setSize(594, 484);
        frmCadastroDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCadastroDeClientes.setLocationRelativeTo(null);
        frmCadastroDeClientes.getContentPane().setLayout(new BorderLayout());

        // Painel de Campos para cadastro do cliente
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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

        // Adiciona os componentes ao painel
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblCpf);
        panel.add(textField);
        panel.add(lblTelefone);
        panel.add(textField_1);
        panel.add(lblEmail);
        panel.add(textField_2);

        // Painel de Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(255, 255, 0));

        // Botões
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
        btnExcluir.setBackground(new Color(0, 0, 0));

        // Adiciona os botões no painel de botões
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnEditar);
        buttonPanel.add(btnExcluir);

        // Adiciona o painel de campos e o painel de botões na janela
        frmCadastroDeClientes.getContentPane().add(panel, BorderLayout.CENTER);
        frmCadastroDeClientes.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Criação do botão Voltar e sua funcionalidade
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaIntermedioGerente telainter = new TelaIntermedioGerente(); // Cria a tela de gerenciamento
                telainter.setVisible(true); 
                frmCadastroDeClientes.dispose(); // Fecha a tela atual
            }
        });
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBackground(Color.RED);
        buttonPanel.add(btnVoltar);

        // Torna a janela visível
        frmCadastroDeClientes.setVisible(true);
    }

    // Métodos getters para acessar os campos e botões
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

    public JFrame getFrmCadastroDeClientes() {
        return frmCadastroDeClientes;
    }

    // Método para exibir a tela de cadastro
    public void exibirTela() {
        frmCadastroDeClientes.setVisible(true);
    }

    // Método main para inicializar a tela de cadastro
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastroCliente telaCadastro = new TelaCadastroCliente(); // Cria uma instância da tela
            // O controlador já foi associado dentro do construtor da TelaCadastroCliente
        });
    }
}

