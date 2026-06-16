package Test;
import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MementoTest {

    private HistoricoCliente historico;
    private PedidoCompleto p1;
    private PedidoCompleto p2;

    @BeforeEach
    void setUp() {
        historico = new HistoricoCliente();

        Hamburguer h1 = new BeefBurguer(new malPassado());
        h1 = new Cheddar(h1);
        p1 = new PedidoBuilder()
                .setNomeCliente("Lucas").setHamburguer(h1)
                .setFormaPagamento("Pix").build();

        Hamburguer h2 = new chickenBurguer(new noPonto());
        h2 = new Picles(h2);
        p2 = new PedidoBuilder()
                .setNomeCliente("Lucas").setHamburguer(h2)
                .setFormaPagamento("Cartão").build();
    }

    @Test
    void historicoDeveIniciarComEstadoAberto() {
        assertEquals("Aberto", historico.getEstadoAtual().getNomeEstado());
    }

    @Test
    void setEstadoDeveAlterarEstadoAtual() {
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p1);
        assertEquals("Finalizado", historico.getEstadoAtual().getNomeEstado());
    }

    @Test
    void setEstadoDeveSalvarNoHistorico() {
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p1);
        assertEquals(2, historico.getMemento().size());
    }

    @Test
    void historicoDeveRegistrarTodosOsEstados() {
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p1);
        historico.setEstado(PedidoEstadoCancelado.getInstance(), p2);
        assertEquals(3, historico.getMemento().size());
        assertEquals("Aberto",     historico.getMemento().get(0).getNomeEstado());
        assertEquals("Finalizado", historico.getMemento().get(1).getNomeEstado());
        assertEquals("Cancelado",  historico.getMemento().get(2).getNomeEstado());
    }

    @Test
    void restaurarPedidoDeveVoltarAoPedidoCorreto() {
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p1);
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p2);
        historico.restaurarPedido(1);
        assertSame(p1, historico.getPedidoAtual());
    }

    @Test
    void restaurarNaoDeveAlterarHistorico() {
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p1);
        historico.setEstado(PedidoEstadoFinalizado.getInstance(), p2);
        int tamanhoAntes = historico.getMemento().size();
        historico.restaurarPedido(1);
        assertEquals(tamanhoAntes, historico.getMemento().size());
    }

    @Test
    void estadosSaoSingleton() {
        assertSame(PedidoEstadoAberto.getInstance(),     PedidoEstadoAberto.getInstance());
        assertSame(PedidoEstadoFinalizado.getInstance(), PedidoEstadoFinalizado.getInstance());
        assertSame(PedidoEstadoCancelado.getInstance(),  PedidoEstadoCancelado.getInstance());
    }
}
