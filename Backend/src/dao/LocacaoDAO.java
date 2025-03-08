package dao;

import model.Locacao;
import model.Moto;
import model.Veiculo;
import model.Caminhao;
import model.Carro;
import model.Cliente;

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

public class LocacaoDAO extends baseDAO<Locacao> {

    private static LocacaoDAO instance;

    private LocacaoDAO() {
        super("src/data/locacoes.json", Locacao.class); 
    }

    public static LocacaoDAO getInstance() {
        if (instance == null) {
            instance = new LocacaoDAO();
        }
        return instance;
    }
    
    public List<Locacao> listarPorCliente(Cliente cliente) {
        List<Locacao> locacoes = listar();  
        List<Locacao> locacoesCliente = new ArrayList<>();
        
        for (Locacao locacao : locacoes) {
            if (locacao.getCliente().equals(cliente)) {
                locacoesCliente.add(locacao);
            }
        }

        return locacoesCliente; 
    }
    
    public void atualizar(Locacao locacao) {
        List<Locacao> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdLocacao() == locacao.getIdLocacao()) {
                lista.set(i, locacao);
                escreverArquivo(lista);
                return;
            }
        }
    }
    
    public List<Locacao> listar(Class<Locacao> clazz) {
        List<Locacao> lista = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get(fileName)));

            // Inicializando o Gson com o JsonDeserializer para a Locacao
            Gson gson = new GsonBuilder()
                .registerTypeAdapter(Veiculo.class, new JsonDeserializer<Veiculo>() {
                    public Veiculo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        // Verificar o campo "tipo" e decidir a classe concreta a ser instanciada
                        if (jsonObject.has("tipo") && !jsonObject.get("tipo").isJsonNull()) {
                            String tipo = jsonObject.get("tipo").getAsString();
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
                            throw new JsonParseException("Campo 'tipo' não encontrado ou é null no JSON");
                        }
                    }
                })
                .registerTypeAdapter(Locacao.class, new JsonDeserializer<Locacao>() {
                    public Locacao deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        // Desserializar os campos de Locacao
                        int id = jsonObject.get("idLocacao").getAsInt();
                        Cliente cliente = context.deserialize(jsonObject.get("cliente"), Cliente.class);
                        Veiculo veiculo = context.deserialize(jsonObject.get("veiculo"), Veiculo.class);
                        String dataRetirada = jsonObject.get("veiculoRetirada").getAsString();
                        String dataDevolucao = jsonObject.get("veiculoDevolucao").getAsString();
                        int diasLocados = jsonObject.get("diasLocados").getAsInt();

                        return new Locacao(id, cliente, veiculo, dataRetirada, dataDevolucao, diasLocados);
                    }
                })
                .create();

            // Desserializar a lista de Locacoes
            Type listType = TypeToken.getParameterized(ArrayList.class, Locacao.class).getType();
            lista = gson.fromJson(json, listType);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        }

        return lista;
    }
    }

