package Classes;

public class AtendenteCaixa {
    private String nome;
    private boolean acessoLiberado;
    private IDadosPedido dadosPedido;

    public AtendenteCaixa(String nome, IDadosPedido dadosPedido) {
        this.nome          = nome;
        this.dadosPedido   = dadosPedido;
        this.acessoLiberado = false;
    }

    public void liberarAcesso()  { this.acessoLiberado = true; }
    public void bloquearAcesso() { this.acessoLiberado = false; }

    public String consultarResumo() {
        if (!acessoLiberado)
            return "Acesso negado: " + nome + " não tem permissão para ver dados do pedido.";
        return dadosPedido.getResumo();
    }

    public String getNome()           { return nome; }
    public boolean isAcessoLiberado() { return acessoLiberado; }
}
