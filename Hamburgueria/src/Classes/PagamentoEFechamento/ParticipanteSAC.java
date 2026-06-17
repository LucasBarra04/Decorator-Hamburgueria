package Classes.PagamentoEFechamento;
public abstract class ParticipanteSAC {
    protected SAC sac;
    public ParticipanteSAC(SAC sac) { this.sac = sac; }
    public abstract String getNome();
    public abstract void receberMensagem(String mensagem, String remetente);
}
