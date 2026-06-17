package Classes.AtendimentoEFrete;

public class CalculadoraEntrega {
    private double distanciaKm;
    public double getDistanciaKm()       { return distanciaKm; }
    public void setDistanciaKm(double d) { this.distanciaKm = d; }
    public double calcularFrete(EstrategiaEntrega estrategia) {
        return estrategia.calcularFrete(distanciaKm);
    }
}
