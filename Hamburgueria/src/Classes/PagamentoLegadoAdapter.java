package Classes;

public class PagamentoLegadoAdapter extends SistemaPagamentoLegado {

    private IGatewayPagamento gateway;

    public PagamentoLegadoAdapter(IGatewayPagamento gateway) {
        this.gateway = gateway;
    }

    // converte chamada do Adaptee para o padrão do gateway
    public boolean processarPagamento(double valor) {
        this.debitarValor(gateway.getClass().getSimpleName(), valor);
        if (this.isTransacaoAprovada()) {
            gateway.pagar(valor);
            return true;
        }
        return false;
    }

    // recupera confirmação convertendo resposta do legado para o gateway
    public String recuperarConfirmacao() {
        if (this.isTransacaoAprovada())
            gateway.pagar(0);   // atualiza estado interno do gateway com código legado
        return "LEG-" + this.getCodigoTransacao()
             + " / GW-" + gateway.getConfirmacao();
    }
}
