package Classes.MontagemHamburguer;

public class FabricaClassica implements FabricaAbstrataHamburguer {
    @Override
    public Hamburguer criarHamburguer() {
        return new BeefBurguer(new malPassado());
    }
    @Override
    public Acompanhamento criarAcompanhamento() {
        return new AcompanhamentoBatataFrita();
    }
}
