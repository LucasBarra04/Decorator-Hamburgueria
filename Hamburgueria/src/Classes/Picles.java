package Classes;

public class Picles extends decoradorHamburguer{

    public Picles(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return hamburguerDecorado.getDescricao() + ", Com Picles";
    }

    @Override
    public double getCusto() {
        return hamburguerDecorado.getCusto() + 1.50;
    }

}
