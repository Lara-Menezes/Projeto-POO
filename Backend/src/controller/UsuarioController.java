package controller;

import dao.UsuarioDAO;
import model.Usuario;
import Views.Interface.TelaCadastroUsers;
import Views.Interface.TelaIntermedioAdm;
import Views.Interface.TelaIntermedioAtendente;
import Views.Interface.TelaIntermedioGerente;
import Views.Interface.TelaLogin;

import javax.swing.*;
import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    private TelaCadastroUsers telaCadastroUsers;  
    private TelaLogin telaLogin;

    public UsuarioController() {
        this.usuarioDAO = UsuarioDAO.getInstance();  
    }

    // Tela de cadastro
    public void setTelaCadastroUsers(TelaCadastroUsers telaCadastroUsers) {
        this.telaCadastroUsers = telaCadastroUsers;  
        adicionarListeners(); 
    }
    
    //Tela de login
    public void setTelaLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;  
        adicionarListenersLogin();  
    }

    // listeners da tela de cadastro de users
    private void adicionarListeners() {
        telaCadastroUsers.getBtnCadastrar().addActionListener(e -> cadastrarUsuario());  
    }
    
    //listeners da tela de login
    private void adicionarListenersLogin() {
        telaLogin.getBtnEntrar().addActionListener(e -> autenticarUsuario());
    }
    


    // Método para cadastrar um usuário
    public void cadastrarUsuario() {
        String nomeUsuario = telaCadastroUsers.getTextNome().getText();  
        String senha = new String(telaCadastroUsers.getTextSenha().getPassword());  
        String perfil = (String) telaCadastroUsers.getComboPerfil().getSelectedItem();  

        Usuario usuario = new Usuario(nomeUsuario, senha, perfil);
        
        usuarioDAO.salvar(usuario); // Salva o usuário no json

        JOptionPane.showMessageDialog(telaCadastroUsers.getFrmCadastroDeUsurios(), 
                "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        // Limpa os campos 
        telaCadastroUsers.getTextNome().setText("");
        telaCadastroUsers.getTextSenha().setText("");
        telaCadastroUsers.getComboPerfil().setSelectedIndex(0); 
    }

    
    // Método de autenticação
    public void autenticarUsuario() {
        String usuario = telaLogin.getTextUsuario().getText();  
        String senha = new String(telaLogin.getPasswordSenha().getPassword()); 
        String perfil = (String) telaLogin.getComboPerfil().getSelectedItem(); 

        
        Usuario usuarioAutenticado = usuarioDAO.autenticar(usuario, senha, perfil); //chamada a função autenticar

        //define qual tela deve aparecer de acordo cm o perfil
        if (usuarioAutenticado != null && usuarioAutenticado.getPerfil().equals(perfil)) {
            if (perfil.equals("Administrador")) {
                TelaIntermedioAdm telaAdm = new TelaIntermedioAdm();
                //telaAdm.setVisible(true);
            } else if (perfil.equals("Gerente")) {
                TelaIntermedioGerente telaGerente = new TelaIntermedioGerente();
                telaGerente.setVisible(true);
            } else if (perfil.equals("Atendente")) {
                TelaIntermedioAtendente telaAtendente = new TelaIntermedioAtendente();
                //telaAtendente.setVisible();
            }
            telaLogin.dispose();  // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(telaLogin.getFrmLogin(), 
                    "Usuário ou senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    //lista todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar(Usuario.class);  
    }

    //Remove um usuário pelo nome
    public boolean removerUsuario(String nomeUsuario) {
        List<Usuario> usuarios = usuarioDAO.listar(Usuario.class); 

        for (Usuario u : usuarios) {
            if (u.getNomeUsuario().equals(nomeUsuario)) {  
                usuarioDAO.excluir(u);  // chamada ao método de exlcuir usuário
                return true; 
            }
        }
        return false;
    }
}

