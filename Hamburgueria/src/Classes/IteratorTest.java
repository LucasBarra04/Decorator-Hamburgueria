package Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IteratorTest {

    private HistoricoCliente historico;
    private PedidoCompleto p1, p2, p3;

    @BeforeEach
    void setUp() {
        historico = new HistoricoCliente();

        Hamburguer h1 = new BeefBurguer(new malPassado());
        p1 = new PedidoBuilder().setNomeCliente("Lucas")
                .setHamburguer(h1).setFormaPagamento("Pix").build();

        Hamburguer h2 = new chickenBurguer(new noPonto());
        h2 = new Cheddar(h2);
        p2 = new PedidoBuilder().setNomeCliente("Lucas")
                .setHamburguer(h2).setFormaPagamento("Cartão").build();

        Hamburguer h3 = new BeefBurguer(new bemPassado());
        h3 = new Picles(h3);
        p3 = new PedidoBuilder().setNomeCliente("Lucas")
                .setHamburguer(h3).setAcompanhamento(new AcompanhamentoBatataFrita())
                .setFormaPagamento("Dinheiro").build();

        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p1);
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p2);
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p3);
    }

    @Test
    void totalPedidosDeveSerTres() {
        RelatorioCliente r = new RelatorioCliente(historico);
        assertEquals(3, r.getTotalPedidos());
    }

    @Test
    void historicoVazioDeveTerTotalZero() {
        RelatorioCliente r = new RelatorioCliente(new HistoricoCliente());
        assertEquals(0, r.getTotalPedidos());
    }

    @Test
    void somaTotalDeveIncluirTodosOsPedidos() {
        RelatorioCliente r = new RelatorioCliente(historico);
        double esperado = p1.getCustoTotal() + p2.getCustoTotal() + p3.getCustoTotal();
        assertEquals(esperado, r.getSomaTotal(), 0.01);
    }

    @Test
    void iteratorDevePercorrerNaOrdemDeInsercao() {
        var it = historico.iterator();
        assertSame(p1, it.next());
        assertSame(p2, it.next());
        assertSame(p3, it.next());
    }

    @Test
    void hasNextDeveFalsoEmHistoricoVazio() {
        assertFalse(new HistoricoCliente().iterator().hasNext());
    }

    @Test
    void forEachDevePercorrerTodosOsPedidos() {
        int count = 0;
        for (PedidoCompleto p : historico) count++;
        assertEquals(3, count);
    }

    @Test
    void exibirHistoricoNaoDeveLancarExcecao() {
        RelatorioCliente r = new RelatorioCliente(historico);
        assertDoesNotThrow(r::exibirHistorico);
    }
}
