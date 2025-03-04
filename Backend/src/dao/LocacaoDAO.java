package dao;

import model.Locacao;

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
}

