package Test;
import Classes.HistoricoEPosVenda.CardapioFly;
import Classes.HistoricoEPosVenda.Ingrediente;
import Classes.HistoricoEPosVenda.IngredienteFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightTest {

    @Test
    void mesmosIngredientesDevemCompartilharInstancia() {
        Ingrediente i1 = IngredienteFactory.getIngrediente("Queijo", "Queijo cheddar", 2.0);
        Ingrediente i2 = IngredienteFactory.getIngrediente("Queijo", "Queijo cheddar", 2.0);
        assertSame(i1, i2);
    }

    @Test
    void ingredientesDiferentesDevemTerInstanciasDiferentes() {
        Ingrediente queijo = IngredienteFactory.getIngrediente("Queijo",  "Queijo cheddar", 2.0);
        Ingrediente picles = IngredienteFactory.getIngrediente("Picles2", "Picles em fatias", 1.0);
        assertNotSame(queijo, picles);
    }

    @Test
    void factoryNaoDeveCriarDuplicatas() {
        IngredienteFactory.getIngrediente("Alface", "Alface americana", 0.5);
        int totalAntes = IngredienteFactory.getTotalIngredientes();
        IngredienteFactory.getIngrediente("Alface", "Alface americana", 0.5);
        assertEquals(totalAntes, IngredienteFactory.getTotalIngredientes());
    }

    @Test
    void cardapioDeveAdicionarItensCorretamente() {
        CardapioFly cardapio = new CardapioFly();
        cardapio.addItem("I001", 2, "Bacon", "Bacon crocante", 3.0);
        cardapio.addItem("I002", 1, "Bacon", "Bacon crocante", 3.0);
        assertEquals(2, cardapio.getTotalItens());
    }

    @Test
    void doisItensComMesmoIngredienteDevemCompartilharInstancia() {
        CardapioFly cardapio = new CardapioFly();
        cardapio.addItem("I001", 1, "Tomate", "Tomate fresco", 0.5);
        cardapio.addItem("I002", 2, "Tomate", "Tomate fresco", 0.5);
        assertSame(cardapio.getItens().get(0).getIngrediente(),
                   cardapio.getItens().get(1).getIngrediente());
    }

    @Test
    void custoTotalDeveConsiderarQuantidade() {
        CardapioFly cardapio = new CardapioFly();
        cardapio.addItem("I001", 3, "Molho", "Molho especial", 1.0);
        assertEquals(3.0, cardapio.getItens().get(0).getCustoTotal(), 0.01);
    }

    @Test
    void ingredienteDeveManterDadosIntrinsecosCorretos() {
        Ingrediente i = IngredienteFactory.getIngrediente("Ovo", "Ovo frito", 1.5);
        assertEquals("Ovo",       i.getNome());
        assertEquals("Ovo frito", i.getDescricao());
        assertEquals(1.5,         i.getCusto(), 0.01);
    }
}
