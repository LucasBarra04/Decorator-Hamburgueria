package Classes;

public abstract class decoradorHamburguer implements Hamburguer {
    protected Hamburguer hamburguerDecorado;

    public decoradorHamburguer(Hamburguer hamburguer) {
        this.hamburguerDecorado = hamburguer;
    }

    @Override
    public String getDescricao() {
        return hamburguerDecorado.getDescricao();
    }

    @Override
    public double getCusto() {
        return hamburguerDecorado.getCusto();
    }

}
