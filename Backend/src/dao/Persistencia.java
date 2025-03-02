package dao;

import java.util.List;

public interface Persistencia<T> {
    void salvar(List<T> lista);  // Salva a lista de objetos no JSON
    List<T> carregar();          // Carrega os objetos do JSON
}
