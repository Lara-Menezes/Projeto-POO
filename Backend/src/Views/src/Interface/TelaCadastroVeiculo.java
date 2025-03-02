package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaCadastroVeiculo extends JFrame {
    private JTextField txtPlaca;
    private JTextField txtModelo;
    private JTextField txtAno;
    private JTable tabelaVeiculos;
    private JComboBox<String> comboTipo;
    private JComboBox<String> comboStatus;

    public TelaCadastroVeiculo() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroVeiculo.class.getResource("/Images/veiculo.png")));
        setTitle("CADASTRO DE VEÍCULOS");
        setBounds(100, 100, 620, 701);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        // Label e Campo para Placa
        JLabel lblPlaca = new JLabel("Placa:");
        lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPlaca.setBounds(20, 20, 100, 25);
        getContentPane().add(lblPlaca);

        txtPlaca = new JTextField();
        txtPlaca.setBounds(130, 20, 150, 25);
        getContentPane().add(txtPlaca);
        txtPlaca.setColumns(10);

        // Label e Campo para Modelo
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblModelo.setBounds(20, 60, 100, 25);
        getContentPane().add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(130, 60, 150, 25);
        getContentPane().add(txtModelo);

        // Label e Campo para Ano
        JLabel lblAno = new JLabel("Ano:");
        lblAno.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAno.setBounds(20, 100, 100, 25);
        getContentPane().add(lblAno);

        txtAno = new JTextField();
        txtAno.setBounds(130, 100, 150, 25);
        getContentPane().add(txtAno);

        // ComboBox para Tipo de Veículo
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTipo.setBounds(20, 140, 100, 25);
        getContentPane().add(lblTipo);

        comboTipo = new JComboBox<>(new String[]{"Carro", "Moto", "Caminhão"});
        comboTipo.setBounds(130, 140, 150, 25);
        getContentPane().add(comboTipo);

        // ComboBox para Status
        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStatus.setBounds(20, 180, 100, 25);
        getContentPane().add(lblStatus);

        comboStatus = new JComboBox<>(new String[]{"Disponível", "Locado"});
        comboStatus.setBounds(130, 180, 150, 25);
        getContentPane().add(comboStatus);

        // Botão Salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(new Color(255, 255, 0));
        btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSalvar.setBounds(20, 220, 120, 30);
        getContentPane().add(btnSalvar);

        // Botão Editar
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBackground(new Color(255, 255, 0));
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEditar.setBounds(150, 220, 120, 30);
        getContentPane().add(btnEditar);

        // Botão Excluir
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBackground(new Color(255, 255, 0));
        btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnExcluir.setBounds(280, 220, 120, 30);
        getContentPane().add(btnExcluir);

        // Botão Voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(255, 255, 0));
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(410, 220, 120, 30);
        getContentPane().add(btnVoltar);

        // Tabela para Listar Veículos
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 260, 540, 334);
        getContentPane().add(scrollPane);

        tabelaVeiculos = new JTable();
        tabelaVeiculos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Placa", "Modelo", "Ano", "Tipo", "Status"}
        ));
        scrollPane.setViewportView(tabelaVeiculos);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 0));
        panel.setBounds(0, 619, 604, 43);
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroVeiculo().setVisible(true));
    }
}
