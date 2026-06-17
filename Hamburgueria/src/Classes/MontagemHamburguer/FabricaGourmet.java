package Classes.MontagemHamburguer;

public class FabricaGourmet implements FabricaAbstrataHamburguer {
    @Override
    public Hamburguer criarHamburguer() {
        Hamburguer h = new BeefBurguer(new bemPassado());
        h = new Cheddar(h);
        return h;
    }
    @Override
    public Acompanhamento criarAcompanhamento() {
        return new AcompanhamentoOnionRings();
    }
}
