package Test;
import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrototypeTest {

    private PedidoCompleto original;

    @BeforeEach
    void setUp() {
        Hamburguer h = new BeefBurguer(new bemPassado());
        h = new Cheddar(h);
        original = new PedidoBuilder()
                .setNomeCliente("Lucas")
                .setHamburguer(h)
                .setAcompanhamento(new AcompanhamentoBatataFrita())
                .setFormaPagamento("Pix")
                .setObservacoes("Sem cebola")
                .setParaViagem(true)
                .build();
    }

    @Test
    void cloneDeveRetornarInstanciaDiferente() {
        PedidoCompleto clone = (PedidoCompleto) original.clone();
        assertNotSame(original, clone);
    }

    @Test
    void cloneDeveManterMesmosValores() {
        PedidoCompleto clone = (PedidoCompleto) original.clone();
        assertEquals(original.getNomeCliente(),   clone.getNomeCliente());
        assertEquals(original.getFormaPagamento(), clone.getFormaPagamento());
        assertEquals(original.getObservacoes(),   clone.getObservacoes());
        assertEquals(original.isParaViagem(),     clone.isParaViagem());
    }

    @Test
    void alterarNomeDoCloneNaoDeveAfetarOriginal() {
        PedidoCompleto clone = (PedidoCompleto) original.clone();
        clone.setNomeCliente("Maria");
        assertEquals("Lucas", original.getNomeCliente());
    }

    @Test
    void alterarFormaPagamentoDoCloneNaoDeveAfetarOriginal() {
        PedidoCompleto clone = (PedidoCompleto) original.clone();
        clone.setFormaPagamento("Cartão");
        assertEquals("Pix", original.getFormaPagamento());
    }

    @Test
    void cloneDeveTerMesmoCustoTotal() {
        PedidoCompleto clone = (PedidoCompleto) original.clone();
        assertEquals(original.getCustoTotal(), clone.getCustoTotal(), 0.01);
    }

    @Test
    void clonarPermiteRepetirPedidoComAlteracoes() {
        PedidoCompleto repetido = (PedidoCompleto) original.clone();
        repetido.setNomeCliente("Maria");
        repetido.setFormaPagamento("Cartão");
        repetido.setObservacoes("Com tudo");

        assertEquals("Lucas", original.getNomeCliente());
        assertEquals("Maria", repetido.getNomeCliente());
        assertSame(original.getHamburguer(), repetido.getHamburguer());
    }
}
