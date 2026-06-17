package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.BeefBurguer;
import Classes.MontagemHamburguer.Cheddar;
import Classes.MontagemHamburguer.Picles;
import Classes.MontagemHamburguer.chickenBurguer;

public interface Visitor {
    void visitar(BeefBurguer hamburguer);
    void visitar(chickenBurguer hamburguer);
    void visitar(Cheddar cheddar);
    void visitar(Picles picles);
}
