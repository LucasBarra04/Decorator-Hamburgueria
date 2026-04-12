package Classes;

public class chickenBurguer implements Hambuguer {
    private formaCozinhar forma;

    public chickenBurguer(formaCozinhar forma) {
        this.forma = forma;
    }

    @Override
    public String getDescricao() {
        return "Hambúrguer de Carne de Frango (" + forma.preparo() + ")";
    }

    @Override
    public double getCusto() {
        return 20.00 + forma.getCustoForma();
    }

}
