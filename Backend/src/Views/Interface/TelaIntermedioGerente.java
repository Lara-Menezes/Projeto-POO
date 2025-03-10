package Views.Interface;

import java.awt.EventQueue;  // Importa a classe EventQueue, usada para agendar a execução de um thread de evento.
import javax.swing.JButton;  // Importa a classe JButton para criação de botões.
import javax.swing.JFrame;  // Importa a classe JFrame para criar uma janela.
import javax.swing.JOptionPane;

import controller.LocacaoController;
import controller.PagamentoController;
import controller.VeiculoController;

import java.awt.event.ActionListener;  // Importa a interface ActionListener para monitorar ações do usuário nos botões.
import java.awt.event.ActionEvent;  // Importa a classe ActionEvent, usada para capturar o evento gerado ao clicar no botão.
import java.awt.Font;  // Importa a classe Font, usada para personalizar as fontes.
import java.awt.Color;  // Importa a classe Color para definir cores.
import java.awt.Toolkit;  // Importa a classe Toolkit, usada para obter a imagem do ícone da janela.

public class TelaIntermedioGerente extends JFrame{  // Define a classe TelaIntermedioGerente, que representa a tela principal do gerente.

    private JFrame frmTelaGerente;  // Declara a variável frmTelaGerente, do tipo JFrame, que é a janela principal da interface gráfica.
    public static void main(String[] args) {  // Método main, que serve como ponto de entrada do programa.
        EventQueue.invokeLater(new Runnable() {  // Executa a criação da janela em um thread de evento da fila de eventos.
            public void run() {  // Define a execução dentro do método run.
                try {
                    TelaIntermedioGerente window = new TelaIntermedioGerente();  // Cria uma instância de TelaIntermedioGerente.
                    window.frmTelaGerente.setVisible(true);  // Torna a janela visível.
                } catch (Exception e) {  // Se ocorrer algum erro, ele será capturado aqui.
                    e.printStackTrace();  // Exibe o rastreamento de erro no console.
                }
            }
        });
    }
    public TelaIntermedioGerente() {  // Construtor da classe TelaIntermedioGerente, usado para inicializar a interface.
        initialize();  // Chama o método initialize para configurar os componentes da tela.
    }

