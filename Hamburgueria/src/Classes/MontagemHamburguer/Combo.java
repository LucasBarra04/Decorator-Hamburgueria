package Classes.MontagemHamburguer;

import java.util.ArrayList;
import java.util.List;

public class Combo extends ItemCardapio {
    private List<ItemCardapio> itens = new ArrayList<>();

    public void addItem(ItemCardapio item) {
        itens.add(item);
    }

    public List<ItemCardapio> getItens() { return itens; }

    @Override
    public String getConteudo() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Combo: ").append(getDescricao()).append("]\n");
        for (ItemCardapio item : itens) {
            sb.append(item.getConteudo()).append("\n");
        }
        return sb.toString();
    }
}
