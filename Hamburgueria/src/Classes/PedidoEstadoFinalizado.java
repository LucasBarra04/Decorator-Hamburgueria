package Classes;
public class PedidoEstadoFinalizado implements PedidoEstado {
    private static PedidoEstadoFinalizado instance;
    private PedidoEstadoFinalizado() {}
    public static PedidoEstadoFinalizado getInstance() {
        if (instance == null) instance = new PedidoEstadoFinalizado();
        return instance;
    }
    @Override public String getNomeEstado() { return "Finalizado"; }
}
