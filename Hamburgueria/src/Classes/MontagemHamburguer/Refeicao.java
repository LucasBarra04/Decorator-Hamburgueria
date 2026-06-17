package Classes.MontagemHamburguer;

public class Refeicao {
    private Hamburguer hamburguer;
    private Acompanhamento acompanhamento;

    public Refeicao(FabricaAbstrataHamburguer fabrica) {
        this.hamburguer     = fabrica.criarHamburguer();
        this.acompanhamento = fabrica.criarAcompanhamento();
    }

    public Hamburguer getHamburguer()         { return hamburguer; }
    public Acompanhamento getAcompanhamento() { return acompanhamento; }

    public double getCustoTotal() {
        return hamburguer.getCusto() + acompanhamento.getCusto();
    }

    public String getDescricaoCompleta() {
        return hamburguer.getDescricao()
                + " + " + acompanhamento.getDescricao()
                + " | Total: R$" + getCustoTotal();
    }
}
