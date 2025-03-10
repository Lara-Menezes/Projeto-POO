package dao;

import model.Usuario;
import java.util.List;

public class UsuarioDAO extends baseDAO<Usuario> {

    private static UsuarioDAO instance;

    private UsuarioDAO() {
        super("data/usuarios.json", Usuario.class); 
    }
    
    //Apenas uma instância de uma classe existe - padrão Singleton
    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    // Método para autenticação de usuário
    public Usuario autenticar(String nomeUsuario, String senha, String perfil) {
        List<Usuario> usuarios = listar();
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha) && usuario.getPerfil().equals(perfil)) {
                return usuario;
            }
        }
        return null; 
    }
}

