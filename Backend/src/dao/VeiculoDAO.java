package dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import model.Caminhao;
import model.Carro;
import model.Moto;
import model.Veiculo;


public class VeiculoDAO extends baseDAO<Veiculo> {

    private static VeiculoDAO instance;

    public VeiculoDAO() {
        super("src/data/veiculos.json", Veiculo.class);
    }

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }

    public void salvar(Veiculo veiculo) {
        List<Veiculo> veiculos = listar();
        
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                System.out.println("Veículo com essa placa já existe!");
                return; 
            }
        }

        super.salvar(veiculo);
    }
    
    public void atualizar(Veiculo veiculo) {
        List<Veiculo> veiculos = listar();  

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo v = veiculos.get(i);
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                veiculos.set(i, veiculo);  
                escreverArquivo(veiculos);  
                System.out.println("Veículo atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Veículo não encontrado para atualização.");
    }
    
    public Veiculo buscarPorPlaca(String placa) {
        List<Veiculo> veiculos = listar();
        
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
 
    public List<Veiculo> listar(Class<Veiculo> clazz) {
        List<Veiculo> lista = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get(fileName)));

            // Usando GsonBuilder para registrar um JsonDeserializer específico para Veiculo
            Gson gson = new GsonBuilder()
                .registerTypeAdapter(Veiculo.class, new JsonDeserializer<Veiculo>() {
                    @Override
                    public Veiculo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        
                        // Verifica se o campo "tipo" existe e não é null
                        if (jsonObject.has("tipo") && !jsonObject.get("tipo").isJsonNull()) {
                            String tipo = jsonObject.get("tipo").getAsString();  // Obtém o valor da chave "tipo"
                            
                            // Verifica o campo "tipo" para decidir qual subclasse instanciar
                            switch (tipo) {
                                case "carro":
                                    return context.deserialize(json, Carro.class);
                                case "moto":
                                    return context.deserialize(json, Moto.class);
                                case "caminhao":
                                    return context.deserialize(json, Caminhao.class);
                                default:
                                    throw new JsonParseException("Tipo de veículo desconhecido: " + tipo);
                            }
                        } else {
                            // Caso a chave "tipo" não exista ou seja null, lança uma exceção
                            throw new JsonParseException("Campo 'tipo' não encontrado ou é null no JSON");
                        }
                    }
                })
                .create();

            Type listType = TypeToken.getParameterized(ArrayList.class, Veiculo.class).getType();
            lista = gson.fromJson(json, listType);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        }

        return lista;
    }
    }