    private void initialize() {  // Método initialize para configurar os componentes da interface gráfica.
        frmTelaGerente = new JFrame();  // Cria uma nova instância da janela JFrame.
        frmTelaGerente.setTitle("TELA GERENTE");  // Define o título da janela.
        frmTelaGerente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaIntermedioGerente.class.getResource("/Views/Images/veiculo.png")));  // Define o ícone da janela.
        frmTelaGerente.setBounds(100, 100, 450, 340);  // Define as dimensões e a posição inicial da janela.
        frmTelaGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Define a operação de fechamento da janela (termina o aplicativo ao fechar a janela).
        frmTelaGerente.getContentPane().setLayout(null);  // Define o layout da janela para null, permitindo o posicionamento manual dos componentes.
        frmTelaGerente.setLocationRelativeTo(null);  // Define que a janela será centralizada na tela.
        
        // Botão para cadastrar veículos
        JButton btnCadastrarVeiculos = new JButton("CADASTRAR VEÍCULOS");  // Cria um botão com o texto "CADASTRAR VEÍCULOS".
        btnCadastrarVeiculos.addActionListener(new ActionListener() {  // Adiciona um ouvinte de ação ao botão.
            public void actionPerformed(ActionEvent e) {  // Quando o botão for clicado, executa o código dentro deste método.
                TelaCadastroVeiculo telaCadastroVeiculo = new TelaCadastroVeiculo();  // Cria uma nova instância da tela de cadastro de veículos.
                
                // Cria uma nova instância do VeiculoController e associa a tela de cadastro a ele
                VeiculoController controller = new VeiculoController();
                controller.setTelaCadastroVeiculo(telaCadastroVeiculo);  // Passa a tela para o controller
                telaCadastroVeiculo.exibirTela();  // Torna a tela de cadastro de veículos visível.
                telaCadastroVeiculo.preencherTabela();
                
                frmTelaGerente.setVisible(false);  // Oculta a janela atual (Tela do Gerente).
            }
        });
        
        btnCadastrarVeiculos.setBackground(new Color(255, 255, 0));  // Define a cor de fundo do botão como amarelo.
        btnCadastrarVeiculos.setFont(new Font("Tahoma", Font.BOLD, 13));  // Define a fonte do botão para o estilo Tahoma, em negrito e tamanho 13.
        btnCadastrarVeiculos.setBounds(116, 51, 204, 48);  // Define a posição e o tamanho do botão na janela.
        frmTelaGerente.getContentPane().add(btnCadastrarVeiculos);  // Adiciona o botão à janela.

        // Botão para cadastrar clientes
        JButton btnCadastrarClientes = new JButton("CADASTRAR CLIENTES");  // Cria um botão com o texto "CADASTRAR CLIENTES".
        btnCadastrarClientes.addActionListener(new ActionListener() {  // Adiciona um ouvinte de ação ao botão.
        	public void actionPerformed(ActionEvent e) {  // Quando o botão for clicado, executa o código dentro deste método.
        		TelaCadastroCliente telacliente = new TelaCadastroCliente();  // Cria uma nova instância da tela de cadastro de clientes.
        		telacliente.exibirTela();  // Torna a tela de cadastro de clientes visível.
        		frmTelaGerente.setVisible(false);  // Oculta a janela atual (Tela do Gerente).
        	}
        });
        btnCadastrarClientes.setBackground(new Color(255, 255, 0));  // Define a cor de fundo do botão como amarelo.
        btnCadastrarClientes.setFont(new Font("Tahoma", Font.BOLD, 13));  // Define a fonte do botão para o estilo Tahoma, em negrito e tamanho 13.
        btnCadastrarClientes.setBounds(116, 109, 204, 48);  // Define a posição e o tamanho do botão na janela.
        frmTelaGerente.getContentPane().add(btnCadastrarClientes);  // Adiciona o botão à janela.

        // Botão para visualizar relatórios
        JButton btnVisualizarRelatorios = new JButton("VISUALIZAR RELATÓRIOS");  // Cria um botão com o texto "VISUALIZAR RELATÓRIOS".
        btnVisualizarRelatorios.addActionListener(new ActionListener() {  // Adiciona um ouvinte de ação ao botão.
            public void actionPerformed(ActionEvent e) {  // Quando o botão for clicado, executa o código dentro deste método.
                
                // Cria as instâncias dos controllers
                LocacaoController locacaoController = new LocacaoController();
                PagamentoController pagamentoController = new PagamentoController();  // Caso precise usar o PagamentoController também.
                
                // Chama as funções de geração de relatórios de locação e pagamento
                boolean locacaoRelatoriosGerados = locacaoController.gerarRelatorios(); 
                if (locacaoRelatoriosGerados) {
                    JOptionPane.showMessageDialog(frmTelaGerente, "Relatórios de Locação gerados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Se ocorrer algum erro ao gerar os relatórios de locação, exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(frmTelaGerente, "Falha ao gerar relatórios de Locação.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
                boolean pagamentoRelatorioGerado = pagamentoController.gerarRelatorioFaturamento();
                if (pagamentoRelatorioGerado) {
                    JOptionPane.showMessageDialog(frmTelaGerente, "Relatório de Pagamento gerado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frmTelaGerente, "Falha ao gerar relatório de Pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        btnVisualizarRelatorios.setBackground(new Color(255, 255, 0));  // Define a cor de fundo do botão como amarelo.
        btnVisualizarRelatorios.setFont(new Font("Tahoma", Font.BOLD, 13));  // Define a fonte do botão para o estilo Tahoma, em negrito e tamanho 13.
        btnVisualizarRelatorios.setBounds(116, 168, 204, 48);  // Define a posição e o tamanho do botão na janela.
        frmTelaGerente.getContentPane().add(btnVisualizarRelatorios);  // Adiciona o botão à janela.
        
        // Botão para voltar
        JButton btnVoltar = new JButton("VOLTAR");  // Cria um botão com o texto "VOLTAR".
        btnVoltar.addActionListener(new ActionListener() {  // Adiciona um ouvinte de ação ao botão.
        	public void actionPerformed(ActionEvent e) {  // Quando o botão for clicado, executa o código dentro deste método.
        		TelaLogin telapage = new TelaLogin();  // Cria uma nova instância da tela principal (TelaPage).
        		telapage.setVisible(true);  // Torna a tela principal visível.
        		frmTelaGerente.setVisible(false);  // Oculta a janela atual (Tela do Gerente).
        	}
        });
        btnVoltar.setForeground(Color.WHITE);  // Define a cor do texto do botão como branco.
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));  // Define a fonte do botão para o estilo Tahoma, em negrito e tamanho 13.
        btnVoltar.setBackground(Color.RED);  // Define a cor de fundo do botão como vermelho.
        btnVoltar.setBounds(10, 270, 88, 20);  // Define a posição e o tamanho do botão na janela.
        frmTelaGerente.getContentPane().add(btnVoltar);  // Adiciona o botão à janela.
    }

    public void setVisible(boolean b) {  // Define o método setVisible para controlar a visibilidade da tela.
        frmTelaGerente.setVisible(b);  // Torna a janela visível ou invisível dependendo do valor de 'b'.
    }
}