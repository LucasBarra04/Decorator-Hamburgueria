package Classes;

public abstract class decoradorHamburguer implements Hambuguer{
    protected Hambuguer hamburguerDecorado;

    public decoradorHamburguer(Hambuguer hambuguer) {
        this.hamburguerDecorado = hambuguer;
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
