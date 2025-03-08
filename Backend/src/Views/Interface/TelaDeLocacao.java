package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.LocacaoController;

public class TelaDeLocacao extends JFrame {
    private JComboBox<String> cbClientes;
    private JComboBox<String> cbVeiculos;
    private JTextField txtDataRetirada;
    private JTextField txtDataDevolucao;
    private JTextField txtNumeroDias;
    private JTextField txtValorTotal;
    private JButton btnConfirmar;
    private LocacaoController controller;

    public TelaDeLocacao() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeLocacao.class.getResource("/Images/veiculo.png")));
        setTitle("REGISTRO DE LOCAÇÃO DE VEÍCULOS");
        setSize(480, 552);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 464, 444);
        panel.setLayout(null);
        
        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCliente.setBounds(23, 23, 199, 47);
        panel.add(lblCliente);
        
        cbClientes = new JComboBox<>(new String[]{"Selecione um cliente"});
        cbClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
        cbClientes.setBounds(239, 34, 187, 25);
        panel.add(cbClientes);
        
        JLabel lblVeculo = new JLabel("Veículo:");
        lblVeculo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVeculo.setBounds(23, 91, 199, 47);
        panel.add(lblVeculo);
        
        cbVeiculos = new JComboBox<>(new String[]{"Selecione um veículo"});
        cbVeiculos.setFont(new Font("Tahoma", Font.BOLD, 13));
        cbVeiculos.setBounds(239, 102, 187, 25);
        panel.add(cbVeiculos);
        
        JLabel lblDataDeRetirada = new JLabel("Data de Retirada:");
        lblDataDeRetirada.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataDeRetirada.setBounds(23, 159, 199, 47);
        panel.add(lblDataDeRetirada);
        
        txtDataRetirada = new JTextField();
        txtDataRetirada.setBounds(239, 170, 187, 25);
        panel.add(txtDataRetirada);
        
        JLabel lblDataDeDevolucao = new JLabel("Data de Devolução:");
        lblDataDeDevolucao.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDataDeDevolucao.setBounds(23, 233, 199, 47);
        panel.add(lblDataDeDevolucao);
        
        txtDataDevolucao = new JTextField();
        txtDataDevolucao.setBounds(239, 244, 187, 25);
        panel.add(txtDataDevolucao);
        
        JLabel lblNumeroDeDias = new JLabel("Número de Dias:");
        lblNumeroDeDias.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNumeroDeDias.setBounds(23, 302, 199, 47);
        panel.add(lblNumeroDeDias);
        
        txtNumeroDias = new JTextField();
        txtNumeroDias.setBounds(239, 313, 187, 25);
        panel.add(txtNumeroDias);
        
        JLabel lblValorTotal = new JLabel("Valor Total:");
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorTotal.setBounds(23, 361, 199, 47);
        panel.add(lblValorTotal);
        
        txtValorTotal = new JTextField();
        txtValorTotal.setBounds(239, 374, 187, 25);
        txtValorTotal.setEditable(false);
        panel.add(txtValorTotal);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 0));
        buttonPanel.setBounds(0, 455, 464, 58);
        buttonPanel.setLayout(null);
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setBackground(Color.BLACK);
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnConfirmar.setBounds(118, 11, 98, 36);
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                    controller.registrarLocacao();
                }
            }
        });
        buttonPanel.add(btnConfirmar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(Color.BLACK);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCancelar.setBounds(236, 11, 98, 36);
        buttonPanel.add(btnCancelar);
        
        getContentPane().setLayout(null);
        getContentPane().add(panel);
        getContentPane().add(buttonPanel);
    }

    public void setController(LocacaoController controller) {
        this.controller = controller;
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
    
    public JTextField getTxtNumeroDias() {
        return txtNumeroDias;
    }
    
    public JTextField getTxtValorTotal() {
        return txtValorTotal;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaDeLocacao tela = new TelaDeLocacao();
                LocacaoController controller = new LocacaoController(tela);
                tela.setVisible(true);
            }
        });
    }
}