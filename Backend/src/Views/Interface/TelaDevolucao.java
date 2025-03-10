package Views.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import controller.LocacaoController; // Importando o controlador

public class TelaDevolucao extends JFrame{

    private JFrame frmDevolucao;
    private JTextField txtIdLocacao;
    private JTextField txtDataDevolucao;
    private JButton btnSalvar;
    private JButton btnVoltar;
    private LocacaoController controller; // Controlador para gerenciar a lógica

    // Construtor da tela, inicializa os componentes gráficos
    public TelaDevolucao() {
        frmDevolucao = new JFrame();
        frmDevolucao.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDevolucao.class.getResource("/Views/Images/veiculo.png")));
        frmDevolucao.setTitle("DEVOLUÇÃO DE VEÍCULOS");
        frmDevolucao.setSize(600, 545);
        frmDevolucao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDevolucao.setLocationRelativeTo(null);
        frmDevolucao.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 575, 444);
        panel.setLayout(null);
        frmDevolucao.getContentPane().add(panel);

        adicionarCampos(panel);
        adicionarBotoes();
    }

    private void adicionarCampos(JPanel panel) {
        String[] labels = {"ID Locação:", "Data Devolução:"};
        int yPosition = 25;

        // Adiciona os labels e campos de entrada
        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
            lbl.setBounds(80, yPosition, 199, 25);
            panel.add(lbl);
            yPosition += 50;
        }

        txtIdLocacao = new JTextField();
        txtIdLocacao.setBounds(296, 36, 187, 25);
        panel.add(txtIdLocacao);

        txtDataDevolucao = new JTextField();
        txtDataDevolucao.setBounds(296, 86, 187, 25);
        panel.add(txtDataDevolucao);
    }

    private void adicionarBotoes() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setBounds(0, 455, 585, 58);
        buttonPanel.setLayout(null);
        frmDevolucao.getContentPane().add(buttonPanel);

        btnSalvar = new JButton("Registrar Pagamento");
        configurarBotao(btnSalvar, Color.BLACK, Color.WHITE, 118, e -> {
            if (controller != null) {
                controller.devolverVeiculo(); // Chama o método do controlador para salvar a devolução
            }
        });
        buttonPanel.add(btnSalvar);

        btnVoltar = new JButton("VOLTAR");
        configurarBotao(btnVoltar, Color.RED, Color.WHITE, 356, e -> {
            TelaIntermedioAtendente telaInter = new TelaIntermedioAtendente();
            telaInter.setVisible();
            frmDevolucao.dispose();
        });
        buttonPanel.add(btnVoltar);
    }

    private void configurarBotao(JButton botao, Color fundo, Color texto, int x, ActionListener acao) {
        botao.setForeground(texto);
        botao.setBackground(fundo);
        botao.setFont(new Font("Tahoma", Font.BOLD, 13));
        botao.setBounds(x, 11, 150, 36); // Ajuste no tamanho do botão
        botao.addActionListener(acao);
    }

    // Métodos de acesso aos campos de texto
    public JTextField getTxtIdLocacao() {
        return txtIdLocacao;
    }

    public JTextField getTxtDataDevolucao() {
        return txtDataDevolucao;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public JFrame getFrmDevolucao() {
        return frmDevolucao;
    }

    public void exibirTela() {
        frmDevolucao.setVisible(true);
    }

    // Método que vai associar o controlador à tela
    public void setController(LocacaoController controller) {
        this.controller = controller;
    }

    // Método que preenche os campos com os dados da locação
    public void preencherCamposLocacao(String idLocacao, String valorLocacao, String dataLocacao) {
        txtIdLocacao.setText(idLocacao);
        txtDataDevolucao.setText(dataLocacao);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaDevolucao tela = new TelaDevolucao();
            LocacaoController controller = new LocacaoController(); // Criar o controlador
            tela.setController(controller); // Associar o controlador à tela
            controller.setTelaDevolucao(tela); // Associar a tela ao controlador
            tela.exibirTela(); // Exibir a tela de devolução
        });
    }
}

