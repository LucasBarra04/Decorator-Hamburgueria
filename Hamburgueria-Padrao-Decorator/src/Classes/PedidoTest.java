package Classes;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PedidoTest {

    GerenciaPedidos gerenciaPedidos = GerenciaPedidos.getInstance();
    fabricaHamburguer fabrica = new fabricaHamburguerGourmet();

    @Test
    @Order(1)
    void testBeefMalPassadoComCheddarEPicles() {
        Hambuguer h01 = fabrica.criarHamburguer("Beef", new malPassado());
        h01 = new Cheddar(h01);
        h01 = new Picles(h01);

        assertEquals(31.50, h01.getCusto());
        assertEquals("Hambúrguer de Carne Bovina (Bife mal passado), Com Cheddar, Com Picles", h01.getDescricao());
        String retornoRegistro = gerenciaPedidos.registroPedidos(h01);
        assertEquals("Pedido: 1 | Hambúrguer de Carne Bovina (Bife mal passado), Com Cheddar, Com Picles | 31.5", retornoRegistro);
    }

    @Test
    @Order(2)
    void testChickenNoPontoComCheddar() {
        Hambuguer h02 = fabrica.criarHamburguer("Chicken", new noPonto());
        h02 = new Cheddar(h02);

        assertEquals(26.00, h02.getCusto());
        assertEquals("Hambúrguer de Carne de Frango (Bife no ponto), Com Cheddar", h02.getDescricao());
        String retornoRegistro = gerenciaPedidos.registroPedidos(h02);
        assertEquals("Pedido: 2 | Hambúrguer de Carne de Frango (Bife no ponto), Com Cheddar | 26.0", retornoRegistro);
    }

    @Test
    @Order(3)
    void testBeefBemPassadoSemAdicionais() {
        Hambuguer h03 = fabrica.criarHamburguer("Beef", new bemPassado());

        assertEquals(32.00, h03.getCusto());
        assertEquals("Hambúrguer de Carne Bovina (Bife bem passado)", h03.getDescricao());
        String retornoRegistro = gerenciaPedidos.registroPedidos(h03);
        assertEquals("Pedido: 3 | Hambúrguer de Carne Bovina (Bife bem passado) | 32.0", retornoRegistro);
    }

    @Test
    @Order(4)
    void testRelatorioPedidosAcumulados() {
        String relatorio = gerenciaPedidos.relatorioPedidos();
        assertEquals("Total de Pedidos: 3 | Total de Receita: 89.5", relatorio);
    }
}