package Classes;
public class TipoPedidoEspecialCorporativo implements TipoPedidoEspecial {
    private static TipoPedidoEspecialCorporativo instance;
    private TipoPedidoEspecialCorporativo() {}
    public static TipoPedidoEspecialCorporativo getInstance() {
        if (instance == null) instance = new TipoPedidoEspecialCorporativo();
        return instance;
    }
}
