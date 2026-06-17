package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.BeefBurguer;
import Classes.MontagemHamburguer.formaCozinhar;

public class BeefBurguerVisitavel extends BeefBurguer implements Visitavel {
    public BeefBurguerVisitavel(formaCozinhar forma) { super(forma); }
    @Override public void aceitar(Visitor visitor) { visitor.visitar(this); }
}
