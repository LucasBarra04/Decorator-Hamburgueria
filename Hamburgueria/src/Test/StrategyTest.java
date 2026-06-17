package Test;
import Classes.AtendimentoEFrete.CalculadoraEntrega;
import Classes.AtendimentoEFrete.EntregaEconomica;
import Classes.AtendimentoEFrete.EntregaExpressa;
import Classes.AtendimentoEFrete.EntregaRetirada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

    @Test
    void expressaDeveTerTaxaBaseDeA500() {
        CalculadoraEntrega calc = new CalculadoraEntrega();
        calc.setDistanciaKm(0.0);
        assertEquals(5.00, calc.calcularFrete(new EntregaExpressa()), 0.01);
    }

    @Test
    void economicaDeveTerTaxaBaseDeA200() {
        CalculadoraEntrega calc = new CalculadoraEntrega();
        calc.setDistanciaKm(0.0);
        assertEquals(2.00, calc.calcularFrete(new EntregaEconomica()), 0.01);
    }

    @Test
    void retiradaDeveTerFreteZero() {
        CalculadoraEntrega calc = new CalculadoraEntrega();
        calc.setDistanciaKm(10.0);
        assertEquals(0.0, calc.calcularFrete(new EntregaRetirada()), 0.01);
    }

    @Test
    void expressaComCincoKmDeveCalcularCorretamente() {
        CalculadoraEntrega calc = new CalculadoraEntrega();
        calc.setDistanciaKm(5.0);
        assertEquals(17.50, calc.calcularFrete(new EntregaExpressa()), 0.01);
    }

    @Test
    void economicaComCincoKmDeveCalcularCorretamente() {
        CalculadoraEntrega calc = new CalculadoraEntrega();
        calc.setDistanciaKm(5.0);
        assertEquals(7.00, calc.calcularFrete(new EntregaEconomica()), 0.01);
    }

    @Test
    void expressaDeveSerMaisCaraQueEconomica() {
        CalculadoraEntrega calc = new CalculadoraEntrega();
        calc.setDistanciaKm(5.0);
        assertTrue(calc.calcularFrete(new EntregaExpressa())
                 > calc.calcularFrete(new EntregaEconomica()));
    }

    @Test
    void mesmaCalculadoraDeveAceitarEstrategiasDiferentes() {
        CalculadoraEntrega calc = new CalculadoraEntrega();
        calc.setDistanciaKm(3.0);
        double expressa  = calc.calcularFrete(new EntregaExpressa());
        double economica = calc.calcularFrete(new EntregaEconomica());
        double retirada  = calc.calcularFrete(new EntregaRetirada());
        assertTrue(expressa > economica);
        assertTrue(economica > retirada);
    }

    @Test
    void descricaoExpressaDeveEstarCorreta() {
        assertEquals("Entrega Expressa", new EntregaExpressa().getDescricao());
    }

    @Test
    void descricaoEconomicaDeveEstarCorreta() {
        assertEquals("Entrega Econômica", new EntregaEconomica().getDescricao());
    }

    @Test
    void descricaoRetiradaDeveEstarCorreta() {
        assertEquals("Retirada na Loja", new EntregaRetirada().getDescricao());
    }
}
