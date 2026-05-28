package Classes;
public class CozinhaSAC extends ParticipanteSAC {
    private String ultimaMensagem;
    public CozinhaSAC(SAC sac) { super(sac); }
    public void enviar(String mensagem) { sac.enviarMensagem(mensagem, this); }
    @Override public String getNome() { return "Cozinha"; }
    @Override public void receberMensagem(String mensagem, String remetente) {
        this.ultimaMensagem = "[" + remetente + "] " + mensagem;
        System.out.println(ultimaMensagem);
    }
    public String getUltimaMensagem() { return ultimaMensagem; }
}
