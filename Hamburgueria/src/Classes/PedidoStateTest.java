package Classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoStateTest {

    private Pedido criarPedido() {
        fabricaHamburguer fabrica = new fabricaHamburguerGourmet();
        Hamburguer h = fabrica.criarHamburguer("Beef", new malPassado());
        h = new Cheddar(h);
        return new Pedido(h);
    }

    @Test
    void pedidoDeveIniciarComPagamentoPendente() {
        Pedido pedido = criarPedido();
        assertEquals("Pagamento Pendente", pedido.getEstado());
    }

    @Test
    void aprovacaoDeveAvancarParaAprovado() {
        Pedido pedido = criarPedido();
        pedido.aprovar();
        assertEquals("Aprovado", pedido.getEstado());
    }

    @Test
    void fluxoCompletoDeveChgarEmEntregue() {
        Pedido pedido = criarPedido();
        pedido.aprovar();
        pedido.preparar();
        pedido.transportar();
        pedido.entregar();
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    void cancelamentoEmPagamentoPendenteDeveIrParaCancelado() {
        Pedido pedido = criarPedido();
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado());
    }

    @Test
    void cancelamentoEmAprovadoDeveIrParaCancelado() {
        Pedido pedido = criarPedido();
        pedido.aprovar();
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado());
    }

    @Test
    void cancelamentoEmPreparoDeveIrParaCancelado() {
        Pedido pedido = criarPedido();
        pedido.aprovar();
        pedido.preparar();
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado());
    }

    @Test
    void acaoInvalidaNaoDeveAvancarEstado() {
        Pedido pedido = criarPedido();
        pedido.entregar(); // inválido em PagamentoPendente
        assertEquals("Pagamento Pendente", pedido.getEstado());
    }

    @Test
    void estadoEntregueNaoDeveAceitarMaisAcoes() {
        Pedido pedido = criarPedido();
        pedido.aprovar();
        pedido.preparar();
        pedido.transportar();
        pedido.entregar();
        pedido.cancelar(); // inválido em Entregue
        assertEquals("Entregue", pedido.getEstado());
    }
}
