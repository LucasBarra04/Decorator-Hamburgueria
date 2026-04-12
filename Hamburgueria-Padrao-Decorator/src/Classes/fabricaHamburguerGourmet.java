package Classes;

public class fabricaHamburguerGourmet extends fabricaHamburguer{

    @Override
    public Hambuguer criarHamburguer(String tipo, formaCozinhar forma) {
        if (tipo.equalsIgnoreCase("Beef")) {
            return new BeefBurguer(forma);
        }
        else if (tipo.equalsIgnoreCase("Chicken")) {
            return new chickenBurguer(forma);
        }
        throw new IllegalArgumentException("Tipo de Humbúrger não disponível.");
    }
}

