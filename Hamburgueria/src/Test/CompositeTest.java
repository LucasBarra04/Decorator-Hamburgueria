package Test;

import Classes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompositeTest {

    private ItemHamburguer criarBeef() {
        fabricaHamburguer fabrica = new fabricaHamburguerGourmet();
        Hamburguer h = fabrica.criarHamburguer("Beef", new malPassado());
        return new ItemHamburguer(h);
    }

    private ItemHamburguer criarChicken() {
        fabricaHamburguer fabrica = new fabricaHamburguerGourmet();
        Hamburguer h = fabrica.criarHamburguer("Chicken", new noPonto());
        return new ItemHamburguer(h);
    }

    private ItemHamburguer criarBeefComCheddar() {
        fabricaHamburguer fabrica = new fabricaHamburguerGourmet();
        Hamburguer h = fabrica.criarHamburguer("Beef", new bemPassado());
        h = new Cheddar(h);
        return new ItemHamburguer(h);
    }

    private ItemHamburguer criarChickenComDecorador() {
        fabricaHamburguer fabrica = new fabricaHamburguerGourmet();
        Hamburguer h = fabrica.criarHamburguer("Chicken", new noPonto());
        h = new Picles(h);
        return new ItemHamburguer(h);
    }

    @Test
    void itemHamburguerDeveEstenderItemCardapio() {
        assertInstanceOf(ItemCardapio.class, criarBeef());
    }

    @Test
    void itemHamburguerDeveRetornarConteudoComDescricao() {
        ItemHamburguer item = criarBeef();
        assertNotNull(item.getConteudo());
        assertTrue(item.getConteudo().contains("R$"));
    }

    @Test
    void comboDeveEstenderItemCardapio() {
        Combo combo = new Combo();
        assertInstanceOf(ItemCardapio.class, combo);
    }

    @Test
    void comboDeveExibirTodosOsItens() {
        Combo combo = new Combo();
        combo.setDescricao("Combo Família");
        combo.addItem(criarBeef());
        combo.addItem(criarChicken());

        String conteudo = combo.getConteudo();
        assertTrue(conteudo.contains("Combo Família"));
        assertTrue(conteudo.contains("R$"));
    }

    @Test
    void comboDeveAceitarOutroComboComoItem() {
        Combo comboInterno = new Combo();
        comboInterno.setDescricao("Combo Duplo");
        comboInterno.addItem(criarBeef());
        comboInterno.addItem(criarBeef());

        Combo comboExterno = new Combo();
        comboExterno.setDescricao("Combo Super");
        comboExterno.addItem(comboInterno);
        comboExterno.addItem(criarChicken());

        String conteudo = comboExterno.getConteudo();
        assertTrue(conteudo.contains("Combo Super"));
        assertTrue(conteudo.contains("Combo Duplo"));
    }

    @Test
    void pedidoDeveAceitarHamburguerDeItemHamburguer() {
        ItemHamburguer item = criarBeef();
        Pedido pedido = new Pedido(item.getHamburguer());
        assertNotNull(pedido.getHamburguer());
        assertEquals("Pagamento Pendente", pedido.getEstado());
    }

    @Test
    void comboComDecoradorDeveIncluirCustoExtra() {
        ItemHamburguer semCheddar = criarBeef();
        ItemHamburguer comCheddar = criarBeefComCheddar();
        assertTrue(comCheddar.getHamburguer().getCusto()
                > semCheddar.getHamburguer().getCusto());
    }
}