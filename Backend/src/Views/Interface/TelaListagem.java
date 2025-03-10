package Views.Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.VeiculoController;
import model.Veiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaListagem extends JFrame{

    private JFrame frmListagem;
    private JTable tabelaDisponiveis;
    private JTable tabelaLocados;
    private JButton btnAtualizar;
    private VeiculoController veiculoController;

    // Modifique o construtor para receber o VeiculoController
    public TelaListagem(VeiculoController veiculoController) {
        this.veiculoController = veiculoController; // Armazena o controller na variável de instância
        initialize();
    }

    private void initialize() {
        frmListagem = new JFrame();
        frmListagem.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListagem.class.getResource("/Views/Images/veiculo.png")));
        frmListagem.setTitle("LISTAGEM DE VEÍCULOS");
        frmListagem.setSize(603, 798);
        frmListagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmListagem.setLocationRelativeTo(null);
        frmListagem.getContentPane().setLayout(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 584, 704);

        // Tabelas de veículos disponíveis e locados
        tabelaDisponiveis = new JTable(new DefaultTableModel(new Object[]{"Placa", "Modelo", "Ano"}, 0));
        JScrollPane scrollDisponiveis = new JScrollPane(tabelaDisponiveis);
        scrollDisponiveis.setBounds(10, 38, 564, 271);

        // Criando painel para veículos disponíveis
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

        panel.setLayout(null);
        panel.add(panelDisponiveis);

        // Tabela de veículos locados
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

        // Botão de atualização
        btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.setBounds(0, 715, 584, 23);
        panel.add(btnAtualizar);

        // Botão de voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaIntermedioAtendente telainter = new TelaIntermedioAtendente();
                telainter.setVisible();
                frmListagem.dispose();
            }
        });
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBackground(Color.RED);
        btnVoltar.setBounds(246, 715, 88, 25);
        frmListagem.getContentPane().add(btnVoltar);

        // Adiciona o painel à janela
        frmListagem.getContentPane().add(panel);

        // Configura o botão de atualização para carregar as listas ao ser clicado
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabelas();
            }
        });

        // Exibe as tabelas com os dados iniciais
        atualizarTabelas();
    }

    // Atualiza as tabelas com os dados dos veículos
    private void atualizarTabelas() {
        // Atualiza os veículos disponíveis
        List<Veiculo> veiculosDisponiveis = veiculoController.listarVeiculosDisponiveis();
        DefaultTableModel modeloDisponiveis = (DefaultTableModel) tabelaDisponiveis.getModel();
        modeloDisponiveis.setRowCount(0); // Limpa a tabela
        for (Veiculo veiculo : veiculosDisponiveis) {
            modeloDisponiveis.addRow(new Object[]{veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAno()});
        }

        // Atualiza os veículos locados
        List<Veiculo> veiculosLocados = veiculoController.listarVeiculosLocados();
        DefaultTableModel modeloLocados = (DefaultTableModel) tabelaLocados.getModel();
        modeloLocados.setRowCount(0); // Limpa a tabela
        for (Veiculo veiculo : veiculosLocados) {
            modeloLocados.addRow(new Object[]{veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getModelo()});
        }
    }

    // Método para exibir a janela
    public void exibirTela() {
        frmListagem.setVisible(true);
    }

    // Métodos de acesso aos componentes (getters)
    public JTable getTabelaDisponiveis() {
        return tabelaDisponiveis;
    }

    public JTable getTabelaLocados() {
        return tabelaLocados;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JFrame getFrmListagem() {
        return frmListagem;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VeiculoController veiculoController = new VeiculoController(); // Cria o controlador
            TelaListagem telaListagem = new TelaListagem(veiculoController); // Passa o controlador para a tela
            telaListagem.exibirTela(); // Torna a tela de listagem visível
        });
    }
}
