package Classes;
public class PedidoEstadoCancelado implements PedidoEstado {
    private static PedidoEstadoCancelado instance;
    private PedidoEstadoCancelado() {}
    public static PedidoEstadoCancelado getInstance() {
        if (instance == null) instance = new PedidoEstadoCancelado();
        return instance;
    }
    @Override public String getNomeEstado() { return "Cancelado"; }
}
