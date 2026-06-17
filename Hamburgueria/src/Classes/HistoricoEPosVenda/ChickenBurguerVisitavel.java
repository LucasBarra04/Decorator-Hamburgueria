package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.chickenBurguer;
import Classes.MontagemHamburguer.formaCozinhar;

public class ChickenBurguerVisitavel extends chickenBurguer implements Visitavel {
    public ChickenBurguerVisitavel(formaCozinhar forma) { super(forma); }
    @Override public void aceitar(Visitor visitor) { visitor.visitar(this); }
}
