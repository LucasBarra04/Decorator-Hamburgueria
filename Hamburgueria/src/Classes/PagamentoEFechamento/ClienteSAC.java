package Classes.PagamentoEFechamento;

public class ClienteSAC extends ParticipanteSAC {
    private String nome;
    private String ultimaMensagem;
    public ClienteSAC(SAC sac, String nome) { super(sac); this.nome = nome; }
    public void enviar(String mensagem) { sac.enviarMensagem(mensagem, this); }
    @Override public String getNome() { return nome; }
    @Override public void receberMensagem(String mensagem, String remetente) {
        this.ultimaMensagem = "[" + remetente + "] " + mensagem;
        System.out.println(ultimaMensagem);
    }
    public String getUltimaMensagem() { return ultimaMensagem; }
}
