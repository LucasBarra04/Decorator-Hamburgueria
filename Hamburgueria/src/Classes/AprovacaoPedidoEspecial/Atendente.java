package Classes.AprovacaoPedidoEspecial;

public class Atendente extends FuncionarioChain {
    public Atendente() { listaPedidos.add(TipoPedidoEspecialSimples.getInstance()); }
    @Override public String getCargo()           { return "Atendente"; }
    @Override public double getLimiteAprovacao() { return 50.0; }
}
