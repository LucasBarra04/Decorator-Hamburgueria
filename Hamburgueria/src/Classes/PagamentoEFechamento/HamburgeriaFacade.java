package Classes.PagamentoEFechamento;

import Classes.MontagemHamburguer.PedidoCompleto;

public class HamburgeriaFacade {
    public static boolean fecharPedido(PedidoCompleto pedido) {
        if (EstoqueSetor.getInstancia().verificarPedidoComPendencia(pedido)) {
            System.out.println("Pedido bloqueado: ingredientes em falta no Estoque.");
            return false;
        }
        if (PagamentoSetor.getInstancia().verificarPedidoComPendencia(pedido)) {
            System.out.println("Pedido bloqueado: pendência no Pagamento.");
            return false;
        }
        if (CozinhaSetor.getInstancia().verificarPedidoComPendencia(pedido)) {
            System.out.println("Pedido bloqueado: Cozinha sem capacidade no momento.");
            return false;
        }
        System.out.println("Pedido fechado com sucesso! Encaminhado para a cozinha.");
        return true;
    }
}
