package controller;

import dao.UsuarioDAO;
import model.Usuario;
import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = UsuarioDAO.getInstance(); 
    }

    public void cadastrarUsuario(String nomeUsuario, String senha, String perfil) {
        Usuario usuario = new Usuario(nomeUsuario, senha, perfil);
        usuarioDAO.salvar(usuario);
    }

    public Usuario autenticar(String nomeUsuario, String senha) {
        // Delegar autenticação ao DAO
        return usuarioDAO.autenticar(nomeUsuario, senha);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar(Usuario.class);
    }

    public boolean removerUsuario(String nomeUsuario) {
        List<Usuario> usuarios = usuarioDAO.listar(Usuario.class);
        for (Usuario u : usuarios) {
            if (u.getNomeUsuario().equals(nomeUsuario)) {
                usuarioDAO.excluir(u);
                return true;
            }
        }
        return false; 
    }
}
