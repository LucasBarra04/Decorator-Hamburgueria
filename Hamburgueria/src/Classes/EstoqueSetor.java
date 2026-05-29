package Classes;
public class EstoqueSetor extends SetorHamburgueria {
    private static EstoqueSetor instance;
    private EstoqueSetor() {}
    public static EstoqueSetor getInstancia() {
        if (instance == null) instance = new EstoqueSetor();
        return instance;
    }
}
