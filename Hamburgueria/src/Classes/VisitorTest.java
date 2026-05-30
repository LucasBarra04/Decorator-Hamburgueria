package Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class VisitorTest {

    private BeefBurguerVisitavel beef;
    private CheddarVisitavel cheddar;
    private PiclesVisitavel picles;
    private List<Visitavel> itens;

    @BeforeEach
    void setUp() {
        beef    = new BeefBurguerVisitavel(new bemPassado());
        cheddar = new CheddarVisitavel(beef);
        picles  = new PiclesVisitavel(cheddar);
        itens   = List.of(beef, cheddar, picles);
    }

    @Test
    void relatorioDeveSomarCustosDeTodosOsItens() {
        RelatorioVisitor v = new RelatorioVisitor();
        for (Visitavel item : itens) item.aceitar(v);
        double esperado = beef.getCusto() + cheddar.getCusto() + picles.getCusto();
        assertEquals(esperado, v.getTotalCalculado(), 0.01);
    }

    @Test
    void relatorioDeveConterDescricaoDoBeef() {
        RelatorioVisitor v = new RelatorioVisitor();
        beef.aceitar(v);
        assertTrue(v.getRelatorio().contains("BeefBurguer"));
    }

    @Test
    void relatorioDeveConterDescricaoDoCheddar() {
        RelatorioVisitor v = new RelatorioVisitor();
        cheddar.aceitar(v);
        assertTrue(v.getRelatorio().contains("Cheddar"));
    }

    @Test
    void descontoDeveCalcularPercentualCorreto() {
        DescontoVisitor v = new DescontoVisitor(10);
        beef.aceitar(v);
        assertEquals(beef.getCusto() * 0.10, v.getTotalDesconto(), 0.01);
    }

    @Test
    void descontoZeroDeveRetornarZero() {
        DescontoVisitor v = new DescontoVisitor(0);
        for (Visitavel item : itens) item.aceitar(v);
        assertEquals(0.0, v.getTotalDesconto(), 0.01);
    }

    @Test
    void doisVisitoresDiferentesPodemPercorrerMesmosItens() {
        RelatorioVisitor relatorio = new RelatorioVisitor();
        DescontoVisitor  desconto  = new DescontoVisitor(10);
        for (Visitavel item : itens) {
            item.aceitar(relatorio);
            item.aceitar(desconto);
        }
        assertTrue(relatorio.getTotalCalculado() > 0);
        assertTrue(desconto.getTotalDesconto() > 0);
    }

    @Test
    void chickenBurguerVisitavelDeveAceitarVisitor() {
        ChickenBurguerVisitavel chicken = new ChickenBurguerVisitavel(new noPonto());
        RelatorioVisitor v = new RelatorioVisitor();
        chicken.aceitar(v);
        assertTrue(v.getRelatorio().contains("ChickenBurguer"));
    }
}
