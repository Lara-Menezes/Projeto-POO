package Views.Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.PagamentoController;
import model.Pagamento;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaPagamentos extends JFrame{

    private JFrame frmPagamentos;
    private JTextField txtIdLocacao;
    private JTextField txtValorPago;
    private JTextField txtDataPagamento;
    private JComboBox<String> cbMetodoPagamento;
    private JButton btnRegistrar;
    private JTable tabelaPagamentos;
    private PagamentoController pagamentoController;
    private JButton btnAtualizar;

    public TelaPagamentos() {
        this.pagamentoController = new PagamentoController();
        initialize();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPagamentos telaPagamentos = new TelaPagamentos();
            PagamentoController pagamentoController = new PagamentoController();
            pagamentoController.setPagamentoController(telaPagamentos);
            telaPagamentos.exibirTela();
        });
    }

    private void initialize() {
        frmPagamentos = new JFrame();
        frmPagamentos.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPagamentos.class.getResource("/Views/Images/veiculo.png")));
        frmPagamentos.getContentPane().setBackground(new Color(255, 255, 0));
        frmPagamentos.setTitle("REGISTRO DE PAGAMENTOS");
        frmPagamentos.setSize(600, 646);
        frmPagamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPagamentos.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(0, 0, 584, 196);
        panel.setLayout(null);

        JLabel lblIdLocacao = new JLabel("ID Locação:");
        lblIdLocacao.setForeground(Color.WHITE);
        lblIdLocacao.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdLocacao.setBounds(20, 42, 208, 20);
        txtIdLocacao = new JTextField();
        txtIdLocacao.setBounds(312, 42, 236, 20);
        panel.add(lblIdLocacao);
        panel.add(txtIdLocacao);

        JLabel lblValorPago = new JLabel("Valor Pago:");
        lblValorPago.setForeground(Color.WHITE);
        lblValorPago.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorPago.setBounds(20, 75, 208, 20);
        txtValorPago = new JTextField();
        txtValorPago.setBounds(311, 75, 236, 20);
        panel.add(lblValorPago);
        panel.add(txtValorPago);

        JLabel lblDataPagamento = new JLabel("Data Pagamento:");
        lblDataPagamento.setForeground(Color.WHITE);
        lblDataPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataPagamento.setBounds(20, 108, 208, 20);
        txtDataPagamento = new JTextField();
        txtDataPagamento.setBounds(311, 108, 236, 20);
        panel.add(lblDataPagamento);
        panel.add(txtDataPagamento);

        JLabel lblMetodoPagamento = new JLabel("Método de Pagamento:");
        lblMetodoPagamento.setForeground(Color.WHITE);
        lblMetodoPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMetodoPagamento.setBounds(20, 139, 208, 20);
        cbMetodoPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Pix"});
        cbMetodoPagamento.setBounds(311, 139, 236, 20);
        panel.add(lblMetodoPagamento);
        panel.add(cbMetodoPagamento);

        // Criação do botão de registrar pagamento
        btnRegistrar = new JButton("Registrar ");
        configurarBotao(btnRegistrar, Color.BLACK, Color.WHITE, 118, e -> {
            if (pagamentoController != null) {
                pagamentoController.registrarPagamento(); // Chama o método para registrar a locação no controlador
            }
        });

        // Painel para o botão
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 547, 584, 49);
        buttonPanel.setLayout(null);
        buttonPanel.add(btnRegistrar);

        // Criação da tabela para exibir os pagamentos registrados
        tabelaPagamentos = new JTable(new DefaultTableModel(new Object[]{"ID", "ID Locação", "Valor", "Data", "Método"}, 0));
        JScrollPane scrollPane = new JScrollPane(tabelaPagamentos);
        scrollPane.setBounds(0, 203, 584, 344);

        btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.setBounds(0, 715, 584, 23);
        btnAtualizar.addActionListener(e -> atualizarTabela());

        frmPagamentos.getContentPane().setLayout(null);
        frmPagamentos.getContentPane().add(panel);
        frmPagamentos.getContentPane().add(scrollPane);
        frmPagamentos.getContentPane().add(buttonPanel);
        
                // Configuração do botão "Voltar"
                JButton btnVoltar = new JButton("Voltar");
                btnVoltar.setBounds(320, 10, 151, 30);
                buttonPanel.add(btnVoltar);
                btnVoltar.addActionListener(e -> {
                    TelaIntermedioAtendente telainter = new TelaIntermedioAtendente();
                    telainter.setVisible();
                    frmPagamentos.dispose();
                });
                btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnVoltar.setBackground(Color.RED);
        frmPagamentos.getContentPane().add(btnAtualizar);

        atualizarTabela();
    }

    // Método de configuração para o botão
    private void configurarBotao(JButton botao, Color corFundo, Color corTexto, int largura, ActionListener acao) {
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setFont(new Font("Tahoma", Font.BOLD, 13));
        botao.setBounds(130, 10, 138, 30);
        botao.addActionListener(acao);
    }

    private void atualizarTabela() {
        List<Pagamento> pagamentos = pagamentoController.listarPagamentos();
        DefaultTableModel modeloPagamentos = (DefaultTableModel) tabelaPagamentos.getModel();
        modeloPagamentos.setRowCount(0);

        for (Pagamento pagamento : pagamentos) {
            modeloPagamentos.addRow(new Object[]{
                    pagamento.getIdPagamento(),
                    pagamento.getIdLocacao(),
                    pagamento.getValorPago(),
                    pagamento.getDataPagamento(),
                    pagamento.getTipoPagamento()
            });
        }
    }

    public void exibirTela() {
        frmPagamentos.setVisible(true);
    }

    public JTextField getTxtIdLocacao() {
        return txtIdLocacao;
    }

    public JTextField getTxtValorPago() {
        return txtValorPago;
    }

    public JTextField getTxtDataPagamento() {
        return txtDataPagamento;
    }

    public JComboBox<String> getCbMetodoPagamento() {
        return cbMetodoPagamento;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JTable getTabelaPagamentos() {
        return tabelaPagamentos;
    }

    public JFrame getFrmPagamentos() {
        return frmPagamentos;
    }

    public void setPagamentoController(PagamentoController pagamentoController) {
        this.pagamentoController = pagamentoController;
    }

    public void preencherCamposLocacao(String idLocacao, String valorLocacao, String dataLocacao) {
        txtIdLocacao.setText(idLocacao);
        txtValorPago.setText(valorLocacao);
        txtDataPagamento.setText(dataLocacao);
    }

    public void limparCampos() {
        txtIdLocacao.setText("");
        txtValorPago.setText("");
        txtDataPagamento.setText("");
        cbMetodoPagamento.setSelectedIndex(0);
    }

    public void addRegistrarPagamentoListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }
}
