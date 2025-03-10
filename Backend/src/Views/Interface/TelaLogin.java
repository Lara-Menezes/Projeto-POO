package Views.Interface;

import java.awt.Font;
import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
import controller.UsuarioController;  // Importa o controlador para associar com a tela

public class TelaLogin extends JFrame {  

    private JFrame frmLoginAdministrador;  
    private JTextField textFieldUsuario; 
    private JPasswordField passwordFieldSenha; 
    private JComboBox<String> comboBox;  
    private JButton btnEntrar; 
    private UsuarioController usuarioController; 

    public static void main(String[] args) {  
        TelaLogin window = new TelaLogin();  
        window.frmLoginAdministrador.setVisible(true);
    }

    public TelaLogin() { 
        initialize();  
        usuarioController = new UsuarioController();  
        usuarioController.setTelaLogin(this);  
    }

    private void initialize() {  // Método para configurar a interface gráfica.
        frmLoginAdministrador = new JFrame();
        frmLoginAdministrador.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/Views/Images/veiculo.png")));  
        frmLoginAdministrador.setTitle("LOGIN");
        frmLoginAdministrador.setBounds(100, 100, 450, 350);
        frmLoginAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginAdministrador.getContentPane().setLayout(null);
        frmLoginAdministrador.setLocationRelativeTo(null);  // Centraliza a janela.

        JLabel lblTitulo = new JLabel("LOGIN");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(197, 24, 67, 30);
        frmLoginAdministrador.getContentPane().add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblUsuario.setBounds(50, 80, 100, 20);
        frmLoginAdministrador.getContentPane().add(lblUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(150, 80, 200, 20);
        frmLoginAdministrador.getContentPane().add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSenha.setBounds(50, 120, 100, 20);
        frmLoginAdministrador.getContentPane().add(lblSenha);

        passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setBounds(150, 120, 200, 20);
        frmLoginAdministrador.getContentPane().add(passwordFieldSenha);

        JLabel lblTipoDePerfil = new JLabel("Tipo de Perfil:");
        lblTipoDePerfil.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTipoDePerfil.setBounds(50, 170, 100, 20);
        frmLoginAdministrador.getContentPane().add(lblTipoDePerfil);

        comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Administrador", "Gerente", "Atendente"}));
        comboBox.setBounds(150, 170, 200, 22);
        frmLoginAdministrador.getContentPane().add(comboBox);

        btnEntrar = new JButton("Entrar");  // Botão de login
        btnEntrar.setBackground(new Color(255, 255, 0));
        btnEntrar.setBounds(164, 242, 100, 30);
        frmLoginAdministrador.getContentPane().add(btnEntrar);

        // Adicionar o ActionListener após a inicialização da tela
        btnEntrar.addActionListener(e -> usuarioController.autenticarUsuario());

        frmLoginAdministrador.setVisible(true);
    }

    // Métodos getters para acessar os componentes da tela de login
    public JTextField getTextUsuario() {
        return textFieldUsuario;
    }

    public JPasswordField getPasswordSenha() {
        return passwordFieldSenha;
    }

    public JComboBox<String> getComboPerfil() {
        return comboBox;
    }

    public JFrame getFrmLogin() {
        return frmLoginAdministrador;
    }

    // Getter para o botão "Entrar"
    public JButton getBtnEntrar() {
        return btnEntrar;
    }
}


