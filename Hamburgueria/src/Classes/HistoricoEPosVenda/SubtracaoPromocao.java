package Classes.HistoricoEPosVenda;

public class SubtracaoPromocao implements InterpretadorPromocao {
    private InterpretadorPromocao esquerdo;
    private InterpretadorPromocao direito;

    public SubtracaoPromocao(InterpretadorPromocao esquerdo, InterpretadorPromocao direito) {
        this.esquerdo = esquerdo;
        this.direito  = direito;
    }

    @Override
    public double interpretar(ContextoPromocao contexto) {
        return esquerdo.interpretar(contexto) - direito.interpretar(contexto);
    }
}
