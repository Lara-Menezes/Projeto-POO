package dao;

import model.Usuario;
import java.util.List;

public class UsuarioDAO extends baseDAO<Usuario> {

    private static UsuarioDAO instance;

    private UsuarioDAO() {
        super("src/data/usuarios.json", Usuario.class); 
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    // Método para autenticação de usuário
    public Usuario autenticar(String nomeUsuario, String senha) {
        List<Usuario> usuarios = listar();
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null; 
    }
}

