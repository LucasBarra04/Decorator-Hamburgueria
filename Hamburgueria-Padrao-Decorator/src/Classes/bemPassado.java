package Classes;

public class bemPassado implements formaCozinhar {
    @Override
    public String preparo() {
        return "Bife bem passado";
    }

    @Override
    public double getCustoForma() {
        return 6.0;
    }
}
