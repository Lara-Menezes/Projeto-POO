package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.Type;
import java.util.*;

public abstract class baseDAO<T> implements Persistencia<T> {
    
    protected String fileName; // onde os dados estão persistindo
    private Class<T> type;
    
    // Construtor da classe baseDAO, recebe o nome do arquivo e o tipo do objeto
    public baseDAO(String fileName, Class<T> type) {
        this.fileName = fileName;
        this.type = type;
    }
    
    public List<T> listar() {
        return listar(type);
    }

    public void salvar(T obj) {
        List<T> lista = listar();
        lista.add(obj);
        escreverArquivo(lista);
    }
    
    public void excluir(T obj) {
    	List<T> lista = listar();
        if (lista.remove(obj)) { 
            escreverArquivo(lista); 
        }
    }

    // Método para listar os objetos de um arquivo, utilizando o tipo especificado
    public List<T> listar(Class<T> clazz) {
        List<T> lista = new ArrayList<>();
        try {
            // Lê o conteúdo do arquivo e converte para lista de objetos
            String json = new String(Files.readAllBytes(Paths.get(fileName)));
            if (!json.trim().isEmpty()) {  // Verifica se o JSON não está vazio
                Type listType = TypeToken.getParameterized(ArrayList.class, clazz).getType();
                lista = new Gson().fromJson(json, listType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para escrever a lista de objetos no arquivo
    protected void escreverArquivo(List<T> lista) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(fileName))) {
            new Gson().toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
