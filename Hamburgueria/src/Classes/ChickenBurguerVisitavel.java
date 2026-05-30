package Classes;
public class ChickenBurguerVisitavel extends chickenBurguer implements Visitavel {
    public ChickenBurguerVisitavel(formaCozinhar forma) { super(forma); }
    @Override public void aceitar(Visitor visitor) { visitor.visitar(this); }
}
