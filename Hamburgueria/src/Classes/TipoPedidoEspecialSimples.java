package Classes;
public class TipoPedidoEspecialSimples implements TipoPedidoEspecial {
    private static TipoPedidoEspecialSimples instance;
    private TipoPedidoEspecialSimples() {}
    public static TipoPedidoEspecialSimples getInstance() {
        if (instance == null) instance = new TipoPedidoEspecialSimples();
        return instance;
    }
}
