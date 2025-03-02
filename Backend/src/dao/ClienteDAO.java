package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Cliente;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements Persistencia<Cliente> {
    private static ClienteDAO instancia;
    private static final String FILE_NAME = "data/clientes.json";
    private Gson gson = new Gson();

    private ClienteDAO() {}

    public static ClienteDAO getInstance() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }

    @Override
    public void salvar(List<Cliente> lista) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> carregar() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type tipoLista = new TypeToken<ArrayList<Cliente>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}

