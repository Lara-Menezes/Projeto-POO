package dao;

import model.Pagamento;

public class PagamentoDAO extends baseDAO<Pagamento> {

    private static PagamentoDAO instance;

    private PagamentoDAO() {
        super("src/data/pagamentos.json", Pagamento.class);
    }

    public static PagamentoDAO getInstance() {
        if (instance == null) {
            instance = new PagamentoDAO();
        }
        return instance;
    }
}
