package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaLoginAdministrador extends JFrame{

    private JFrame frmLoginAdministrador;
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;
	private Object frmloginAdministrador;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        TelaLoginAdministrador window = new TelaLoginAdministrador();
        window.frmLoginAdministrador.setVisible(true);
    }

    /**
     * Create the application.
     */
    public TelaLoginAdministrador() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLoginAdministrador = new JFrame();
        frmLoginAdministrador.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLoginAdministrador.class.getResource("/Images/veiculo.png")));
        frmLoginAdministrador.setTitle("LOGIN ADMINISTRADOR");
        frmLoginAdministrador.setBounds(100, 100, 450, 300);
        frmLoginAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginAdministrador.getContentPane().setLayout(null);
        frmLoginAdministrador.setVisible(true);
        
        JLabel lblTitulo = new JLabel("LOGIN ADMINISTRADOR");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(130, 20, 200, 30);
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
        
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(255, 255, 0));
        btnEntrar.setBounds(150, 170, 100, 30);
        frmLoginAdministrador.getContentPane().add(btnEntrar);
        
        // Ação ao clicar no botão
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String senha = new String(passwordFieldSenha.getPassword());
                
                // Aqui você pode implementar a lógica de autenticação
                if (usuario.equals("admin") && senha.equals("1234")) {
                	TelaIntermedioAdm telaadm = new TelaIntermedioAdm();
                	frmLoginAdministrador.dispose();
                } else {
                    System.out.println("Usuário ou senha incorretos.");
                }
            }
        });
    }
}
