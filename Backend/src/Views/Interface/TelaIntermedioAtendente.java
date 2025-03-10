package Views.Interface;

import java.awt.EventQueue; // Importa a classe EventQueue para gerenciar a execução dos eventos da interface gráfica.
import javax.swing.JButton; // Importa a classe JButton para criar botões na interface gráfica.
import javax.swing.JFrame; // Importa a classe JFrame para criar uma janela principal.

import controller.LocacaoController;
import controller.VeiculoController;

import java.awt.event.ActionListener; // Importa a interface ActionListener para tratar eventos de ação como o clique de um botão.
import java.awt.event.ActionEvent; // Importa a classe ActionEvent para tratar os eventos acionados pelos botões.
import java.awt.Font; // Importa a classe Font para configurar as fontes dos componentes gráficos.
import java.awt.Color; // Importa a classe Color para definir as cores dos componentes gráficos.
import java.awt.Toolkit; // Importa a classe Toolkit para manipular recursos como ícones da janela.

public class TelaIntermedioAtendente extends JFrame{ // A classe TelaIntermedioAtendente representa a tela que o atendente irá interagir.

    private JFrame frmTelaAtendente; // Declara a variável que representa a janela principal.

    public static void main(String[] args) { // O método main inicia a execução da aplicação.
        EventQueue.invokeLater(new Runnable() { // Executa a criação da interface gráfica na thread de eventos do Swing.
            public void run() { // Executa o código na thread de eventos.
                try {
                    TelaIntermedioAtendente window = new TelaIntermedioAtendente(); // Cria uma nova instância da tela do atendente.
                    window.frmTelaAtendente.setVisible(true); // Torna a janela visível.
                } catch (Exception e) { // Caso ocorra algum erro, imprime a pilha de exceções.
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaIntermedioAtendente() { // Construtor da classe que chama o método de inicialização da interface gráfica.
        initialize();
    }

    private void initialize() { // Método para inicializar todos os componentes da interface gráfica.
        frmTelaAtendente = new JFrame(); // Cria a instância da janela principal.
        frmTelaAtendente.setTitle("TELA ATENDENTE"); // Define o título da janela como "TELA ATENDENTE".
        frmTelaAtendente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaIntermedioAtendente.class.getResource("/Views/Images/veiculo.png"))); // Define o ícone da janela, que está localizado no diretório de imagens.
        frmTelaAtendente.setBounds(100, 100, 450, 434); // Define a posição e o tamanho da janela (posição x: 100, y: 100, largura: 450, altura: 434).
        frmTelaAtendente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que, ao fechar a janela, o aplicativo será encerrado.
        frmTelaAtendente.getContentPane().setLayout(null); // Define o layout da janela como nulo, permitindo a configuração manual de posições.
        frmTelaAtendente.setVisible(true); // Torna a janela visível.
        frmTelaAtendente.setLocationRelativeTo(null); // Centraliza a janela na tela.

     // Criação do botão "DEVOLUÇÃO" na tela de atendente
        JButton btnDevolucao = new JButton("DEVOLUÇÃO"); // Cria o botão com o texto "DEVOLUÇÃO".
        btnDevolucao.setBackground(new Color(255, 255, 0)); // Define a cor de fundo do botão como amarelo.
        btnDevolucao.setFont(new Font("Tahoma", Font.BOLD, 13)); // Define a fonte do botão (Tahoma, negrito, tamanho 13).
        btnDevolucao.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão.
            public void actionPerformed(ActionEvent e) {
                // Cria a instância do controlador de devolução
                LocacaoController locacaoController = new LocacaoController();
                TelaDevolucao telaDevolucao = new TelaDevolucao();
                locacaoController.setTelaDevolucao(telaDevolucao);
                telaDevolucao.exibirTela();
                frmTelaAtendente.dispose();
            }
        });


        btnDevolucao.setBackground(new Color(255, 255, 0)); // Define a cor de fundo do botão como amarelo.
        btnDevolucao.setFont(new Font("Tahoma", Font.BOLD, 13)); // Define a fonte do botão (Tahoma, negrito, tamanho 13).
        btnDevolucao.setBounds(134, 50, 167, 49); // Define as posições e o tamanho do botão (x: 134, y: 50, largura: 167, altura: 49).
        frmTelaAtendente.getContentPane().add(btnDevolucao); // Adiciona o botão à janela principal.

        JButton btnListagem = new JButton("LISTAGEM"); // Cria o botão com o texto "LISTAGEM".
        btnListagem.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão.
        	public void actionPerformed(ActionEvent e) { // Quando o botão for clicado, a ação é executada.
        		VeiculoController veiculoController = new VeiculoController();
        		TelaListagem telalistagem = new TelaListagem(veiculoController); // Cria uma instância da tela de listagem.             //EU MUDEI AQUI Ó
        		telalistagem.exibirTela(); // Torna a tela de listagem visível.
        		frmTelaAtendente.dispose(); // Fecha a janela atual (tela do atendente).
        	}
        });
        btnListagem.setBackground(new Color(255, 255, 0)); // Define a cor de fundo do botão como amarelo.
        btnListagem.setFont(new Font("Tahoma", Font.BOLD, 13)); // Define a fonte do botão (Tahoma, negrito, tamanho 13).
        btnListagem.setBounds(134, 109, 167, 50); // Define as posições e o tamanho do botão (x: 134, y: 109, largura: 167, altura: 50).
        frmTelaAtendente.getContentPane().add(btnListagem); // Adiciona o botão à janela principal.

