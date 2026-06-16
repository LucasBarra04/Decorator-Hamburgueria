package Test;
import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private FilaPreparoPedidos fila;
    private FilaCozinha filaCozinha;
    private PedidoCompleto p1;
    private PedidoCompleto p2;

    @BeforeEach
    void setUp() {
        fila       = new FilaPreparoPedidos();
        filaCozinha = new FilaCozinha();

        p1 = new PedidoBuilder().setNomeCliente("Ana")
                .setHamburguer(new BeefBurguer(new noPonto()))
                .setFormaPagamento("Pix").build();

        p2 = new PedidoBuilder().setNomeCliente("Bruno")
                .setHamburguer(new chickenBurguer(new bemPassado()))
                .setFormaPagamento("Cartão").build();
    }

    @Test
    void adicionarComandoDeveInserirPedidoNaFila() {
        filaCozinha.executarComando(new AdicionarPedidoComando(fila, p1));
        assertEquals(1, fila.getTotalNaFila());
        assertSame(p1, fila.getPedidosNaFila().get(0));
    }

    @Test
    void cancelarAdicionarDeveRemoverPedidoDaFila() {
        filaCozinha.executarComando(new AdicionarPedidoComando(fila, p1));
        filaCozinha.desfazerUltimo();
        assertEquals(0, fila.getTotalNaFila());
    }

    @Test
    void removerComandoDeveRetirarPedidoDaFila() {
        fila.adicionarPedido(p1);
        filaCozinha.executarComando(new RemoverPedidoComando(fila, p1));
        assertEquals(0, fila.getTotalNaFila());
    }

    @Test
    void cancelarRemoverDeveRecolocarPedidoNaFila() {
        fila.adicionarPedido(p1);
        filaCozinha.executarComando(new RemoverPedidoComando(fila, p1));
        filaCozinha.desfazerUltimo();
        assertEquals(1, fila.getTotalNaFila());
    }

    @Test
    void priorizarComandoDeveMoverPedidoParaInicioDaFila() {
        fila.adicionarPedido(p1);
        fila.adicionarPedido(p2);
        filaCozinha.executarComando(new PriorizarPedidoComando(fila, p2));
        assertSame(p2, fila.getPedidosNaFila().get(0));
    }

    @Test
    void cancelarPriorizarDeveMoverPedidoParaFinalDaFila() {
        fila.adicionarPedido(p1);
        fila.adicionarPedido(p2);
        filaCozinha.executarComando(new PriorizarPedidoComando(fila, p2));
        filaCozinha.desfazerUltimo();
        assertSame(p2, fila.getPedidosNaFila().get(fila.getTotalNaFila() - 1));
    }

    @Test
    void historicoDeveRegistrarTodosOsComandosExecutados() {
        filaCozinha.executarComando(new AdicionarPedidoComando(fila, p1));
        filaCozinha.executarComando(new AdicionarPedidoComando(fila, p2));
        assertEquals(2, filaCozinha.getTotalComandos());
    }

    @Test
    void desfazerEmFilaVaziaNaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> filaCozinha.desfazerUltimo());
    }
}
