package view;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaIntermedioAtendente {

    private JFrame frmTelaAtendente;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaIntermedioAtendente window = new TelaIntermedioAtendente();
                    window.frmTelaAtendente.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaIntermedioAtendente() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmTelaAtendente = new JFrame();
        frmTelaAtendente.setTitle("TELA ATENDENTE");
        frmTelaAtendente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaIntermedioAtendente.class.getResource("/Images/veiculo.png")));
        frmTelaAtendente.setBounds(100, 100, 450, 360);
        frmTelaAtendente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTelaAtendente.getContentPane().setLayout(null);
        frmTelaAtendente.setVisible(true);

        JButton btnDevolucao = new JButton("Devolução");
        btnDevolucao.setBackground(new Color(255, 255, 0));
        btnDevolucao.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDevolucao.setBounds(134, 50, 167, 49);
        frmTelaAtendente.getContentPane().add(btnDevolucao);

        JButton btnListagem = new JButton("Listagem");
        btnListagem.setBackground(new Color(255, 255, 0));
        btnListagem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnListagem.setBounds(134, 109, 167, 50);
        frmTelaAtendente.getContentPane().add(btnListagem);

        JButton btnLocacao = new JButton("Locação");
        btnLocacao.setBackground(new Color(255, 255, 0));
        btnLocacao.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnLocacao.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLocacao.setBounds(134, 229, 167, 49);
        frmTelaAtendente.getContentPane().add(btnLocacao);

        JButton btnPagamentos = new JButton("Pagamentos");
        btnPagamentos.setBackground(new Color(255, 255, 0));
        btnPagamentos.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnPagamentos.setBounds(134, 170, 167, 49);
        frmTelaAtendente.getContentPane().add(btnPagamentos);
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
