package Classes;

public class Cheddar extends decoradorHamburguer{

    public Cheddar(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return hamburguerDecorado.getDescricao() + ", Com Cheddar";
    }

    @Override
    public double getCusto() {
        return hamburguerDecorado.getCusto() + 2.0;
    }

}
