package Classes.PagamentoEFechamento;
public class PagamentoSetor extends SetorHamburgueria {
    private static PagamentoSetor instance;
    private PagamentoSetor() {}
    public static PagamentoSetor getInstancia() {
        if (instance == null) instance = new PagamentoSetor();
        return instance;
    }
}
