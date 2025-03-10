package Views.Interface;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
import controller.VeiculoController;  
import model.Veiculo;

import java.awt.*; 
import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent; 
 
public class TelaCadastroVeiculo extends JFrame{  
    private JFrame frmCadastroDeVeiculos;  
    private JTextField txtPlaca;  
    private JTextField txtModelo; 
    private JTextField txtAno;  
    private JTable tabelaVeiculos;  
    private JComboBox<String> comboTipo;  
    private JComboBox<String> comboStatus;  
    private JButton btnSalvar;  
    private JButton btnEditar;  
    private JButton btnExcluir;  
    private JButton btnVoltar;  

    public TelaCadastroVeiculo() {  // Construtor da classe, onde os componentes da interface são inicializados.
        frmCadastroDeVeiculos = new JFrame();
        frmCadastroDeVeiculos.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroVeiculo.class.getResource("/Views/Images/veiculo.png")));  // Define o ícone da janela.
        frmCadastroDeVeiculos.setTitle("CADASTRO DE VEÍCULOS");  
        frmCadastroDeVeiculos.setBounds(100, 100, 620, 701);  
        frmCadastroDeVeiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        frmCadastroDeVeiculos.getContentPane().setLayout(null);  
        frmCadastroDeVeiculos.setLocationRelativeTo(null); 

        // Label e Campo para Placa
        JLabel lblPlaca = new JLabel("Placa:"); 
        lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));  
        lblPlaca.setBounds(20, 20, 100, 25);  
        frmCadastroDeVeiculos.getContentPane().add(lblPlaca);  

        txtPlaca = new JTextField();  
        txtPlaca.setBounds(130, 20, 150, 25);  
        frmCadastroDeVeiculos.getContentPane().add(txtPlaca); 
        txtPlaca.setColumns(10);  

        // Label e Campo para Modelo
        JLabel lblModelo = new JLabel("Modelo:");  
        lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));  
        lblModelo.setBounds(20, 60, 100, 25);  
        frmCadastroDeVeiculos.getContentPane().add(lblModelo);

        txtModelo = new JTextField(); 
        txtModelo.setBounds(130, 60, 150, 25);  
        frmCadastroDeVeiculos.getContentPane().add(txtModelo);  

        // Label e Campo para Ano
        JLabel lblAno = new JLabel("Ano:");  
        lblAno.setFont(new Font("Tahoma", Font.BOLD, 13));  
        lblAno.setBounds(20, 100, 100, 25); 
        frmCadastroDeVeiculos.getContentPane().add(lblAno);  

        txtAno = new JTextField();  
        txtAno.setBounds(130, 100, 150, 25); 
        frmCadastroDeVeiculos.getContentPane().add(txtAno);  

        // ComboBox para Tipo de Veículo
        JLabel lblTipo = new JLabel("Tipo:");  
        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));  
        lblTipo.setBounds(20, 140, 100, 25);  
        frmCadastroDeVeiculos.getContentPane().add(lblTipo);  

        comboTipo = new JComboBox<>(new String[]{"Carro", "Moto", "Caminhão"});  
        comboTipo.setBounds(130, 140, 150, 25);
        frmCadastroDeVeiculos.getContentPane().add(comboTipo);  

        // ComboBox para Status
        JLabel lblStatus = new JLabel("Status:");  
        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));  
        lblStatus.setBounds(20, 180, 100, 25);  
        frmCadastroDeVeiculos.getContentPane().add(lblStatus);  

        comboStatus = new JComboBox<>(new String[]{"Disponível", "Locado"});  
        comboStatus.setBounds(130, 180, 150, 25);  
        frmCadastroDeVeiculos.getContentPane().add(comboStatus); 

        // Botão Salvar
        btnSalvar = new JButton("Salvar");  
        btnSalvar.setBackground(new Color(255, 255, 0));  
        btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));  
        btnSalvar.setBounds(20, 220, 120, 30);  
        frmCadastroDeVeiculos.getContentPane().add(btnSalvar); 

        // Botão Editar
        btnEditar = new JButton("Editar"); 
        btnEditar.setBackground(new Color(255, 255, 0));  
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));  
        btnEditar.setBounds(150, 220, 120, 30); 
        frmCadastroDeVeiculos.getContentPane().add(btnEditar);  

        // Botão Excluir
        btnExcluir = new JButton("Excluir");  
        btnExcluir.setBackground(new Color(255, 255, 0));  
        btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));  
        btnExcluir.setBounds(280, 220, 120, 30);  
        frmCadastroDeVeiculos.getContentPane().add(btnExcluir);  

        // Botão Voltar
        btnVoltar = new JButton("Voltar");  
        btnVoltar.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {  
        		TelaIntermedioGerente telainter = new TelaIntermedioGerente();  
        		telainter.setVisible(true);  
        		frmCadastroDeVeiculos.dispose();  
        	}
        });
        btnVoltar.setForeground(new Color(255, 255, 255)); 
        btnVoltar.setBackground(new Color(255, 0, 0));  
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));  
        btnVoltar.setBounds(410, 220, 120, 30);  
        frmCadastroDeVeiculos.getContentPane().add(btnVoltar);  

        // Tabela para Listar Veículos
        JScrollPane scrollPane = new JScrollPane();  
        scrollPane.setBounds(20, 260, 540, 334);  
        frmCadastroDeVeiculos.getContentPane().add(scrollPane);  

        tabelaVeiculos = new JTable();  
        tabelaVeiculos.setModel(new DefaultTableModel(  
                new Object[][]{},  
                new String[]{"Placa", "Modelo", "Ano", "Tipo", "Status"}
        ));
        scrollPane.setViewportView(tabelaVeiculos);  // A tabela é adicionada dentro da barra de rolagem.

        JPanel panel = new JPanel();  
        panel.setBackground(new Color(255, 255, 0));  
        panel.setBounds(0, 619, 604, 43); 
        frmCadastroDeVeiculos.getContentPane().add(panel);  // Adiciona o painel à tela.
    }
    
    public void preencherTabela() {  // Método para preencher a tabela com a lista de veículos.
        VeiculoController controller = new VeiculoController();
        // Chama o método do controlador para listar os veículos
        java.util.List<Veiculo> veiculos = controller.Listarveiculos();  
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaVeiculos.getModel();  // Obtém o modelo da tabela
        modelo.setRowCount(0);  // Limpa qualquer dado antigo na tabela

        // Preenche a tabela com os dados dos veículos
        for (Veiculo veiculo : veiculos) {
            modelo.addRow(new Object[]{  
                veiculo.getPlaca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getTipo(),
                veiculo.getStatus()
            });
        }
    }

    //getters dos botões e textfields
    public void exibirTela() {  
        frmCadastroDeVeiculos.setVisible(true);
    }

    public JButton getBtnSalvar() {  
        return btnSalvar;
    }

    public JButton getBtnEditar() {  
        return btnEditar;
    }

    public JButton getBtnExcluir() {  
        return btnExcluir;
    }

    public JButton getBtnVoltar() {  
        return btnVoltar;
    }

    public JTextField getTxtPlaca() {  
        return txtPlaca;
    }

    public JTextField getTxtModelo() {  
        return txtModelo;
    }

    public JTextField getTxtAno() {  
        return txtAno;
    }

    public JComboBox<String> getComboTipo() {  
        return comboTipo;
    }

    public JComboBox<String> getComboStatus() {  
        return comboStatus;
    }

    public JTable getTabelaVeiculos() {  
        return tabelaVeiculos;
    }
    
    public JFrame getFrmCadastroDeVeiculos() {
        return frmCadastroDeVeiculos;
    }
    
    public static void main(String[] args) {
        TelaCadastroVeiculo telaCadastroVeiculo = new TelaCadastroVeiculo();  // Cria uma instância da tela.
        VeiculoController controller = new VeiculoController();  // Cria uma instância do controller.
        controller.setTelaCadastroVeiculo(telaCadastroVeiculo);  // Associa a tela ao controller.
        telaCadastroVeiculo.exibirTela();  // Exibe a tela de cadastro de veículos.
        telaCadastroVeiculo.preencherTabela();
    }

}
