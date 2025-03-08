package view;

import javax.swing.*;
import java.awt.*;

public class TelaDevolucao extends JFrame {
    private JTextField txtIdLocacao;
    private JTextField txtDataPrevista;
    private JTextField txtDataDevolucao;
    private JTextField txtValorBase;
    private JTextField txtMulta;
    private JTextField txtValorTotal;
    private JComboBox<String> cbMetodoPagamento;
    private JButton btnCalcular;
    private JButton btnRegistrarPagamento;

    public TelaDevolucao() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDevolucao.class.getResource("/Images/veiculo.png")));
        getContentPane().setBackground(new Color(255, 255, 0));
        setTitle("DEVOLUÇÃO DE VEÍCULOS");
        setSize(600, 488);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal (fundo preto)
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(10, 21, 564, 326);
        panel.setLayout(null);

        // Campos de entrada
        JLabel lblIdLocacao = new JLabel("ID Locação:");
        lblIdLocacao.setForeground(Color.WHITE);
        lblIdLocacao.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdLocacao.setBounds(20, 11, 208, 20);
        txtIdLocacao = new JTextField();
        txtIdLocacao.setBounds(312, 11, 236, 20);
        panel.add(lblIdLocacao);
        panel.add(txtIdLocacao);

        JLabel lblDataPrevista = new JLabel("Data Prevista:");
        lblDataPrevista.setForeground(Color.WHITE);
        lblDataPrevista.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataPrevista.setBounds(20, 42, 208, 20);
        txtDataPrevista = new JTextField();
        txtDataPrevista.setBounds(312, 42, 236, 20);
        panel.add(lblDataPrevista);
        panel.add(txtDataPrevista);

        JLabel lblDataDevolucao = new JLabel("Data Devolução:");
        lblDataDevolucao.setForeground(Color.WHITE);
        lblDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataDevolucao.setBounds(20, 75, 208, 20);
        txtDataDevolucao = new JTextField();
        txtDataDevolucao.setBounds(312, 75, 236, 20);
        panel.add(lblDataDevolucao);
        panel.add(txtDataDevolucao);

        JLabel lblValorBase = new JLabel("Valor Base:");
        lblValorBase.setForeground(Color.WHITE);
        lblValorBase.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorBase.setBounds(20, 108, 208, 20);
        txtValorBase = new JTextField();
        txtValorBase.setBounds(312, 108, 236, 20);
        panel.add(lblValorBase);
        panel.add(txtValorBase);

        JLabel lblMulta = new JLabel("Multa por Atraso:");
        lblMulta.setForeground(Color.WHITE);
        lblMulta.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMulta.setBounds(20, 139, 208, 20);
        txtMulta = new JTextField();
        txtMulta.setBounds(312, 139, 236, 20);
        panel.add(lblMulta);
        panel.add(txtMulta);

        JLabel lblValorTotal = new JLabel("Valor Total:");
        lblValorTotal.setForeground(Color.WHITE);
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorTotal.setBounds(20, 170, 208, 20);
        txtValorTotal = new JTextField();
        txtValorTotal.setBounds(312, 170, 236, 20);
        panel.add(lblValorTotal);
        panel.add(txtValorTotal);

        JLabel lblMetodoPagamento = new JLabel("Método de Pagamento:");
        lblMetodoPagamento.setForeground(Color.WHITE);
        lblMetodoPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMetodoPagamento.setBounds(20, 201, 208, 20);
        cbMetodoPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Pix"});
        cbMetodoPagamento.setBounds(312, 201, 236, 20);
        panel.add(lblMetodoPagamento);
        panel.add(cbMetodoPagamento);

        // Botões
        btnCalcular = new JButton("Calcular Total");
        btnCalcular.setBackground(new Color(255, 255, 0));
        btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCalcular.setBounds(120, 11, 171, 27);

        btnRegistrarPagamento = new JButton("Registrar Pagamento");
        btnRegistrarPagamento.setBackground(new Color(255, 255, 0));
        btnRegistrarPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRegistrarPagamento.setBounds(301, 11, 171, 27);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 388, 584, 49);
        buttonPanel.setLayout(null);
        buttonPanel.add(btnCalcular);
        buttonPanel.add(btnRegistrarPagamento);

        // Adicionando os componentes na tela
        getContentPane().setLayout(null);
        getContentPane().add(panel);
        getContentPane().add(buttonPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaDevolucao().setVisible(true));
    }
}