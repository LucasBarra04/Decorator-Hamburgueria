package Test;
import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    private ContextoPromocao contexto;

    @BeforeEach
    void setUp() {
        contexto = new ContextoPromocao();
        contexto.definir("preco",    30.0);
        contexto.definir("desconto",  5.0);
        contexto.definir("frete",     6.5);
        contexto.definir("taxa",      2.0);
        contexto.definir("fator",     0.9);
    }

    @Test
    void valorTerminalDeveRetornarVariavelDoContexto() {
        InterpretadorPromocao expr = new ValorPromocao("preco");
        assertEquals(30.0, expr.interpretar(contexto), 0.01);
    }

    @Test
    void somaDeveRetornarSomaDeDoisValores() {
        InterpretadorPromocao expr = new SomaPromocao(
                new ValorPromocao("preco"), new ValorPromocao("frete"));
        assertEquals(36.5, expr.interpretar(contexto), 0.01);
    }

    @Test
    void subtracaoDeveRetornarPrecoMenosDesconto() {
        InterpretadorPromocao expr = new SubtracaoPromocao(
                new ValorPromocao("preco"), new ValorPromocao("desconto"));
        assertEquals(25.0, expr.interpretar(contexto), 0.01);
    }

    @Test
    void multiplicacaoDeveAplicarFatorAoPreco() {
        InterpretadorPromocao expr = new MultiplicacaoPromocao(
                new ValorPromocao("preco"), new ValorPromocao("fator"));
        assertEquals(27.0, expr.interpretar(contexto), 0.01);
    }

    @Test
    void divisaoDeveRetornarPrecoSobTaxa() {
        InterpretadorPromocao expr = new DivisaoPromocao(
                new ValorPromocao("preco"), new ValorPromocao("taxa"));
        assertEquals(15.0, expr.interpretar(contexto), 0.01);
    }

    @Test
    void expressaoCompostaPrecoMenosDescontoMaisFrete() {
        // (preco - desconto) + frete = (30 - 5) + 6.5 = 31.5
        InterpretadorPromocao expr = new SomaPromocao(
                new SubtracaoPromocao(new ValorPromocao("preco"), new ValorPromocao("desconto")),
                new ValorPromocao("frete"));
        assertEquals(31.5, expr.interpretar(contexto), 0.01);
    }

    @Test
    void aplicadorDeveCalcularExpressaoCorretamente() {
        InterpretadorPromocao expr = new SubtracaoPromocao(
                new ValorPromocao("preco"), new ValorPromocao("desconto"));
        AplicadorPromocao aplicador = new AplicadorPromocao(expr);
        assertEquals(25.0, aplicador.calcular(contexto), 0.01);
    }

    @Test
    void variavelNaoDefinidaDeveLancarExcecao() {
        InterpretadorPromocao expr = new ValorPromocao("inexistente");
        assertThrows(IllegalArgumentException.class, () -> expr.interpretar(contexto));
    }

    @Test
    void expressaoAninhadaEmTresNiveis() {
        // (preco - desconto) * fator + frete = (30-5)*0.9 + 6.5 = 29.0
        InterpretadorPromocao expr = new SomaPromocao(
                new MultiplicacaoPromocao(
                        new SubtracaoPromocao(new ValorPromocao("preco"), new ValorPromocao("desconto")),
                        new ValorPromocao("fator")),
                new ValorPromocao("frete"));
        assertEquals(29.0, expr.interpretar(contexto), 0.01);
    }
}
