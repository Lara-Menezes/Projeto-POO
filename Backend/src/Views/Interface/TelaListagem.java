package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaListagem extends JFrame {
    private JTable tabelaDisponiveis;
    private JTable tabelaLocados;
    private JButton btnAtualizar;

    public TelaListagem() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListagem.class.getResource("/Images/veiculo.png")));
        setTitle("LISTAGEM DE VEÍCULOS");
        setSize(603, 743);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Painel principal com layout vertical
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 584, 704);

        // Tabelas de veículos disponíveis e locados
        tabelaDisponiveis = new JTable(new DefaultTableModel(new Object[]{"Placa", "Modelo", "Ano"}, 0));

        // Adicionando tabelas dentro de painéis de rolagem
        JScrollPane scrollDisponiveis = new JScrollPane(tabelaDisponiveis);
        scrollDisponiveis.setBounds(10, 38, 564, 271);

        // Criando painéis para organizar os componentes
        JPanel panelDisponiveis = new JPanel();
        panelDisponiveis.setBounds(0, 0, 584, 704);
        panelDisponiveis.setLayout(null);
        JLabel label = new JLabel("Veículos Disponíveis");
        label.setFont(new Font("Tahoma", Font.BOLD, 13));
        label.setBackground(new Color(255, 255, 0));
        label.setOpaque(true);
        label.setBounds(10, 0, 564, 27);
        panelDisponiveis.add(label);
        panelDisponiveis.add(scrollDisponiveis);

        // Botão de atualização
        btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.setBounds(0, 882, 584, 23);
        panel.setLayout(null);

        // Adicionando componentes ao painel principal
        panel.add(panelDisponiveis);
        tabelaLocados = new JTable(new DefaultTableModel(new Object[]{"Placa", "Modelo", "Ano", "Cliente"}, 0));
        JScrollPane scrollLocados = new JScrollPane(tabelaLocados);
        scrollLocados.setBounds(10, 368, 564, 325);
        panelDisponiveis.add(scrollLocados);
        
                JPanel panelLocados = new JPanel();
                panelLocados.setBounds(-10, 320, 584, 37);
                panelDisponiveis.add(panelLocados);
                panelLocados.setLayout(null);
                
                JLabel lblVeculosLocados = new JLabel("Veículos Locados:");
                lblVeculosLocados.setFont(new Font("Tahoma", Font.BOLD, 13));
                lblVeculosLocados.setBackground(new Color(255, 255, 0));
                lblVeculosLocados.setOpaque(true);
                lblVeculosLocados.setBounds(20, 0, 564, 37);
                panelLocados.add(lblVeculosLocados);
        panel.add(btnAtualizar);

        // Adicionando painel à janela
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaListagem().setVisible(true));
    }
}