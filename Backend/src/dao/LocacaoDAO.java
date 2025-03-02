package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Locacao;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LocacaoDAO implements Persistencia<Locacao> {
    private static LocacaoDAO instancia;
    private static final String FILE_NAME = "data/locacoes.json";
    private Gson gson = new Gson();

    private LocacaoDAO() {}

    public static LocacaoDAO getInstance() {
        if (instancia == null) {
            instancia = new LocacaoDAO();
        }
        return instancia;
    }

    @Override
    public void salvar(List<Locacao> lista) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar locações: " + e.getMessage());
        }
    }

    @Override
    public List<Locacao> carregar() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type tipoLista = new TypeToken<ArrayList<Locacao>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}

