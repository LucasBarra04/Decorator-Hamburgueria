package Classes;
public class EntregaExpressa implements EstrategiaEntrega {
    @Override
    public double calcularFrete(double distanciaKm) { return 5.00 + (distanciaKm * 2.50); }
    @Override
    public String getDescricao() { return "Entrega Expressa"; }
}
