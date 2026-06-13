package Classes;
import java.util.ArrayList;
import java.util.List;

public class FilaCozinha {
    private List<ComandoCozinha> historico = new ArrayList<>();

    public void executarComando(ComandoCozinha comando) {
        comando.executar();
        historico.add(comando);
    }

    public void desfazerUltimo() {
        if (!historico.isEmpty()) {
            ComandoCozinha ultimo = historico.remove(historico.size() - 1);
            ultimo.cancelar();
        }
    }

    public int getTotalComandos()              { return historico.size(); }
    public List<ComandoCozinha> getHistorico() { return historico; }
}
