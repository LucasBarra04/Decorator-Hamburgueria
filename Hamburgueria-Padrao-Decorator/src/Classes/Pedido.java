package Classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Observable {

    private EstadoPedido estado;
    private Hamburguer hamburguer;
    private List<Observer> observers = new ArrayList<>();

    public Pedido(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
        this.estado = EstadoPedidoPagamentoPendente.getInstance();
    }

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String evento, String descricao) {
        for (Observer o : observers) {
            o.update(evento, descricao);
        }
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        notificarObservers("Estado alterado", estado.getEstado());
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public Hamburguer getHamburguer() {
        return hamburguer;
    }

    public void pagamentoPendente() { estado.pagamentoPendente(this); }
    public void aprovar()           { estado.aprovar(this); }
    public void preparar()          { estado.preparar(this); }
    public void transportar()       { estado.transportar(this); }
    public void entregar()          { estado.entregar(this); }
    public void cancelar()          { estado.cancelar(this); }
}
