package Interface;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class TelaPrincipal {

    private JFrame frmDashboardSistema;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();
                    window.frmDashboardSistema.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaPrincipal() {
        initialize();
    }

    private void initialize() {
        frmDashboardSistema = new JFrame();
        frmDashboardSistema.setResizable(false);
        frmDashboardSistema.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/Images/veiculo.png")));
        frmDashboardSistema.setFont(null);
        frmDashboardSistema.setBackground(new Color(128, 128, 128));
        frmDashboardSistema.setTitle("Dashboard - sistema de veículos");
        frmDashboardSistema.setAlwaysOnTop(true);
        frmDashboardSistema.setBounds(100, 100, 475, 548);
        frmDashboardSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDashboardSistema.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("DASHBOARD - LOCAÇÃO DE VEÍCULOS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setToolTipText("");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(24, 23, 268, 56);
        frmDashboardSistema.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("CADASTRO DE VEÍCULOS");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBackground(new Color(255, 255, 0));
        btnNewButton.setBounds(24, 118, 202, 41);
        frmDashboardSistema.getContentPane().add(btnNewButton);

        JButton btnCadastroDeClientes = new JButton("CADASTRO DE CLIENTES");
        btnCadastroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastroDeClientes.setBackground(new Color(255, 255, 0));
        btnCadastroDeClientes.setBounds(24, 182, 202, 41);
        frmDashboardSistema.getContentPane().add(btnCadastroDeClientes);
        
        JButton btnRegistroDeLocao = new JButton("REGISTRO DE LOCAÇÃO");
        btnRegistroDeLocao.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRegistroDeLocao.setBackground(new Color(255, 255, 0));
        btnRegistroDeLocao.setBounds(24, 252, 202, 41);
        frmDashboardSistema.getContentPane().add(btnRegistroDeLocao);
        
        JButton btnDevoluoDeVeculos = new JButton("DEVOLUÇÃO DE VEÍCULOS");
        btnDevoluoDeVeculos.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDevoluoDeVeculos.setBackground(new Color(255, 255, 0));
        btnDevoluoDeVeculos.setBounds(24, 320, 202, 41);
        frmDashboardSistema.getContentPane().add(btnDevoluoDeVeculos);

        JButton btnListagemDeVeculos = new JButton("LISTAGEM DE VEÍCULOS");
        btnListagemDeVeculos.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnListagemDeVeculos.setBackground(new Color(255, 255, 0));
        btnListagemDeVeculos.setBounds(236, 118, 202, 41);
        frmDashboardSistema.getContentPane().add(btnListagemDeVeculos);
        
        JButton btnPagamentos = new JButton("PAGAMENTOS");
        btnPagamentos.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnPagamentos.setBackground(new Color(255, 255, 0));
        btnPagamentos.setBounds(236, 182, 202, 41);
        frmDashboardSistema.getContentPane().add(btnPagamentos);

        JButton btnRelatrios = new JButton("RELATÓRIOS");
        btnRelatrios.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRelatrios.setBackground(new Color(255, 255, 0));
        btnRelatrios.setBounds(236, 252, 202, 41);
        frmDashboardSistema.getContentPane().add(btnRelatrios);

        JButton btnGerenciamentoDeUsurios = new JButton("USUÁRIOS");
        btnGerenciamentoDeUsurios.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnGerenciamentoDeUsurios.setBackground(new Color(255, 255, 0));
        btnGerenciamentoDeUsurios.setBounds(236, 320, 202, 41);
        frmDashboardSistema.getContentPane().add(btnGerenciamentoDeUsurios);
        
        JLabel lblNewLabel_1 = new JLabel();
        ImageIcon originalIcon = new ImageIcon(TelaPrincipal.class.getResource("/Images/veiculo.png"));
        Image resizedImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        lblNewLabel_1.setIcon(new ImageIcon(resizedImage));
        lblNewLabel_1.setBounds(338, 23, 60, 59);
        lblNewLabel_1.setOpaque(false);
        frmDashboardSistema.getContentPane().add(lblNewLabel_1);

        frmDashboardSistema.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{
            frmDashboardSistema.getContentPane(), lblNewLabel, btnNewButton, btnCadastroDeClientes, btnRegistroDeLocao, btnDevoluoDeVeculos, btnListagemDeVeculos, btnPagamentos, btnRelatrios, btnGerenciamentoDeUsurios, lblNewLabel_1
        }));
    }
}