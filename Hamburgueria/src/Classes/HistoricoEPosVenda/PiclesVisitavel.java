package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.Hamburguer;
import Classes.MontagemHamburguer.Picles;

public class PiclesVisitavel extends Picles implements Visitavel {
    public PiclesVisitavel(Hamburguer h) { super(h); }
    @Override public void aceitar(Visitor visitor) { visitor.visitar(this); }
}
