package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class TelaLogin {

	private JFrame frmLoginSistema;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmLoginSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginSistema = new JFrame();
		frmLoginSistema.setResizable(false);
		frmLoginSistema.setTitle("LOGIN - SISTEMA DE VEÍCULOS");
		frmLoginSistema.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/Images/veiculo.png")));
		frmLoginSistema.setBounds(100, 100, 480, 552);
		frmLoginSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginSistema.getContentPane().setLayout(null);
		
        JLabel lblNewLabel_1 = new JLabel();
        ImageIcon originalIcon = new ImageIcon(TelaPrincipal.class.getResource("/Images/veiculo.png"));
        Image resizedImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        lblNewLabel_1.setIcon(new ImageIcon(resizedImage));
        lblNewLabel_1.setBounds(210, 46, 60, 59);
        lblNewLabel_1.setOpaque(false);
        frmLoginSistema.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 0));

		lblNewLabel.setBounds(103, 139, 84, 39);
		frmLoginSistema.getContentPane().add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBackground(new Color(255, 255, 0));
		lblSenha.setBounds(103, 209, 84, 47);
		frmLoginSistema.getContentPane().add(lblSenha);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador do Sistema", "Gerente", "Atendente"}));
		comboBox.setBounds(210, 299, 142, 22);
		frmLoginSistema.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de Perfil");
		lblNewLabel_1_1.setBackground(new Color(255, 255, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(103, 286, 97, 47);
		frmLoginSistema.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(209, 148, 130, 30);
		frmLoginSistema.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBounds(183, 373, 112, 39);
		frmLoginSistema.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 218, 129, 32);
		frmLoginSistema.getContentPane().add(passwordField);
	}
}
