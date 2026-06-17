package Classes.AprovacaoPedidoEspecial;
public class TipoPedidoEspecialEvento implements TipoPedidoEspecial {
    private static TipoPedidoEspecialEvento instance;
    private TipoPedidoEspecialEvento() {}
    public static TipoPedidoEspecialEvento getInstance() {
        if (instance == null) instance = new TipoPedidoEspecialEvento();
        return instance;
    }
}
