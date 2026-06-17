package Classes.HistoricoEPosVenda;

import Classes.MontagemHamburguer.BeefBurguer;
import Classes.MontagemHamburguer.Cheddar;
import Classes.MontagemHamburguer.Picles;
import Classes.MontagemHamburguer.chickenBurguer;

public class RelatorioVisitor implements Visitor {
    private double totalCalculado = 0;
    private StringBuilder relatorio = new StringBuilder();

    @Override public void visitar(BeefBurguer h)   { totalCalculado += h.getCusto(); relatorio.append("BeefBurguer: R$").append(h.getCusto()).append("\n"); }
    @Override public void visitar(chickenBurguer h) { totalCalculado += h.getCusto(); relatorio.append("ChickenBurguer: R$").append(h.getCusto()).append("\n"); }
    @Override public void visitar(Cheddar c)        { totalCalculado += c.getCusto(); relatorio.append("Cheddar: R$").append(c.getCusto()).append("\n"); }
    @Override public void visitar(Picles p)         { totalCalculado += p.getCusto(); relatorio.append("Picles: R$").append(p.getCusto()).append("\n"); }

    public double getTotalCalculado() { return totalCalculado; }
    public String getRelatorio()      { return relatorio.toString(); }
}
