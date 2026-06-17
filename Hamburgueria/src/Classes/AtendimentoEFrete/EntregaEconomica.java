package Classes.AtendimentoEFrete;

public class EntregaEconomica implements EstrategiaEntrega {
    @Override
    public double calcularFrete(double distanciaKm) { return 2.00 + (distanciaKm * 1.00); }
    @Override
    public String getDescricao() { return "Entrega Econômica"; }
}
