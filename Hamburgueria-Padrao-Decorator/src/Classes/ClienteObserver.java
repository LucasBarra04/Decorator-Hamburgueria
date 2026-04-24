package Classes;

public class ClienteObserver implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public ClienteObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String evento, String descricao) {
        this.ultimaNotificacao = "[Cliente " + nome + "] " + evento + ": " + descricao;
        System.out.println(ultimaNotificacao);
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public String getNome() {
        return nome;
    }
}
