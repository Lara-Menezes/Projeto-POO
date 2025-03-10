package Views.Interface;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionListener;
import controller.LocacaoController;

public class TelaDeLocacao extends JFrame{ 

    private JFrame frmLocacao; 
    private JComboBox<String> cbClientes; 
    private JComboBox<String> cbVeiculos; 
    private JTextField txtDataRetirada; 
    private JTextField txtDataDevolucao;  
    private JButton btnConfirmar; 
    private JButton btnCancelar; 
    private JButton btnVoltar; 
    private LocacaoController controller; 

    // Construtor agora sem o LocacaoController, pois ele será associado depois
    public TelaDeLocacao() { 
        frmLocacao = new JFrame(); 
        frmLocacao.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeLocacao.class.getResource("/Views/Images/veiculo.png"))); 
        frmLocacao.setTitle("REGISTRO DE LOCAÇÃO DE VEÍCULOS"); 
        frmLocacao.setSize(601, 552); 
        frmLocacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frmLocacao.setLocationRelativeTo(null); 
        frmLocacao.getContentPane().setLayout(null); 

        JPanel panel = new JPanel(); 
        panel.setBounds(0, 0, 575, 444); 
        panel.setLayout(null); 
        frmLocacao.getContentPane().add(panel); 

        adicionarCampos(panel); 
        adicionarBotoes(); 
    }

    private void adicionarCampos(JPanel panel) {
        String[] labels = {"Cliente:", "Veículo:", "Data de Retirada:", "Data de Devolução:"}; 
        int yPosition = 25;

        for (String label : labels) { 
            JLabel lbl = new JLabel(label); 
            lbl.setFont(new Font("Tahoma", Font.BOLD, 13)); 
            lbl.setBounds(80, yPosition, 199, 25); 
            panel.add(lbl); 
            yPosition += 50; 
        }

        cbClientes = new JComboBox<>(new String[]{"Selecione um cliente"}); 
        cbClientes.setBounds(296, 36, 187, 25); 
        panel.add(cbClientes); 

        cbVeiculos = new JComboBox<>(new String[]{"Selecione um veículo"}); 
        cbVeiculos.setBounds(296, 86, 187, 25); 
        panel.add(cbVeiculos); 

        txtDataRetirada = new JTextField(); 
        txtDataRetirada.setBounds(296, 136, 187, 25); 
        panel.add(txtDataRetirada);

        txtDataDevolucao = new JTextField(); 
        txtDataDevolucao.setBounds(296, 186, 187, 25); 
        panel.add(txtDataDevolucao);
    }

    private void adicionarBotoes() {
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setBackground(new Color(255, 255, 0)); 
        buttonPanel.setBounds(0, 455, 585, 58); 
        buttonPanel.setLayout(null); 
        frmLocacao.getContentPane().add(buttonPanel); 

        btnConfirmar = new JButton("Confirmar");
        configurarBotao(btnConfirmar, Color.BLACK, Color.WHITE, 118, e -> {
            if (controller != null) { 
                controller.registrarLocacao(); // Chama o método para registrar a locação no controlador
            }
        });
        buttonPanel.add(btnConfirmar);

        btnCancelar = new JButton("Cancelar");
        configurarBotao(btnCancelar, Color.BLACK, Color.WHITE, 236, e -> frmLocacao.dispose()); 
        buttonPanel.add(btnCancelar);

        btnVoltar = new JButton("VOLTAR");
        configurarBotao(btnVoltar, Color.RED, Color.WHITE, 356, e -> {
            TelaIntermedioAtendente telaInter = new TelaIntermedioAtendente(); 
            telaInter.setVisible(); 
            frmLocacao.dispose(); 
        });
        buttonPanel.add(btnVoltar);
    }

    private void configurarBotao(JButton botao, Color fundo, Color texto, int x, ActionListener acao) { 
        botao.setForeground(texto); 
        botao.setBackground(fundo); 
        botao.setFont(new Font("Tahoma", Font.BOLD, 13)); 
        botao.setBounds(x, 11, 98, 36); 
        botao.addActionListener(acao); 
    }

    public JComboBox<String> getCbClientes() {
        return cbClientes;
    }

    public JComboBox<String> getCbVeiculos() {
        return cbVeiculos;
    }

    public JTextField getTxtDataRetirada() {
        return txtDataRetirada;
    }

    public JTextField getTxtDataDevolucao() {
        return txtDataDevolucao;
    }


    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public JFrame getFrmLocacao() {
        return frmLocacao;
    }

    public void exibirTela() {
        frmLocacao.setVisible(true); 
    }

    // Método que vai associar o controlador à tela
    public void setController(LocacaoController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaDeLocacao tela = new TelaDeLocacao(); 
            LocacaoController controller = new LocacaoController(); // Cria o controlador
            tela.setController(controller); // Associa o controlador à tela
            controller.setTelaDeLocacao(tela); // Associa a tela ao controlador
            tela.exibirTela(); // Exibe a tela de locação
        });
    }
}
