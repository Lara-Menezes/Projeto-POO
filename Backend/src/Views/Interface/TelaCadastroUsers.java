package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastroUsers {

    private JFrame frmCadastroDeUsurios;
    private JTextField textNome;
    private JPasswordField textSenha;
    private JComboBox<String> comboPerfil;
    private JButton btnCadastrar;  // Mova o botão "Cadastrar" para uma variável de instância

    public TelaCadastroUsers() {
        initialize();
    }

    private void initialize() {
        frmCadastroDeUsurios = new JFrame();
        frmCadastroDeUsurios.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroUsers.class.getResource("/Images/veiculo.png")));
        frmCadastroDeUsurios.setTitle("CADASTRO DE USUÁRIOS");
        frmCadastroDeUsurios.setBounds(100, 100, 400, 300);
        frmCadastroDeUsurios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmCadastroDeUsurios.getContentPane().setLayout(null);

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
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setBackground(new Color(255, 0, 0));
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(10, 230, 88, 20);
        frmCadastroDeUsurios.getContentPane().add(btnVoltar);
        btnVoltar.addActionListener(e -> frmCadastroDeUsurios.dispose());

        // Instanciando o controlador
        UsuarioController usuarioController = new UsuarioController(this);
        usuarioController.adicionarListenerAoBotaoCadastrar();
        
        frmCadastroDeUsurios.setVisible(true);  // Garanta que a janela seja visível
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

    // Defina um método para adicionar o listener de cadastrar
    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }

    // Método main - ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicializa a interface gráfica
        SwingUtilities.invokeLater(() -> {
            new TelaCadastroUsers();
        });
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
