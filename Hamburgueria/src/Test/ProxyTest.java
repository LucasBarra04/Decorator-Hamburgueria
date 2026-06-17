package Test;
import Classes.HistoricoEPosVenda.AtendenteCaixa;
import Classes.HistoricoEPosVenda.DadosPedidoProxy;
import Classes.HistoricoEPosVenda.IDadosPedido;
import Classes.MontagemHamburguer.BeefBurguer;
import Classes.MontagemHamburguer.PedidoBuilder;
import Classes.MontagemHamburguer.PedidoCompleto;
import Classes.MontagemHamburguer.malPassado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProxyTest {

    private PedidoCompleto pedido;
    private DadosPedidoProxy proxy;
    private AtendenteCaixa atendente;

    @BeforeEach
    void setUp() {
        pedido    = new PedidoBuilder().setNomeCliente("Carlos")
                        .setHamburguer(new BeefBurguer(new malPassado()))
                        .setFormaPagamento("Débito").build();
        proxy     = new DadosPedidoProxy(pedido);
        atendente = new AtendenteCaixa("João", proxy);
    }

    @Test
    void proxyNaoDeveCarregarDadosAntesDoAcesso() {
        assertFalse(proxy.isCarregado());
    }

    @Test
    void proxyDeveCarregarDadosAoAcessarPelaprimeiraVez() {
        proxy.getNomeCliente();
        assertTrue(proxy.isCarregado());
    }

    @Test
    void proxyDeveRetornarNomeClienteCorreto() {
        assertEquals("Carlos", proxy.getNomeCliente());
    }

    @Test
    void proxyDeveRetornarFormaPagamentoCorreta() {
        assertEquals("Débito", proxy.getFormaPagamento());
    }

    @Test
    void proxyDeveRetornarCustoTotalCorreto() {
        assertEquals(pedido.getCustoTotal(), proxy.getCustoTotal(), 0.01);
    }

    @Test
    void atendenteComAcessoBloqueadoDeveReceberNegativa() {
        String resultado = atendente.consultarResumo();
        assertTrue(resultado.contains("Acesso negado"));
    }

    @Test
    void atendenteComAcessoLiberadoDeveVerResumo() {
        atendente.liberarAcesso();
        String resultado = atendente.consultarResumo();
        assertTrue(resultado.contains("Carlos"));
        assertTrue(resultado.contains("Débito"));
    }

    @Test
    void bloquearAcessoDeveVoltarANegarConsulta() {
        atendente.liberarAcesso();
        atendente.bloquearAcesso();
        assertTrue(atendente.consultarResumo().contains("Acesso negado"));
    }

    @Test
    void proxyImplementaIDadosPedido() {
        assertInstanceOf(IDadosPedido.class, proxy);
    }
}
