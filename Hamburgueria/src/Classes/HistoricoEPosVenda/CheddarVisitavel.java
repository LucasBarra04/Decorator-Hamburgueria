package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.Cheddar;
import Classes.MontagemHamburguer.Hamburguer;

public class CheddarVisitavel extends Cheddar implements Visitavel {
    public CheddarVisitavel(Hamburguer h) { super(h); }
    @Override public void aceitar(Visitor visitor) { visitor.visitar(this); }
}
