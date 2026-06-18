package Test;

import Classes.FilaCozinhaECicloPedido.Pedido;
import Classes.MontagemHamburguer.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CicloVidaPedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        fabricaHamburguer fabrica = new fabricaHamburguerGourmet();
        Hamburguer h = fabrica.criarHamburguer("Beef", new malPassado());
        h = new Cheddar(h);
        pedido = new Pedido(h);
    }

    @Test
    void pedidoDeveIniciarComPagamentoPendente() {
        assertEquals("Pagamento Pendente", pedido.getEstado());
    }

    @Test
    void aprovacaoDeveAvancarParaAprovado() {
        pedido.aprovar();
        assertEquals("Aprovado", pedido.getEstado());
    }

    @Test
    void fluxoCompletoDeveChgarEmEntregue() {
        pedido.aprovar();
        pedido.preparar();
        pedido.transportar();
        pedido.entregar();
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    void cancelamentoEmPagamentoPendenteDeveIrParaCancelado() {
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado());
    }

    @Test
    void cancelamentoEmAprovadoDeveIrParaCancelado() {
        pedido.aprovar();
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado());
    }

    @Test
    void cancelamentoEmPreparoDeveIrParaCancelado() {
        pedido.aprovar();
        pedido.preparar();
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado());
    }

    @Test
    void acaoInvalidaNaoDeveAvancarEstado() {
        pedido.entregar();
        assertEquals("Pagamento Pendente", pedido.getEstado());
    }

    @Test
    void estadoEntregueNaoDeveAceitarMaisAcoes() {
        pedido.aprovar();
        pedido.preparar();
        pedido.transportar();
        pedido.entregar();
        pedido.cancelar();
        assertEquals("Entregue", pedido.getEstado());
    }
}