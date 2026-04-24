package Classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    private Pedido criarPedido() {
        fabricaHamburguer fabrica = new fabricaHamburguerGourmet();
        Hamburguer h = fabrica.criarHamburguer("Beef", new malPassado());
        h = new Cheddar(h);
        return new Pedido(h);
    }

    @Test
    void clienteDeveSerNotificadoAoAprovar() {
        Pedido pedido = criarPedido();
        ClienteObserver cliente = new ClienteObserver("João");
        pedido.adicionarObserver(cliente);

        pedido.aprovar();

        assertNotNull(cliente.getUltimaNotificacao());
        assertTrue(cliente.getUltimaNotificacao().contains("Aprovado"));
    }

    @Test
    void cozinhaDeveSerNotificadaAoAprovar() {
        Pedido pedido = criarPedido();
        CozinhaObserver cozinha = new CozinhaObserver("Grill");
        pedido.adicionarObserver(cozinha);

        pedido.aprovar();

        assertNotNull(cozinha.getUltimaNotificacao());
        assertTrue(cozinha.getUltimaNotificacao().contains("Aprovado"));
    }

    @Test
    void ambosObserversDevemSerNotificadosNoFluxoCompleto() {
        Pedido pedido = criarPedido();
        ClienteObserver cliente = new ClienteObserver("Maria");
        CozinhaObserver cozinha = new CozinhaObserver("Grill");
        pedido.adicionarObserver(cliente);
        pedido.adicionarObserver(cozinha);

        pedido.aprovar();
        pedido.preparar();
        pedido.transportar();
        pedido.entregar();

        assertTrue(cliente.getUltimaNotificacao().contains("Entregue"));
        assertTrue(cozinha.getUltimaNotificacao().contains("Entregue"));
    }

    @Test
    void observerRemovidoNaoDeveReceberNotificacao() {
        Pedido pedido = criarPedido();
        ClienteObserver cliente = new ClienteObserver("João");
        CozinhaObserver cozinha = new CozinhaObserver("Grill");
        pedido.adicionarObserver(cliente);
        pedido.adicionarObserver(cozinha);

        pedido.removerObserver(cozinha);
        pedido.aprovar();

        assertNotNull(cliente.getUltimaNotificacao());
        assertNull(cozinha.getUltimaNotificacao());
    }

    @Test
    void cancelamentoDeveNotificarObservers() {
        Pedido pedido = criarPedido();
        ClienteObserver cliente = new ClienteObserver("João");
        CozinhaObserver cozinha = new CozinhaObserver("Grill");
        pedido.adicionarObserver(cliente);
        pedido.adicionarObserver(cozinha);

        pedido.cancelar();

        assertTrue(cliente.getUltimaNotificacao().contains("Cancelado"));
        assertTrue(cozinha.getUltimaNotificacao().contains("Cancelado"));
    }
}
