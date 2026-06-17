package Classes.HistoricoEPosVenda;

public class AplicadorPromocao {
    private InterpretadorPromocao expressao;

    public AplicadorPromocao(InterpretadorPromocao expressao) { this.expressao = expressao; }

    public double calcular(ContextoPromocao contexto) { return expressao.interpretar(contexto); }
}
