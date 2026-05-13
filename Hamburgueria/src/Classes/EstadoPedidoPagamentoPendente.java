package Classes;

public class EstadoPedidoPagamentoPendente extends EstadoPedido {

    private static EstadoPedidoPagamentoPendente instance;

    private EstadoPedidoPagamentoPendente() {}

    public static EstadoPedidoPagamentoPendente getInstance() {
        if (instance == null) {
            instance = new EstadoPedidoPagamentoPendente();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pagamento Pendente";
    }

    @Override
    public void aprovar(Pedido pedido) {
        System.out.println("Pagamento aprovado! Pedido avançando para Aprovado.");
        pedido.setEstado(EstadoPedidoAprovado.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido cancelado a partir de Pagamento Pendente.");
        pedido.setEstado(EstadoPedidoCancelado.getInstance());
    }
}
