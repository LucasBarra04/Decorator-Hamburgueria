package Test;

import Classes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    void refeicaoClassicaDeveConterHamburguer() {
        Refeicao r = new Refeicao(new FabricaClassica());
        assertNotNull(r.getHamburguer());
    }

    @Test
    void refeicaoClassicaDeveConterBatataFrita() {
        Refeicao r = new Refeicao(new FabricaClassica());
        assertInstanceOf(AcompanhamentoBatataFrita.class, r.getAcompanhamento());
    }

    @Test
    void refeicaoGourmetDeveConterHamburguer() {
        Refeicao r = new Refeicao(new FabricaGourmet());
        assertNotNull(r.getHamburguer());
    }

    @Test
    void refeicaoGourmetDeveConterOnionRings() {
        Refeicao r = new Refeicao(new FabricaGourmet());
        assertInstanceOf(AcompanhamentoOnionRings.class, r.getAcompanhamento());
    }

    @Test
    void gourmetDeveCustaMaisQueClassica() {
        Refeicao classica = new Refeicao(new FabricaClassica());
        Refeicao gourmet  = new Refeicao(new FabricaGourmet());
        assertTrue(gourmet.getCustoTotal() > classica.getCustoTotal());
    }

    @Test
    void custoTotalDeveSerSomaDosComponentes() {
        Refeicao r = new Refeicao(new FabricaClassica());
        double esperado = r.getHamburguer().getCusto() + r.getAcompanhamento().getCusto();
        assertEquals(esperado, r.getCustoTotal(), 0.01);
    }

    @Test
    void descricaoCompletaDeveConterAmbosOsItens() {
        Refeicao r = new Refeicao(new FabricaClassica());
        assertTrue(r.getDescricaoCompleta().contains("Batata Frita"));
        assertTrue(r.getDescricaoCompleta().contains("R$"));
    }

    @Test
    void fabricasDevemProduzirFamiliasCoerentes() {
        Refeicao classica = new Refeicao(new FabricaClassica());
        Refeicao gourmet  = new Refeicao(new FabricaGourmet());
        assertInstanceOf(AcompanhamentoBatataFrita.class, classica.getAcompanhamento());
        assertInstanceOf(AcompanhamentoOnionRings.class,  gourmet.getAcompanhamento());
    }
}
