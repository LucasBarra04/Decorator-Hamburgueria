package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.*;

public class DescontoVisitor implements Visitor {
    private double totalDesconto = 0;
    private double percentual;

    public DescontoVisitor(double percentual) { this.percentual = percentual; }

    private void aplicar(Hamburguer h) { totalDesconto += h.getCusto() * percentual / 100; }

    @Override public void visitar(BeefBurguer h)   { aplicar(h); }
    @Override public void visitar(chickenBurguer h) { aplicar(h); }
    @Override public void visitar(Cheddar c)        { aplicar(c); }
    @Override public void visitar(Picles p)         { aplicar(p); }

    public double getTotalDesconto() { return totalDesconto; }
}