        JButton btnLocacao = new JButton("LOCAÇÃO"); // Cria o botão com o texto "LOCAÇÃO".
        btnLocacao.setBackground(new Color(255, 255, 0)); // Define a cor de fundo do botão como amarelo.
        btnLocacao.setFont(new Font("Tahoma", Font.BOLD, 13)); // Define a fonte do botão (Tahoma, negrito, tamanho 13).
        btnLocacao.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão.
        	public void actionPerformed(ActionEvent e) {
                LocacaoController locacaoController = new LocacaoController();
                TelaDeLocacao telaLocacao = new TelaDeLocacao();
                locacaoController.setTelaDeLocacao(telaLocacao);  
                telaLocacao.exibirTela();
                
                frmTelaAtendente.dispose(); // Fecha a janela atual (tela do atendente).
        	}
        });
        btnLocacao.setBounds(134, 229, 167, 49); // Define as posições e o tamanho do botão (x: 134, y: 229, largura: 167, altura: 49).
        frmTelaAtendente.getContentPane().add(btnLocacao); // Adiciona o botão à janela principal.

        JButton btnPagamentos = new JButton("PAGAMENTOS"); // Cria o botão com o texto "PAGAMENTOS".
        btnPagamentos.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão.
        	public void actionPerformed(ActionEvent e) { // Quando o botão for clicado, a ação é executada.
        		TelaPagamentos telapagamentos = new TelaPagamentos(); // Cria uma instância da tela de pagamentos.
        		telapagamentos.exibirTela(); // Torna a tela de pagamentos visível.
        		frmTelaAtendente.dispose(); // Fecha a janela atual (tela do atendente).
        	}
        });
        btnPagamentos.setBackground(new Color(255, 255, 0)); // Define a cor de fundo do botão como amarelo.
        btnPagamentos.setFont(new Font("Tahoma", Font.BOLD, 13)); // Define a fonte do botão (Tahoma, negrito, tamanho 13).
        btnPagamentos.setBounds(134, 170, 167, 49); // Define as posições e o tamanho do botão (x: 134, y: 170, largura: 167, altura: 49).
        frmTelaAtendente.getContentPane().add(btnPagamentos); // Adiciona o botão à janela principal.
        
        JButton btnVoltar = new JButton("VOLTAR"); // Cria o botão com o texto "VOLTAR".
        btnVoltar.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão "Voltar".
        	public void actionPerformed(ActionEvent e) { // Quando o botão for clicado, a ação é executada.
        		TelaLogin telapage = new TelaLogin(); // Cria uma instância da tela anterior (TelaPage).
        		telapage.setVisible(true); // Torna a tela anterior visível.
        		frmTelaAtendente.dispose(); // Fecha a janela atual (tela do atendente).
        	}
        });
        btnVoltar.setForeground(Color.WHITE); // Define a cor do texto do botão como branco.
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13)); // Define a fonte do botão (Tahoma, negrito, tamanho 13).
        btnVoltar.setBackground(Color.RED); // Define a cor de fundo do botão como vermelho.
        btnVoltar.setBounds(10, 364, 88, 20); // Define as posições e o tamanho do botão (x: 10, y: 364, largura: 88, altura: 20).
        frmTelaAtendente.getContentPane().add(btnVoltar); // Adiciona o botão "Voltar" à janela principal.
    }

    public void setVisible() { // Método que define a visibilidade da janela, mas neste caso não faz nada.
		frmTelaAtendente.setVisible(true);
    }
}