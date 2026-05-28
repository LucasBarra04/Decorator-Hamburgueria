package Classes;
import java.util.ArrayList;
import java.util.List;
public class SAC {
    private List<ParticipanteSAC> participantes = new ArrayList<>();
    public void registrar(ParticipanteSAC participante) { participantes.add(participante); }
    public void enviarMensagem(String mensagem, ParticipanteSAC remetente) {
        System.out.println("[SAC] " + remetente.getNome() + " → \"" + mensagem + "\"");
        for (ParticipanteSAC p : participantes) {
            if (!p.equals(remetente)) p.receberMensagem(mensagem, remetente.getNome());
        }
    }
}
