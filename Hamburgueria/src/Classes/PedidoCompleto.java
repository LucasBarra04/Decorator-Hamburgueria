package Classes;

public class PedidoCompleto implements Cloneable {
    private String nomeCliente;
    private Hamburguer hamburguer;
    private Acompanhamento acompanhamento;
    private String formaPagamento;
    private String observacoes;
    private boolean paraViagem;

    public String getNomeCliente()                      { return nomeCliente; }
    public void setNomeCliente(String n)                { this.nomeCliente = n; }
    public Hamburguer getHamburguer()                   { return hamburguer; }
    public void setHamburguer(Hamburguer h)             { this.hamburguer = h; }
    public Acompanhamento getAcompanhamento()           { return acompanhamento; }
    public void setAcompanhamento(Acompanhamento a)     { this.acompanhamento = a; }
    public String getFormaPagamento()                   { return formaPagamento; }
    public void setFormaPagamento(String f)             { this.formaPagamento = f; }
    public String getObservacoes()                      { return observacoes; }
    public void setObservacoes(String o)                { this.observacoes = o; }
    public boolean isParaViagem()                       { return paraViagem; }
    public void setParaViagem(boolean p)                { this.paraViagem = p; }

    public double getCustoTotal() {
        double total = hamburguer != null ? hamburguer.getCusto() : 0;
        total += acompanhamento != null ? acompanhamento.getCusto() : 0;
        return total;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
