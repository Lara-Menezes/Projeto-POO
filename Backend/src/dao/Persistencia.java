package dao;

import java.util.List;

public interface Persistencia<T> {

    void salvar(T obj);
    void excluir(T obj);
    List<T> listar(Class<T> clazz);
}

