package Classes.PagamentoEFechamento;

import Classes.MontagemHamburguer.PedidoCompleto;

public class HamburgeriaFacade {
    public static boolean fecharPedido(PedidoCompleto pedido) {
        if (EstoqueSetor.getInstancia().verificarPedidoComPendencia(pedido)) {

            return false;
        }
        if (PagamentoSetor.getInstancia().verificarPedidoComPendencia(pedido)) {

            return false;
        }
        if (CozinhaSetor.getInstancia().verificarPedidoComPendencia(pedido)) {

            return false;
        }

        return true;
    }
}
