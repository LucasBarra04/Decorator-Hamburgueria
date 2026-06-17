package Classes.HistoricoEPosVenda;

public class ValorPromocao implements InterpretadorPromocao {
    private String variavel;

    public ValorPromocao(String variavel) { this.variavel = variavel; }

    @Override
    public double interpretar(ContextoPromocao contexto) { return contexto.obter(variavel); }
}
