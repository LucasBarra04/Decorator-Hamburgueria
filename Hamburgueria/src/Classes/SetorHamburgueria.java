package Classes;
import java.util.ArrayList;
import java.util.List;
public abstract class SetorHamburgueria {
    private List<PedidoCompleto> pedidosComPendencia = new ArrayList<>();
    public void addPedidoPendente(PedidoCompleto pedido)         { pedidosComPendencia.add(pedido); }
    public boolean verificarPedidoComPendencia(PedidoCompleto p) { return pedidosComPendencia.contains(p); }
}
