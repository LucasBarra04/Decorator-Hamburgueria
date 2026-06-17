package Classes.PagamentoEFechamento;

public class Caixa {

    IGatewayPagamento gateway;
    PagamentoLegadoAdapter adaptador;

    public Caixa() {
        gateway   = new PagamentoPix();
        adaptador = new PagamentoLegadoAdapter(gateway);
    }

    public boolean efetuarPagamento(double valor) {
        return adaptador.processarPagamento(valor);
    }

    public String getConfirmacao() {
        return adaptador.recuperarConfirmacao();
    }

    public boolean isAprovado() {
        return adaptador.isTransacaoAprovada();
    }
}
