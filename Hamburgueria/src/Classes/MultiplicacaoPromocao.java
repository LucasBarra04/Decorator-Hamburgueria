package Classes;

public class MultiplicacaoPromocao implements InterpretadorPromocao {
    private InterpretadorPromocao esquerdo;
    private InterpretadorPromocao direito;

    public MultiplicacaoPromocao(InterpretadorPromocao esquerdo, InterpretadorPromocao direito) {
        this.esquerdo = esquerdo;
        this.direito  = direito;
    }

    @Override
    public double interpretar(ContextoPromocao contexto) {
        return esquerdo.interpretar(contexto) * direito.interpretar(contexto);
    }
}
