package Classes;
public class CheddarVisitavel extends Cheddar implements Visitavel {
    public CheddarVisitavel(Hamburguer h) { super(h); }
    @Override public void aceitar(Visitor visitor) { visitor.visitar(this); }
}
