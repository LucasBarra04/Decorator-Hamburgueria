package Classes.HistoricoEPosVenda;
import java.util.HashMap;
import java.util.Map;
public class IngredienteFactory {
    private static Map<String, Ingrediente> ingredientes = new HashMap<>();

    public static Ingrediente getIngrediente(String nome, String descricao, double custo) {
        if (!ingredientes.containsKey(nome)) {
            ingredientes.put(nome, new Ingrediente(nome, descricao, custo));

        }
        return ingredientes.get(nome);
    }

    public static int getTotalIngredientes() { return ingredientes.size(); }
}
