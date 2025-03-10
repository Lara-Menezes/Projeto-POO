package Views.Interface;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroUsers extends JFrame{

    private JFrame frmCadastroDeUsurios;
    private JTextField textNome;
    private JPasswordField textSenha;
    private JComboBox<String> comboPerfil;
    private JButton btnCadastrar;  


    public TelaCadastroUsers() {
        initialize();
    }

    private void initialize() {
        frmCadastroDeUsurios = new JFrame();
        frmCadastroDeUsurios.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroUsers.class.getResource("/Views/Images/veiculo.png")));
        frmCadastroDeUsurios.setTitle("CADASTRO DE USUÁRIOS");
        frmCadastroDeUsurios.setBounds(100, 100, 400, 300);
        frmCadastroDeUsurios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmCadastroDeUsurios.getContentPane().setLayout(null);
        frmCadastroDeUsurios.setLocationRelativeTo(null);

        // Campos de entrada
        JLabel lblNome = new JLabel("Nome do Usuário:");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNome.setBounds(30, 30, 120, 20);
        frmCadastroDeUsurios.getContentPane().add(lblNome);

        textNome = new JTextField();
        textNome.setBounds(160, 30, 180, 25);
        frmCadastroDeUsurios.getContentPane().add(textNome);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSenha.setBounds(30, 70, 120, 20);
        frmCadastroDeUsurios.getContentPane().add(lblSenha);

        textSenha = new JPasswordField();
        textSenha.setBounds(160, 70, 180, 25);
        frmCadastroDeUsurios.getContentPane().add(textSenha);

        JLabel lblPerfil = new JLabel("Tipo de Perfil:");
        lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPerfil.setBounds(30, 110, 120, 20);
        frmCadastroDeUsurios.getContentPane().add(lblPerfil);

        comboPerfil = new JComboBox<>();
        comboPerfil.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboPerfil.setModel(new DefaultComboBoxModel<>(new String[]{"Administrador", "Gerente", "Atendente"}));
        comboPerfil.setBounds(160, 110, 180, 25);
        frmCadastroDeUsurios.getContentPane().add(comboPerfil);

        // Botão de cadastro
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(255, 255, 0));
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setBounds(120, 170, 150, 35);
        frmCadastroDeUsurios.getContentPane().add(btnCadastrar);

        // Botão voltar
        JButton btnVoltar = new JButton("VOLTAR");
        btnVoltar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                TelaIntermedioAdm telaiadm = new TelaIntermedioAdm(); // Cria uma instância da tela intermediária do administrador
                // telaiadm.setVisible(true); 
                frmCadastroDeUsurios.dispose(); // Fecha a janela de cadastro de usuário
            }
        });
        btnVoltar.setForeground(new Color(255, 255, 255)); // Define a cor do texto como branco
        btnVoltar.setBackground(new Color(255, 0, 0)); // Define a cor de fundo como vermelha
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13)); // Define a fonte do botão
        btnVoltar.setBounds(10, 230, 88, 20); // Define a posição e o tamanho do botão "Voltar"
        frmCadastroDeUsurios.getContentPane().add(btnVoltar); // Adiciona o botão "Voltar" na janela

        frmCadastroDeUsurios.setVisible(true); 
    }

    // Métodos getters para interação com o controller
    public JTextField getTextNome() {
        return textNome;
    }

    public JPasswordField getTextSenha() {
        return textSenha;
    }

    public JComboBox<String> getComboPerfil() {
        return comboPerfil;
    }

    public JFrame getFrmCadastroDeUsurios() {
        return frmCadastroDeUsurios;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    // Método para tornar a tela visível
    public void setVisible() {
        frmCadastroDeUsurios.setVisible(true);
    }

    public static void main(String[] args) {
        // Cria uma instância da tela de cadastro de usuários
        TelaCadastroUsers telaCadastro = new TelaCadastroUsers();
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.setTelaCadastroUsers(telaCadastro);
        telaCadastro.setVisible();
    }
}

