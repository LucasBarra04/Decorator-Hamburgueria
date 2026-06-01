package Classes;
public class Ingrediente {
    private String nome;
    private String descricao;
    private double custo;

    public Ingrediente(String nome, String descricao, double custo) {
        this.nome     = nome;
        this.descricao = descricao;
        this.custo    = custo;
    }

    public String getNome()      { return nome; }
    public String getDescricao() { return descricao; }
    public double getCusto()     { return custo; }
}
