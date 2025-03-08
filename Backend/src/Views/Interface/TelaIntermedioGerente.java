package view;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaIntermedioGerente {

    private JFrame frmTelaGerente;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaIntermedioGerente window = new TelaIntermedioGerente();
                    window.frmTelaGerente.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaIntermedioGerente() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmTelaGerente = new JFrame();
        frmTelaGerente.setTitle("TELA GERENTE");
        frmTelaGerente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaIntermedioGerente.class.getResource("/Images/veiculo.png")));
        frmTelaGerente.setBounds(100, 100, 450, 300);
        frmTelaGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTelaGerente.getContentPane().setLayout(null);

        JButton btnCadastrarVeiculos = new JButton("Cadastrar Veículos");
        btnCadastrarVeiculos.setBackground(new Color(255, 255, 0));
        btnCadastrarVeiculos.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrarVeiculos.setBounds(116, 51, 204, 48);
        frmTelaGerente.getContentPane().add(btnCadastrarVeiculos);

        JButton btnCadastrarClientes = new JButton("Cadastrar Clientes");
        btnCadastrarClientes.setBackground(new Color(255, 255, 0));
        btnCadastrarClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrarClientes.setBounds(116, 109, 204, 48);
        frmTelaGerente.getContentPane().add(btnCadastrarClientes);

        JButton btnVisualizarRelatorios = new JButton("Visualizar Relatórios");
        btnVisualizarRelatorios.setBackground(new Color(255, 255, 0));
        btnVisualizarRelatorios.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVisualizarRelatorios.setBounds(116, 168, 204, 48);
        frmTelaGerente.getContentPane().add(btnVisualizarRelatorios);
    }
}
