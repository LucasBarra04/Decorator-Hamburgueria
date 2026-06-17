package Classes.AprovacaoPedidoEspecial;

public class Dono extends FuncionarioChain {
    public Dono() {
        listaPedidos.add(TipoPedidoEspecialSimples.getInstance());
        listaPedidos.add(TipoPedidoEspecialCombo.getInstance());
        listaPedidos.add(TipoPedidoEspecialCorporativo.getInstance());
        listaPedidos.add(TipoPedidoEspecialEvento.getInstance());
    }
    @Override public String getCargo()           { return "Dono"; }
    @Override public double getLimiteAprovacao() { return Double.MAX_VALUE; }
}
