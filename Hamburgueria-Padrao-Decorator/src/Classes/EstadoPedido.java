package Classes;

public abstract class EstadoPedido {

    public abstract String getEstado();

    public void pagamentoPendente(Pedido pedido) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void aprovar(Pedido pedido) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void preparar(Pedido pedido) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void transportar(Pedido pedido) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void entregar(Pedido pedido) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
    public void cancelar(Pedido pedido) {
        System.out.println("Ação inválida para o estado: " + getEstado());
    }
}
