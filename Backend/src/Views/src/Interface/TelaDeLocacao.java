package Interface;

import javax.swing.*;
import java.awt.*;

public class TelaDeLocacao extends JFrame {
    private JComboBox<String> cbClientes;
    private JComboBox<String> cbVeiculos;
    private JTextField txtDataRetirada;
    private JTextField txtDataDevolucao;
    private JTextField txtNumeroDias;
    private JTextField txtValorTotal;
    private JButton btnConfirmar;
    private JTextField textField;

    public TelaDeLocacao() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeLocacao.class.getResource("/Images/veiculo.png")));
        setTitle("REGISTRO DE LOCAÇÃO DE VEÍCULOS");
        setSize(480, 552);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando painel principal
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 464, 444);

        // Campos de seleção
        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCliente.setBounds(23, 23, 199, 47);
        cbClientes = new JComboBox<>(new String[]{"Selecione um cliente"});  // Aqui você pode carregar os clientes do banco
        cbClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
        cbClientes.setBounds(239, 34, 187, 25);
        panel.setLayout(null);
        panel.add(lblCliente);
        panel.add(cbClientes);
        cbVeiculos = new JComboBox<>(new String[]{"Selecione um veículo"});  // Aqui você pode carregar os veículos disponíveis
        cbVeiculos.setFont(new Font("Tahoma", Font.BOLD, 13));
        cbVeiculos.setBounds(239, 102, 187, 25);
        panel.add(cbVeiculos);
        txtDataRetirada = new JTextField();
        txtDataRetirada.setBounds(239, 170, 187, 25);
        panel.add(txtDataRetirada);
        txtDataDevolucao = new JTextField();
        txtDataDevolucao.setBounds(239, 244, 187, 25);
        panel.add(txtDataDevolucao);
        txtNumeroDias = new JTextField();
        txtNumeroDias.setBounds(239, 313, 187, 25);
        panel.add(txtNumeroDias);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setBounds(0, 455, 464, 58);
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setForeground(new Color(255, 255, 255));
        btnConfirmar.setBackground(new Color(0, 0, 0));
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnConfirmar.setBounds(118, 11, 98, 36);
        buttonPanel.setLayout(null);
        buttonPanel.add(btnConfirmar);
        getContentPane().setLayout(null);

        // Layout final
        getContentPane().add(panel);
        
        JLabel lblVeculo = new JLabel("Veículo:");
        lblVeculo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVeculo.setBounds(23, 91, 199, 47);
        panel.add(lblVeculo);
        
        JLabel lblDataDeRetirada = new JLabel("Data de Retirada:");
        lblDataDeRetirada.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataDeRetirada.setBounds(23, 159, 199, 47);
        panel.add(lblDataDeRetirada);
        
        JLabel lblDataDeDevoluo = new JLabel("Data de devolução:");
        lblDataDeDevoluo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataDeDevoluo.setBounds(23, 233, 199, 47);
        panel.add(lblDataDeDevoluo);
        
        JLabel lblNmeroDeDias = new JLabel("Número de dias:");
        lblNmeroDeDias.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNmeroDeDias.setBounds(23, 302, 199, 47);
        panel.add(lblNmeroDeDias);
        
        JLabel lblValorTotal = new JLabel("Valor Total:");
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorTotal.setBounds(23, 361, 199, 47);
        panel.add(lblValorTotal);
        
        textField = new JTextField();
        textField.setBounds(239, 374, 187, 25);
        panel.add(textField);
        getContentPane().add(buttonPanel);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(new Color(255, 255, 255));
        btnCancelar.setBackground(new Color(0, 0, 0));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCancelar.setBounds(236, 11, 98, 36);
        buttonPanel.add(btnCancelar);
        txtValorTotal = new JTextField();
        txtValorTotal.setBounds(228, 260, 192, 38);
        getContentPane().add(txtValorTotal);
        txtValorTotal.setEditable(false); // Não editável, será calculado automaticamente
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLocacao().setVisible(true);
            }
        });
    }
}
