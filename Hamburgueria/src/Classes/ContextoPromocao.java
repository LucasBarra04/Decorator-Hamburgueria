package Classes;
import java.util.HashMap;
import java.util.Map;

public class ContextoPromocao {
    private Map<String, Double> variaveis = new HashMap<>();

    public void definir(String variavel, double valor) { variaveis.put(variavel, valor); }

    public double obter(String variavel) {
        if (!variaveis.containsKey(variavel))
            throw new IllegalArgumentException("Variável não definida: " + variavel);
        return variaveis.get(variavel);
    }
}
