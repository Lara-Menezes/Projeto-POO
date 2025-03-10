package dao;

import java.util.List;
import model.Pagamento;

public class PagamentoDAO extends baseDAO<Pagamento> {

    private static PagamentoDAO instance;

    private PagamentoDAO() {
        super("data/pagamentos.json", Pagamento.class);
    }
    
    //Apenas uma instância de uma classe existe - padrão Singleton
    public static PagamentoDAO getInstance() {
        if (instance == null) {
            instance = new PagamentoDAO();
        }
        return instance;
    }
    
    //busca o pagamento pelo ID da locação
    public Pagamento buscarPagamentoPorLocacaoId(int idLocacao) {
        List<Pagamento> pagamentos = listar(Pagamento.class);
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getIdLocacao() == idLocacao) {
                return pagamento;  // Retorna o pagamento associado à locação
            }
        }
        return null;  
    }
}
