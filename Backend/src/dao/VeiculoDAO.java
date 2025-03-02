package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Veiculo;
import model.Carro;
import model.Moto;
import model.Caminhao;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO implements Persistencia<Veiculo> {
    private static VeiculoDAO instancia; // Singleton - única instância
    private static final String FILE_NAME = "data/veiculos.json";
    private Gson gson = new Gson();

    private VeiculoDAO() {} // Construtor privado para evitar múltiplas instâncias

    public static VeiculoDAO getInstance() { 
        if (instancia == null) {
            instancia = new VeiculoDAO(); 
        }
        return instancia;
    }

    @Override
    public void salvar(List<Veiculo> lista) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar veículos: " + e.getMessage());
        }
    }

    @Override
    public List<Veiculo> carregar() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type tipoLista = new TypeToken<ArrayList<Veiculo>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>(); // Retorna lista vazia se houver erro
        }
    }

    // 🚗 **Factory Method** - Cria diferentes tipos de veículos dinamicamente
    public Veiculo criarVeiculo(String tipo, String placa, String modelo, int ano, String status) {
        switch (tipo.toLowerCase()) {
            case "carro": return new Carro(placa, modelo, ano, status);
            case "moto": return new Moto(placa, modelo, ano, status);
            case "caminhao": return new Caminhao(placa, modelo, ano, status);
            default: throw new IllegalArgumentException("Tipo de veículo inválido");
        }
    }
}

