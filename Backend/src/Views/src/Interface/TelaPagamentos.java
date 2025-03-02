package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaPagamentos extends JFrame {
    private JTextField txtIdPagamento;
    private JTextField txtIdLocacao;
    private JTextField txtValorPago;
    private JTextField txtDataPagamento;
    private JComboBox<String> cbMetodoPagamento;
    private JButton btnRegistrar;
    private JTable tabelaPagamentos;

    public TelaPagamentos() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPagamentos.class.getResource("/Images/veiculo.png")));
    	getContentPane().setBackground(new Color(255, 255, 0));
        setTitle("REGISTRO DE PAGAMENTOS");
        setSize(600, 646);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando painel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(0, 0, 584, 196);

        // Campos de entrada
        JLabel lblIdPagamento = new JLabel("ID Pagamento:");
        lblIdPagamento.setForeground(new Color(255, 255, 255));
        lblIdPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdPagamento.setBounds(20, 11, 208, 20);
        txtIdPagamento = new JTextField();
        txtIdPagamento.setBounds(312, 11, 236, 20);
        panel.setLayout(null);
        panel.add(lblIdPagamento);
        panel.add(txtIdPagamento);

        JLabel lblIdLocacao = new JLabel("ID Locação:");
        lblIdLocacao.setForeground(new Color(255, 255, 255));
        lblIdLocacao.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdLocacao.setBounds(20, 42, 208, 20);
        txtIdLocacao = new JTextField();
        txtIdLocacao.setBounds(312, 42, 236, 20);
        panel.add(lblIdLocacao);
        panel.add(txtIdLocacao);

        JLabel lblValorPago = new JLabel("Valor Pago:");
        lblValorPago.setForeground(new Color(255, 255, 255));
        lblValorPago.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorPago.setBounds(20, 75, 208, 20);
        txtValorPago = new JTextField();
        txtValorPago.setBounds(311, 75, 236, 20);
        panel.add(lblValorPago);
        panel.add(txtValorPago);

        JLabel lblDataPagamento = new JLabel("Data Pagamento:");
        lblDataPagamento.setForeground(new Color(255, 255, 255));
        lblDataPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataPagamento.setBounds(20, 108, 208, 20);
        txtDataPagamento = new JTextField();
        txtDataPagamento.setBounds(311, 108, 236, 20);
        panel.add(lblDataPagamento);
        panel.add(txtDataPagamento);

        JLabel lblMetodoPagamento = new JLabel("Método de Pagamento:");
        lblMetodoPagamento.setForeground(new Color(255, 255, 255));
        lblMetodoPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMetodoPagamento.setBounds(20, 139, 208, 20);
        cbMetodoPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Pix"});
        cbMetodoPagamento.setBounds(311, 139, 236, 20);
        panel.add(lblMetodoPagamento);
        panel.add(cbMetodoPagamento);

        // Botão de registro de pagamento
        btnRegistrar = new JButton("Registrar Pagamento");
        btnRegistrar.setBackground(new Color(255, 255, 0));
        btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRegistrar.setBounds(204, 11, 171, 27);

        // Criando tabela para exibir histórico de pagamentos
        tabelaPagamentos = new JTable(new DefaultTableModel(new Object[]{"ID", "ID Locação", "Valor", "Data", "Método"}, 0));
        JScrollPane scrollPane = new JScrollPane(tabelaPagamentos);
        scrollPane.setBounds(0, 203, 584, 344);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 547, 584, 49);
        buttonPanel.setLayout(null);
        buttonPanel.add(btnRegistrar);
        getContentPane().setLayout(null);

        // Adicionando os componentes na tela
        getContentPane().add(panel);
        getContentPane().add(scrollPane);
        getContentPane().add(buttonPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPagamentos().setVisible(true));
    }
}
