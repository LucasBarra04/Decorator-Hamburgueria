package Test;

import Classes.MontagemHamburguer.*;
import Classes.PagamentoEFechamento.GerenciaPedidos;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MontagemHamburguerTest {

    GerenciaPedidos gerenciaPedidos = GerenciaPedidos.getInstance();
    fabricaHamburguer fabrica = new fabricaHamburguerGourmet();

    @Test
    @Order(1)
    void testBeefMalPassadoComCheddarEPiclesCusto() {
        Hamburguer h01 = fabrica.criarHamburguer("Beef", new malPassado());
        h01 = new Cheddar(h01);
        h01 = new Picles(h01);

        assertEquals(31.50, h01.getCusto());
    }

    @Test
    @Order(2)
    void testBeefMalPassadoComCheddarEPiclesDescricao() {
        Hamburguer h01 = fabrica.criarHamburguer("Beef", new malPassado());
        h01 = new Cheddar(h01);
        h01 = new Picles(h01);

        assertEquals("Hambúrguer de Carne Bovina (Bife mal passado), Com Cheddar, Com Picles", h01.getDescricao());
    }

    @Test
    @Order(3)
    void testBeefMalPassadoComCheddarEPiclesRegistro() {
        Hamburguer h01 = fabrica.criarHamburguer("Beef", new malPassado());
        h01 = new Cheddar(h01);
        h01 = new Picles(h01);

        String retornoRegistro = gerenciaPedidos.registroPedidos(h01);
        assertEquals("Pedido: 1 | Hambúrguer de Carne Bovina (Bife mal passado), Com Cheddar, Com Picles | 31.5", retornoRegistro);
    }

    @Test
    @Order(4)
    void testChickenNoPontoComCheddarCusto() {
        Hamburguer h02 = fabrica.criarHamburguer("Chicken", new noPonto());
        h02 = new Cheddar(h02);

        assertEquals(26.00, h02.getCusto());
    }

    @Test
    @Order(5)
    void testChickenNoPontoComCheddarDescricao() {
        Hamburguer h02 = fabrica.criarHamburguer("Chicken", new noPonto());
        h02 = new Cheddar(h02);

        assertEquals("Hambúrguer de Carne de Frango (Bife no ponto), Com Cheddar", h02.getDescricao());
    }

    @Test
    @Order(6)
    void testChickenNoPontoComCheddarRegistro() {
        Hamburguer h02 = fabrica.criarHamburguer("Chicken", new noPonto());
        h02 = new Cheddar(h02);

        String retornoRegistro = gerenciaPedidos.registroPedidos(h02);
        assertEquals("Pedido: 2 | Hambúrguer de Carne de Frango (Bife no ponto), Com Cheddar | 26.0", retornoRegistro);
    }

    @Test
    @Order(7)
    void testBeefBemPassadoSemAdicionaisCusto() {
        Hamburguer h03 = fabrica.criarHamburguer("Beef", new bemPassado());

        assertEquals(32.00, h03.getCusto());
    }

    @Test
    @Order(8)
    void testBeefBemPassadoSemAdicionaisDescricao() {
        Hamburguer h03 = fabrica.criarHamburguer("Beef", new bemPassado());

        assertEquals("Hambúrguer de Carne Bovina (Bife bem passado)", h03.getDescricao());
    }

    @Test
    @Order(9)
    void testBeefBemPassadoSemAdicionaisRegistro() {
        Hamburguer h03 = fabrica.criarHamburguer("Beef", new bemPassado());

        String retornoRegistro = gerenciaPedidos.registroPedidos(h03);
        assertEquals("Pedido: 3 | Hambúrguer de Carne Bovina (Bife bem passado) | 32.0", retornoRegistro);
    }

    @Test
    @Order(10)
    void testRelatorioPedidosAcumulados() {
        String relatorio = gerenciaPedidos.relatorioPedidos();
        assertEquals("Total de Pedidos: 3 | Total de Receita: 89.5", relatorio);
    }
}