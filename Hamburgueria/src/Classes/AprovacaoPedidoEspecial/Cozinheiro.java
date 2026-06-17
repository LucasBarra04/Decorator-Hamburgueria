package Classes.AprovacaoPedidoEspecial;

public class Cozinheiro extends FuncionarioChain {
    public Cozinheiro() {
        listaPedidos.add(TipoPedidoEspecialSimples.getInstance());
        listaPedidos.add(TipoPedidoEspecialCombo.getInstance());
    }
    @Override public String getCargo()           { return "Cozinheiro"; }
    @Override public double getLimiteAprovacao() { return 100.0; }
}
