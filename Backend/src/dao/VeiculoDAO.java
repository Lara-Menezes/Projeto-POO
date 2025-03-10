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
        super("data/veiculos.json", Veiculo.class);
    }

    //Apenas uma instância de uma classe existe - padrão Singleton
    public static VeiculoDAO getInstance() {
        if (instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }
    
    //Salva o veiculo
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
    
    //Atualiza o veiculo
    public void atualizar(Veiculo veiculo) {
        List<Veiculo> veiculos = listar();  

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo v = veiculos.get(i);
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                veiculos.set(i, veiculo);  
                escreverArquivo(veiculos);  
                return;
            }
        }
    }
    
    
  //Exclui o veículo
    public boolean removerVeiculo(String placa) {
        List<Veiculo> veiculos = listar(); 
        
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
            	excluir(veiculo);
            	return true;  
            }
        }
        return false;  
    }
    
    
    //Busca o veiculo pela Placa
    public Veiculo buscarPorPlaca(String placa) {
        List<Veiculo> veiculos = listar();
        
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
    
    //busca o veiculo pelo modelo
    public Veiculo buscarPorModelo(String modelo) {
        List<Veiculo> veiculos = listar();
        
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equals(modelo)) {
                return veiculo;
            }
        }
        return null;
    }
    
    
    //lista os objetos com um desserialize customizado para evitar erro de instanciação de classe abstrata
    public List<Veiculo> listar(Class<Veiculo> clazz) {
        List<Veiculo> lista = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get(fileName)));

            Gson gson = new GsonBuilder()
                .registerTypeAdapter(Veiculo.class, new JsonDeserializer<Veiculo>() {
                   
                    public Veiculo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        
                        if (jsonObject.has("tipo") && !jsonObject.get("tipo").isJsonNull()) {
                            String tipo = jsonObject.get("tipo").getAsString();  
                            
                            switch (tipo.toLowerCase()) {
                                case "carro":
                                    return context.deserialize(json, Carro.class);
                                case "moto":
                                    return context.deserialize(json, Moto.class);
                                case "caminhão":
                                    return context.deserialize(json, Caminhao.class);
                                default:
                                    throw new JsonParseException("Tipo de veículo desconhecido: " + tipo);
                            }
                        } else {
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
    
    //lista os veiculos locados
    public List<Veiculo> listarLocados() {
        List<Veiculo> veiculosLocados = new ArrayList<>();
        List<Veiculo> veiculos = listar(Veiculo.class);  // Lista todos os veículos

        for (Veiculo veiculo : veiculos) {
            if ("Locado".equals(veiculo.getStatus())) {
                veiculosLocados.add(veiculo);
            }
        }
        
        return veiculosLocados;
    }
    
    //lista os veiculos disponíveis
    public List<Veiculo> listarDisponiveis() {
        List<Veiculo> veiculosDisponiveis = new ArrayList<>();
        List<Veiculo> veiculos = listar(Veiculo.class);  // Lista todos os veículos

        for (Veiculo veiculo : veiculos) {
            if ("Disponível".equals(veiculo.getStatus())) {
                veiculosDisponiveis.add(veiculo);
            }
        }
        
        return veiculosDisponiveis;
    }
    }



