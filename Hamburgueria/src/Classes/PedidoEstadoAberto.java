package Classes;
public class PedidoEstadoAberto implements PedidoEstado {
    private static PedidoEstadoAberto instance;
    private PedidoEstadoAberto() {}
    public static PedidoEstadoAberto getInstance() {
        if (instance == null) instance = new PedidoEstadoAberto();
        return instance;
    }
    @Override public String getNomeEstado() { return "Aberto"; }
}
