package dao;

import com.google.gson.*;
import model.Pagamento;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO implements Persistencia<Pagamento> {
    private static PagamentoDAO instancia;
    private static final String FILE_NAME = "data/pagamentos.json";
    private Gson gson = new Gson();

    private PagamentoDAO() {}

    public static PagamentoDAO getInstance() {
        if (instancia == null) {
            instancia = new PagamentoDAO();
        }
        return instancia;
    }

    @Override
    public void salvar(List<Pagamento> lista) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar pagamentos: " + e.getMessage());
        }
    }

    @Override
    public List<Pagamento> carregar() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type tipoLista = new TypeToken<ArrayList<Pagamento>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
