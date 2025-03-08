package dao;

import java.util.List;

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
    
    public Pagamento buscarPagamentoPorLocacaoId(int idLocacao) {
        List<Pagamento> pagamentos = listar(Pagamento.class);
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getIdLocacao() == idLocacao) {
                return pagamento;  // Retorna o pagamento associado à locação
            }
        }
        return null;  // Se não encontrar nenhum pagamento associado à locação
    }
}
