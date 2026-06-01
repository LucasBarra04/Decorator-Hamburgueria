package Classes;
public class ItemCardapioFly {
    private String codigoItem;
    private int quantidade;
    private Ingrediente ingrediente;

    public ItemCardapioFly(String codigoItem, int quantidade, Ingrediente ingrediente) {
        this.codigoItem  = codigoItem;
        this.quantidade  = quantidade;
        this.ingrediente = ingrediente;
    }

    public String getCodigoItem()      { return codigoItem; }
    public int getQuantidade()         { return quantidade; }
    public Ingrediente getIngrediente() { return ingrediente; }
    public double getCustoTotal()      { return ingrediente.getCusto() * quantidade; }
}
