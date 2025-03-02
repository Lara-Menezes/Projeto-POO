package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Usuario;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements Persistencia<Usuario> {
    private static UsuarioDAO instancia;
    private static final String FILE_NAME = "data/usuarios.json";
    private Gson gson = new Gson();

    private UsuarioDAO() {}

    public static UsuarioDAO getInstance() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    @Override
    public void salvar(List<Usuario> lista) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> carregar() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type tipoLista = new TypeToken<ArrayList<Usuario>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // 🔐 Método para autenticação de usuário
    public Usuario autenticar(String nomeUsuario, String senha) {
        List<Usuario> usuarios = carregar();
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                return usuario; // Usuário autenticado com sucesso
            }
        }
        return null; // Falha na autenticação
    }
}

