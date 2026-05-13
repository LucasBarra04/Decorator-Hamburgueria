package Classes;

public class noPonto implements formaCozinhar{
    @Override
    public String preparo() {
        return "Bife no ponto";
    }

    @Override
    public double getCustoForma() {
        return 4.0;
    }

}
