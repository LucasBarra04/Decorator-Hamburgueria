package Classes;

public class CozinhaObserver implements Observer {
    private String setor;
    private String ultimaNotificacao;

    public CozinhaObserver(String setor) {
        this.setor = setor;
    }

    @Override
    public void update(String evento, String descricao) {
        this.ultimaNotificacao = "[Cozinha - " + setor + "] " + evento + ": " + descricao;
        System.out.println(ultimaNotificacao);
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public String getSetor() {
        return setor;
    }
}
