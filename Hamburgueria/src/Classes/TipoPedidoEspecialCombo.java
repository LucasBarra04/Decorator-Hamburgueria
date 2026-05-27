package Classes;
public class TipoPedidoEspecialCombo implements TipoPedidoEspecial {
    private static TipoPedidoEspecialCombo instance;
    private TipoPedidoEspecialCombo() {}
    public static TipoPedidoEspecialCombo getInstance() {
        if (instance == null) instance = new TipoPedidoEspecialCombo();
        return instance;
    }
}
