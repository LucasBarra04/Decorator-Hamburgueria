package Classes;

public class GerenciaPedidos {
    private static GerenciaPedidos gerenciaPedidos;
    private int ContarPedidos = 0;
    private double ReceitaTotal = 0;

    private GerenciaPedidos() {}

    public static GerenciaPedidos getInstance() {
        if (gerenciaPedidos == null) {
            gerenciaPedidos = new GerenciaPedidos();
        }
        return gerenciaPedidos;
    }

    public String registroPedidos(Hambuguer hambuguer) {
        ContarPedidos++;
        ReceitaTotal += hambuguer.getCusto();
        return "Pedido: " + ContarPedidos + " | " + hambuguer.getDescricao() + " | " + hambuguer.getCusto();
    }

    public String relatorioPedidos() {
        return "Total de Pedidos: " + ContarPedidos + " | Total de Receita: " + ReceitaTotal;
    }
}