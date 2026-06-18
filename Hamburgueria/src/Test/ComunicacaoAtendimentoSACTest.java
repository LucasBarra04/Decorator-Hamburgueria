package Test;
import Classes.PagamentoEFechamento.ClienteSAC;
import Classes.PagamentoEFechamento.CozinhaSAC;
import Classes.PagamentoEFechamento.EntregadorSAC;
import Classes.PagamentoEFechamento.SAC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComunicacaoAtendimentoSACTest {
    private SAC sac;
    private ClienteSAC cliente;
    private CozinhaSAC cozinha;
    private EntregadorSAC entregador;

    @BeforeEach
    void setUp() {
        sac        = new SAC();
        cliente    = new ClienteSAC(sac, "João");
        cozinha    = new CozinhaSAC(sac);
        entregador = new EntregadorSAC(sac, "Moto01");
        sac.registrar(cliente);
        sac.registrar(cozinha);
        sac.registrar(entregador);
    }

    @Test
    void mensagemDoClienteDeveChegarNaCozinha() {
        cliente.enviar("Cadê meu pedido?");
        assertNotNull(cozinha.getUltimaMensagem());
        assertTrue(cozinha.getUltimaMensagem().contains("Cadê meu pedido?"));
    }

    @Test
    void mensagemDoClienteDeveChegarNoEntregador() {
        cliente.enviar("Cadê meu pedido?");
        assertNotNull(entregador.getUltimaMensagem());
        assertTrue(entregador.getUltimaMensagem().contains("Cadê meu pedido?"));
    }

    @Test
    void mensagemDaCozinhaDeveChegarNoCliente() {
        cozinha.enviar("Pedido pronto!");
        assertNotNull(cliente.getUltimaMensagem());
        assertTrue(cliente.getUltimaMensagem().contains("Pedido pronto!"));
    }

    @Test
    void remetenteNaoDeveReceberPropriasMensagens() {
        cliente.enviar("Olá!");
        assertNull(cliente.getUltimaMensagem());
    }

    @Test
    void mensagemDeveConterNomeDoRemetente() {
        cliente.enviar("Teste");
        assertTrue(cozinha.getUltimaMensagem().contains("João"));
    }

    @Test
    void entregadorDeveReceberMensagemDaCozinha() {
        cozinha.enviar("Pedido saiu!");
        assertTrue(entregador.getUltimaMensagem().contains("Pedido saiu!"));
    }
}
