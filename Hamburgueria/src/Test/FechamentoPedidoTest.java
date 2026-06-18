package Test;
import Classes.MontagemHamburguer.*;
import Classes.PagamentoEFechamento.CozinhaSetor;
import Classes.PagamentoEFechamento.EstoqueSetor;
import Classes.PagamentoEFechamento.HamburgeriaFacade;
import Classes.PagamentoEFechamento.PagamentoSetor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FechamentoPedidoTest {

    private PedidoCompleto criarPedido(String nome) {
        Hamburguer h = new BeefBurguer(new malPassado());
        return new PedidoBuilder()
                .setNomeCliente(nome)
                .setHamburguer(h)
                .setFormaPagamento("Pix")
                .build();
    }

    @Test
    void pedidoSemPendenciaDeveSerFechado() {
        PedidoCompleto p = criarPedido("João");
        assertTrue(HamburgeriaFacade.fecharPedido(p));
    }

    @Test
    void pedidoComPendenciaEstoqueDeveSerBloqueado() {
        PedidoCompleto p = criarPedido("Ana");
        EstoqueSetor.getInstancia().addPedidoPendente(p);
        assertFalse(HamburgeriaFacade.fecharPedido(p));
    }

    @Test
    void pedidoComPendenciaPagamentoDeveSerBloqueado() {
        PedidoCompleto p = criarPedido("Bruno");
        PagamentoSetor.getInstancia().addPedidoPendente(p);
        assertFalse(HamburgeriaFacade.fecharPedido(p));
    }

    @Test
    void pedidoComPendenciaCozinhaDeveSerBloqueado() {
        PedidoCompleto p = criarPedido("Carla");
        CozinhaSetor.getInstancia().addPedidoPendente(p);
        assertFalse(HamburgeriaFacade.fecharPedido(p));
    }

    @Test
    void setoresDevemSerSingleton() {
        assertSame(EstoqueSetor.getInstancia(),   EstoqueSetor.getInstancia());
        assertSame(PagamentoSetor.getInstancia(), PagamentoSetor.getInstancia());
        assertSame(CozinhaSetor.getInstancia(),   CozinhaSetor.getInstancia());
    }

    @Test
    void pedidoSemPendenciaNaoDeveEstarEmNenhumSetor() {
        PedidoCompleto p = criarPedido("Lucas");
        assertFalse(EstoqueSetor.getInstancia().verificarPedidoComPendencia(p));
        assertFalse(PagamentoSetor.getInstancia().verificarPedidoComPendencia(p));
        assertFalse(CozinhaSetor.getInstancia().verificarPedidoComPendencia(p));
    }
}
