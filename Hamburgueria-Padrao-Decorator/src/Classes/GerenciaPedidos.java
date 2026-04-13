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

    public String registroPedidos(Hamburguer hamburguer) {
        ContarPedidos++;
        ReceitaTotal += hamburguer.getCusto();
        return "Pedido: " + ContarPedidos + " | " + hamburguer.getDescricao() + " | " + hamburguer.getCusto();
    }

    public String relatorioPedidos() {
        return "Total de Pedidos: " + ContarPedidos + " | Total de Receita: " + ReceitaTotal;
    }
}