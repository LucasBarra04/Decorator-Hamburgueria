package Classes;
import java.util.ArrayList;
import java.util.List;
public class CardapioFly {
    private List<ItemCardapioFly> itens = new ArrayList<>();

    public void addItem(String codigo, int quantidade,
                        String nome, String descricao, double custo) {
        Ingrediente ing = IngredienteFactory.getIngrediente(nome, descricao, custo);
        itens.add(new ItemCardapioFly(codigo, quantidade, ing));
    }

    public List<ItemCardapioFly> getItens()  { return itens; }
    public int getTotalItens()               { return itens.size(); }
    public int getTotalIngredientesUnicos()  { return IngredienteFactory.getTotalIngredientes(); }
}
