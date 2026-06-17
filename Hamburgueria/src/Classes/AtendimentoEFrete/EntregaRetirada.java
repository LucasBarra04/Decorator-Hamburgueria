package Classes.AtendimentoEFrete;

public class EntregaRetirada implements EstrategiaEntrega {
    @Override
    public double calcularFrete(double distanciaKm) { return 0.0; }
    @Override
    public String getDescricao() { return "Retirada na Loja"; }
}
