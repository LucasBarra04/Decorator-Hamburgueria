package Test;
import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChainTest {
    private Atendente atendente;

    @BeforeEach
    void setUp() {
        atendente = new Atendente();
        Cozinheiro cozinheiro = new Cozinheiro();
        GerenteChain gerente  = new GerenteChain();
        Dono dono             = new Dono();
        atendente.setSuperior(cozinheiro);
        cozinheiro.setSuperior(gerente);
        gerente.setSuperior(dono);
    }

    @Test
    void simplesAbaixoDe50DeveSerAprovadoPeloAtendente() {
        PedidoEspecial p = new PedidoEspecial();
        p.setTipo(TipoPedidoEspecialSimples.getInstance());
        p.setValor(30.0);
        assertTrue(atendente.aprovarPedido(p).contains("Atendente"));
    }

    @Test
    void comboAte100DeveSerAprovadoPeloCozinheiro() {
        PedidoEspecial p = new PedidoEspecial();
        p.setTipo(TipoPedidoEspecialCombo.getInstance());
        p.setValor(80.0);
        assertTrue(atendente.aprovarPedido(p).contains("Cozinheiro"));
    }

    @Test
    void corporativoAte200DeveSerAprovadoPeloGerente() {
        PedidoEspecial p = new PedidoEspecial();
        p.setTipo(TipoPedidoEspecialCorporativo.getInstance());
        p.setValor(150.0);
        assertTrue(atendente.aprovarPedido(p).contains("Gerente"));
    }

    @Test
    void eventoDeveSerAprovadoPeloDono() {
        PedidoEspecial p = new PedidoEspecial();
        p.setTipo(TipoPedidoEspecialEvento.getInstance());
        p.setValor(500.0);
        assertTrue(atendente.aprovarPedido(p).contains("Dono"));
    }

    @Test
    void semSuperiorDeveRetornarNaoPodeAprovar() {
        Atendente solo = new Atendente();
        PedidoEspecial p = new PedidoEspecial();
        p.setTipo(TipoPedidoEspecialEvento.getInstance());
        p.setValor(500.0);
        assertTrue(solo.aprovarPedido(p).contains("não pôde ser aprovado"));
    }

    @Test
    void tiposSaoSingleton() {
        assertSame(TipoPedidoEspecialSimples.getInstance(),     TipoPedidoEspecialSimples.getInstance());
        assertSame(TipoPedidoEspecialCombo.getInstance(),       TipoPedidoEspecialCombo.getInstance());
        assertSame(TipoPedidoEspecialCorporativo.getInstance(), TipoPedidoEspecialCorporativo.getInstance());
        assertSame(TipoPedidoEspecialEvento.getInstance(),      TipoPedidoEspecialEvento.getInstance());
    }
}
