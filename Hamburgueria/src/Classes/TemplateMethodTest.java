package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemplateMethodTest {

    private PedidoCompleto pedido;

    @BeforeEach
    void setUp() {
        Hamburguer h = new BeefBurguer(new bemPassado());
        h = new Cheddar(h);
        pedido = new PedidoBuilder()
                .setNomeCliente("Lucas")
                .setHamburguer(h)
                .setAcompanhamento(new AcompanhamentoBatataFrita())
                .setFormaPagamento("Pix")
                .build();
    }

    @Test
    void retiradaDeveTerTaxaZero() {
        TipoAtendimento r = new AtendimentoRetirada(pedido);
        assertEquals(0.0, r.calcularTaxa(), 0.01);
    }

    @Test
    void deliveryDeveTerTaxaDe650() {
        TipoAtendimento d = new AtendimentoDelivery(pedido);
        assertEquals(6.50, d.calcularTaxa(), 0.01);
    }

    @Test
    void retiradaValorFinalDeveSerIgualAoCustoTotalSemTaxa() {
        TipoAtendimento r = new AtendimentoRetirada(pedido);
        assertEquals(pedido.getCustoTotal(), r.calcularValorFinal(), 0.01);
    }

    @Test
    void deliveryValorFinalDeveIncluirTaxa() {
        TipoAtendimento d = new AtendimentoDelivery(pedido);
        assertEquals(pedido.getCustoTotal() + 6.50, d.calcularValorFinal(), 0.01);
    }

    @Test
    void deliveryDeveCustaMaisQueRetirada() {
        TipoAtendimento retirada = new AtendimentoRetirada(pedido);
        TipoAtendimento delivery = new AtendimentoDelivery(pedido);
        assertTrue(delivery.calcularValorFinal() > retirada.calcularValorFinal());
    }

    @Test
    void ambosUsamMesmoEsqueletoDeCalculo() {
        TipoAtendimento retirada = new AtendimentoRetirada(pedido);
        TipoAtendimento delivery = new AtendimentoDelivery(pedido);
        double diferencaEsperada = delivery.calcularTaxa() - retirada.calcularTaxa();
        double diferencaReal = delivery.calcularValorFinal() - retirada.calcularValorFinal();
        assertEquals(diferencaEsperada, diferencaReal, 0.01);
    }

    @Test
    void tipoAtendimentoRetiradaDeveRetornarNomeCorreto() {
        TipoAtendimento r = new AtendimentoRetirada(pedido);
        assertEquals("Retirada na Loja", r.getTipoAtendimento());
    }

    @Test
    void tipoAtendimentoDeliveryDeveRetornarNomeCorreto() {
        TipoAtendimento d = new AtendimentoDelivery(pedido);
        assertEquals("Delivery", d.getTipoAtendimento());
    }
}
