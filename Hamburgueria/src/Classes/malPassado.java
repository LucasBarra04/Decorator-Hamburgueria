package Classes;

public class malPassado implements formaCozinhar {
    @Override
    public String preparo() {
        return "Bife mal passado";
    }

    @Override
    public double getCustoForma() {
        return 2.0;
    }
}
