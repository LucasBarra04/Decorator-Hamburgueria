package Classes.PagamentoEFechamento;

public class SistemaPagamentoLegado {
    private String codigoTransacao;
    private boolean transacaoAprovada;

    public void debitarValor(String descricao, double quantia) {
        this.codigoTransacao    = "TXN-" + (int)(quantia * 100);
        this.transacaoAprovada  = quantia > 0;

    }

    public String getCodigoTransacao()   { return codigoTransacao; }
    public boolean isTransacaoAprovada() { return transacaoAprovada; }
}
