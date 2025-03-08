package view;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class TelaIntermedioAdm extends JFrame{

    private JFrame frmTelaAdministrador;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaIntermedioAdm window = new TelaIntermedioAdm();
                    window.frmTelaAdministrador.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaIntermedioAdm() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmTelaAdministrador = new JFrame();
        frmTelaAdministrador.setTitle("TELA ADMINISTRADOR");
        frmTelaAdministrador.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaIntermedioAdm.class.getResource("/Images/veiculo.png")));
        frmTelaAdministrador.setBounds(100, 100, 450, 300);
        frmTelaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTelaAdministrador.getContentPane().setLayout(null);
        frmTelaAdministrador.setVisible(true);
        
        // Botão para cadastrar usuários
        JButton btnCadastrarUsuarios = new JButton("Cadastrar Usuários");
        btnCadastrarUsuarios.setBackground(new Color(255, 255, 0));
        btnCadastrarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastroUsers telacadastrou = new TelaCadastroUsers();
                telacadastrou.setVisible(true);
                frmTelaAdministrador.dispose();
            }
        });
        btnCadastrarUsuarios.setBounds(114, 96, 211, 85);
        frmTelaAdministrador.getContentPane().add(btnCadastrarUsuarios);
        
        JButton btnVoltar = new JButton("VOLTAR");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaPage telapage = new TelaPage();
        		telapage.setVisible(true);
        		frmTelaAdministrador.dispose();
        	}
        });
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBackground(new Color(255, 0, 0));
        btnVoltar.setBounds(10, 230, 88, 20);
        frmTelaAdministrador.getContentPane().add(btnVoltar);
    }
}
