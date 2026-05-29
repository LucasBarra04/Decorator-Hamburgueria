package Classes;
public class CozinhaSetor extends SetorHamburgueria {
    private static CozinhaSetor instance;
    private CozinhaSetor() {}
    public static CozinhaSetor getInstancia() {
        if (instance == null) instance = new CozinhaSetor();
        return instance;
    }
}
