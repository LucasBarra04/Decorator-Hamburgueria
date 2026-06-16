package Test;

import Classes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    private Hamburguer criarBeefComCheddar() {
        Hamburguer h = new BeefBurguer(new bemPassado());
        return new Cheddar(h);
    }

    @Test
    void buildDeveRetornarPedidoNaoNulo() {
        PedidoCompleto p = new PedidoBuilder().build();
        assertNotNull(p);
    }

    @Test
    void nomeClienteDeveSerAtribuido() {
        PedidoCompleto p = new PedidoBuilder()
                .setNomeCliente("Carlos")
                .build();
        assertEquals("Carlos", p.getNomeCliente());
    }

    @Test
    void hamburguerDeveSerAtribuido() {
        Hamburguer h = criarBeefComCheddar();
        PedidoCompleto p = new PedidoBuilder()
                .setHamburguer(h)
                .build();
        assertNotNull(p.getHamburguer());
    }

    @Test
    void acompanhamentoOpcionalNaoAtribuidoDeveSerNulo() {
        PedidoCompleto p = new PedidoBuilder()
                .setNomeCliente("Ana")
                .setHamburguer(criarBeefComCheddar())
                .build();
        assertNull(p.getAcompanhamento());
    }

    @Test
    void custoTotalDeveIncluirHamburguerEAcompanhamento() {
        Hamburguer h = new BeefBurguer(new malPassado());
        PedidoCompleto p = new PedidoBuilder()
                .setHamburguer(h)
                .setAcompanhamento(new AcompanhamentoBatataFrita())
                .build();
        assertEquals(h.getCusto() + 8.0, p.getCustoTotal(), 0.01);
    }

    @Test
    void custoTotalSemAcompanhamentoDeveSerApenasCustoHamburguer() {
        Hamburguer h = new BeefBurguer(new noPonto());
        PedidoCompleto p = new PedidoBuilder()
                .setHamburguer(h)
                .build();
        assertEquals(h.getCusto(), p.getCustoTotal(), 0.01);
    }

    @Test
    void paraViagemDeveSerAtribuido() {
        PedidoCompleto p = new PedidoBuilder()
                .setParaViagem(true)
                .build();
        assertTrue(p.isParaViagem());
    }

    @Test
    void fluentInterfaceDeveRetornarOMesmoBuilder() {
        PedidoBuilder builder = new PedidoBuilder();
        assertSame(builder, builder.setNomeCliente("Teste"));
    }

    @Test
    void buildDeveRetornarSempreAMesmaInstancia() {
        PedidoBuilder builder = new PedidoBuilder().setNomeCliente("João");
        assertSame(builder.build(), builder.build());
    }
}
