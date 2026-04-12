package Classes;

public class BeefBurguer implements Hambuguer{

    private formaCozinhar forma;

    public BeefBurguer(formaCozinhar forma) {
        this.forma = forma;
    }

    @Override
    public String getDescricao() {
        return "Hambúrguer de Carne Bovina (" + forma.preparo() + ")";
    }

    @Override
    public double getCusto() {
        return 26.00 + forma.getCustoForma();
    }

}
