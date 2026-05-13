package Classes;

public class ItemHamburguer extends ItemCardapio {
    private Hamburguer hamburguer;

    public ItemHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
        setDescricao(hamburguer.getDescricao());
    }

    public Hamburguer getHamburguer() { return hamburguer; }

    @Override
    public String getConteudo() {
        return "   - " + getDescricao() + " R$" + hamburguer.getCusto();
    }
}
