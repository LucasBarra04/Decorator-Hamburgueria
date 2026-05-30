package Classes;
public interface Visitor {
    void visitar(BeefBurguer hamburguer);
    void visitar(chickenBurguer hamburguer);
    void visitar(Cheddar cheddar);
    void visitar(Picles picles);
}
