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
        super("data/locacoes.json", Locacao.class); 
    }

    //Apenas uma instância da classe existe - padrão Singleton
    public static LocacaoDAO getInstance() {
        if (instance == null) {
            instance = new LocacaoDAO();
        }
        return instance;
    }
    
    //Busca locações através dos clientes
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
    
    //atualiza a locação
    public boolean atualizar(Locacao locacao) {
        List<Locacao> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdLocacao() == locacao.getIdLocacao()) {
                lista.set(i, locacao);
                escreverArquivo(lista);
                return true;
            }
        }return false;
    }
    
    // Lista todos os objetos do tipo Locacao
    public List<Locacao> listar(Class<Locacao> clazz) {
        List<Locacao> lista = new ArrayList<>(); 
        try {
            // Lê o conteúdo do arquivo JSON e converte para uma string
            String json = new String(Files.readAllBytes(Paths.get(fileName)));

            // Inicializando o Gson com o JsonDeserializer para a classe Locacao
            Gson gson = new GsonBuilder()
            		
                // JsonDeserializer customizado para a classe Veiculo
                .registerTypeAdapter(Veiculo.class, new JsonDeserializer<Veiculo>() {
                    public Veiculo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        
                        if (jsonObject.has("tipo") && !jsonObject.get("tipo").isJsonNull()) {
                            String tipo = jsonObject.get("tipo").getAsString();
                            switch (tipo.toLowerCase()) { 
                                case "carro":
                                    return context.deserialize(json, Carro.class); // Desserializa como Carro
                                case "moto":
                                    return context.deserialize(json, Moto.class); // Desserializa como Moto
                                case "caminhao":
                                    return context.deserialize(json, Caminhao.class); // Desserializa como Caminhão
                                default:
                                    throw new JsonParseException("Tipo de veículo desconhecido: " + tipo); 
                            }
                        } else {
                            throw new JsonParseException("Campo 'tipo' não encontrado ou é null no JSON");
                        }
                    }
                })
                // JsonDeserializer customizado para a classe Locacao
                .registerTypeAdapter(Locacao.class, new JsonDeserializer<Locacao>() {
                    public Locacao deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        // Desserializa os campos específicos de Locacao
                        int id = jsonObject.get("idLocacao").getAsInt(); // Lê o campo "idLocacao"
                        Cliente cliente = context.deserialize(jsonObject.get("cliente"), Cliente.class); // Desserializa o cliente
                        Veiculo veiculo = context.deserialize(jsonObject.get("veiculo"), Veiculo.class); // Desserializa o veículo
                        String dataRetirada = jsonObject.get("veiculoRetirada").getAsString(); // Lê a data de retirada
                        String dataDevolucao = jsonObject.get("veiculoDevolucao").getAsString(); // Lê a data de devolução
                        int diasLocados = jsonObject.get("diasLocados").getAsInt(); // Lê os dias locados

                        // Retorna um novo objeto Locacao com os dados desserializados
                        return new Locacao(id, cliente, veiculo, dataRetirada, dataDevolucao, diasLocados);
                    }
                })
                .create(); // Cria o objeto Gson com os deserializers registrados

            // Desserializa a lista de objetos Locacao do JSON lido
            Type listType = TypeToken.getParameterized(ArrayList.class, Locacao.class).getType(); 
            lista = gson.fromJson(json, listType); // Converte o JSON para uma lista de Locacoes

        } catch (IOException e) {
            e.printStackTrace(); 
        } catch (JsonParseException e) {
            e.printStackTrace(); 
        }

        return lista; // Retorna a lista de Locacoes desserializadas
    }
    }

