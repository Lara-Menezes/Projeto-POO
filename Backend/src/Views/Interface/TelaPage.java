package view;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPage {

	private JFrame frmLoginSistema;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPage window = new TelaPage();
					window.frmLoginSistema.setVisible(true);
					window.frmLoginSistema.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaPage() {
		initialize();
	}
	private void initialize() {
		frmLoginSistema = new JFrame();
		frmLoginSistema.setResizable(false);
		frmLoginSistema.setTitle("LOGIN - SISTEMA DE VEÍCULOS");
		frmLoginSistema.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPage.class.getResource("/Images/veiculo.png")));
		frmLoginSistema.setBounds(100, 100, 484, 449);
		frmLoginSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginSistema.getContentPane().setLayout(null);
		frmLoginSistema.setVisible(true);
		
//        JLabel lblNewLabel_1 = new JLabel();
//        ImageIcon originalIcon = new ImageIcon(TelaPrincipal.class.getResource("/Images/veiculo.png"));
//        Image resizedImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//        lblNewLabel_1.setIcon(new ImageIcon(resizedImage));
//        lblNewLabel_1.setBounds(210, 57, 78, 94);
//        lblNewLabel_1.setOpaque(false);
//        frmLoginSistema.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ENTRAR COMO ADIMINISTRADOR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginAdministrador telaloginadm = new TelaLoginAdministrador();
				frmLoginSistema.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBounds(96, 141, 280, 39);
		frmLoginSistema.getContentPane().add(btnNewButton);
		
		JButton btnEntrarComoGerente = new JButton(" ENTRAR COMO GERENTE");
		btnEntrarComoGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginGerente telalogingerente = new TelaLoginGerente();
				telalogingerente.setLocationRelativeTo(null);
				frmLoginSistema.dispose();
			}
		});
		btnEntrarComoGerente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEntrarComoGerente.setBackground(Color.YELLOW);
		btnEntrarComoGerente.setBounds(96, 191, 280, 39);
		frmLoginSistema.getContentPane().add(btnEntrarComoGerente);
		
		JButton btnNewButton_1_1 = new JButton("ENTRAR COMO ATENDENTE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginAtendente telaloginatendente = new TelaLoginAtendente();
				telaloginatendente.setLocationRelativeTo(null);
				frmLoginSistema.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBackground(Color.YELLOW);
		btnNewButton_1_1.setBounds(96, 241, 280, 39);
		frmLoginSistema.getContentPane().add(btnNewButton_1_1);
	}
	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}