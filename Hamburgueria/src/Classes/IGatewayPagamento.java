package Classes;

public interface IGatewayPagamento {
    boolean pagar(double valor);
    String getConfirmacao();
}
