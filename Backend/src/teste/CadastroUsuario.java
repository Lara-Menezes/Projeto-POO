package teste;

import java.util.List;
import controller.UsuarioController;
import model.Usuario;

public class CadastroUsuario {
    public static void main(String[] args) {
        UsuarioController controller = new UsuarioController();

        // Teste de cadastro de usuários
        System.out.println("Cadastrando usuários...");
        controller.cadastrarUsuario("admin", "admin123", "Administrador");
        controller.cadastrarUsuario("jose", "senha123", "Funcionário");
        controller.cadastrarUsuario("maria", "senha456", "Gerente");

        // Teste de listagem de usuários
        System.out.println("\nLista de usuários cadastrados:");
        List<Usuario> usuarios = controller.listarUsuarios();
        for (Usuario u : usuarios) {
            System.out.println(u);
        }

        // Teste de autenticação de usuário
        System.out.println("\nTentando autenticar usuário 'admin' com a senha 'admin123':");
        Usuario usuarioAutenticado = controller.autenticar("admin", "admin123");
        System.out.println(usuarioAutenticado != null ? "Usuário autenticado: " + usuarioAutenticado : "Falha na autenticação!");

        // Tentando autenticar com dados incorretos
        System.out.println("\nTentando autenticar usuário 'jose' com a senha errada:");
        Usuario usuarioInvalido = controller.autenticar("jose", "senhaErrada");
        System.out.println(usuarioInvalido != null ? "Usuário autenticado: " + usuarioInvalido : "Falha na autenticação!");

        // Teste de remoção de usuário
        System.out.println("\nRemovendo usuário 'jose':");
        boolean removido = controller.removerUsuario("jose");
        System.out.println(removido ? "Usuário removido com sucesso!" : "Usuário não encontrado!");

        // Exibindo lista após remoção
        System.out.println("\nLista de usuários após remoção:");
        usuarios = controller.listarUsuarios();
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
}
