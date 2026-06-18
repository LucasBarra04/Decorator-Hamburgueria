package Classes.PagamentoEFechamento;

public class PagamentoPix implements IGatewayPagamento {
    private String confirmacao;

    @Override
    public boolean pagar(double valor) {
        this.confirmacao = "PIX-OK-" + (int)(valor * 100);

        return true;
    }

    @Override
    public String getConfirmacao() { return confirmacao; }
}
