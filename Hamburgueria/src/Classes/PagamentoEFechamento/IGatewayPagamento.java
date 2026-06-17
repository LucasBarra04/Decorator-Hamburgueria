package Classes.PagamentoEFechamento;

public interface IGatewayPagamento {
    boolean pagar(double valor);
    String getConfirmacao();
}
