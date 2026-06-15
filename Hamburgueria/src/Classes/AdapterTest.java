package Classes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterTest {

    @Test
    void caixaDeveAprovarPagamentoPositivo() {
        Caixa caixa = new Caixa();
        assertTrue(caixa.efetuarPagamento(35.90));
    }

    @Test
    void caixaDeveRetornarConfirmacaoAposAprovacao() {
        Caixa caixa = new Caixa();
        caixa.efetuarPagamento(35.90);
        assertNotNull(caixa.getConfirmacao());
    }

    @Test
    void confirmacaoDeveConterCodigoLegadoECodigoGateway() {
        Caixa caixa = new Caixa();
        caixa.efetuarPagamento(35.90);
        String conf = caixa.getConfirmacao();
        assertTrue(conf.contains("LEG-"));
        assertTrue(conf.contains("GW-"));
    }

    @Test
    void adapterDeveHerarDeSistemaPagamentoLegado() {
        PagamentoPix pix = new PagamentoPix();
        PagamentoLegadoAdapter adapter = new PagamentoLegadoAdapter(pix);
        assertInstanceOf(SistemaPagamentoLegado.class, adapter);
    }

    @Test
    void adapterDeveProcessarCodigoTransacaoAposDebito() {
        PagamentoPix pix = new PagamentoPix();
        PagamentoLegadoAdapter adapter = new PagamentoLegadoAdapter(pix);
        adapter.processarPagamento(50.0);
        assertNotNull(adapter.getCodigoTransacao());
    }

    @Test
    void pagamentoPixDeveImplementarIGatewayPagamento() {
        IGatewayPagamento gw = new PagamentoPix();
        assertInstanceOf(IGatewayPagamento.class, gw);
    }

    @Test
    void pagamentoPixDeveGerarConfirmacaoAposEfetuar() {
        PagamentoPix pix = new PagamentoPix();
        pix.pagar(29.90);
        assertNotNull(pix.getConfirmacao());
        assertTrue(pix.getConfirmacao().startsWith("PIX-OK-"));
    }

    @Test
    void caixaDeveNegarPagamentoZerado() {
        Caixa caixa = new Caixa();
        assertFalse(caixa.efetuarPagamento(0.0));
    }
}
