# Projeto Hamburgueria — Padrões de Projeto

## Padrões implementados

| Padrão | Tipo | Utilidade |
|---|---|---|
| Singleton | Criacional | `GerenciaPedidos` mantém um único registro central de pedidos e receita |
| Factory Method | Criacional | `fabricaHamburguerGourmet` decide qual hambúrguer criar sem expor a classe concreta |
| Abstract Factory | Criacional | `FabricaClassica` e `FabricaGourmet` criam hambúrguer + acompanhamento combinados |
| Builder | Criacional | `PedidoBuilder` monta o `PedidoCompleto` passo a passo |
| Prototype | Criacional | `PedidoCompleto` clona um pedido anterior para repetição rápida |
| Bridge | Estrutural | Separa o tipo de hambúrguer (Beef, Chicken) do ponto de cozimento (mal passado, no ponto, bem passado) |
| Decorator | Estrutural | `Cheddar` e `Picles` adicionam ingredientes ao hambúrguer em tempo de execução |
| Composite | Estrutural | `Combo` agrupa itens do cardápio, simples ou compostos, de forma uniforme |
| Façade | Estrutural | `HamburgeriaFacade.fecharPedido()` coordena Estoque, Pagamento e Cozinha em uma chamada |
| Flyweight | Estrutural | `IngredienteFactory` compartilha objetos de ingredientes repetidos entre os pedidos |
| Proxy | Estrutural | `DadosPedidoProxy` carrega dados sensíveis do pedido só quando acessados, e controla quem pode vê-los |
| Adapter | Estrutural | `PagamentoLegadoAdapter` traduz um sistema de pagamento legado para a interface `IGatewayPagamento` usada pelo sistema |
| Strategy | Comportamental | `CalculadoraEntrega` troca o algoritmo de frete (expressa, econômica, retirada) sem alterar o código cliente |
| Observer | Comportamental | `Pedido` notifica `ClienteObserver` e `CozinhaObserver` a cada mudança de status |
| State | Comportamental | `EstadoPedido` controla o ciclo de vida do pedido (pendente → aprovado → preparo → transporte → entregue/cancelado) |
| Chain of Responsibility | Comportamental | `FuncionarioChain` encaminha pedidos especiais pela hierarquia até alguém com autoridade para aprovar |
| Template Method | Comportamental | `TipoAtendimento` define o cálculo do valor final; subclasses só informam a taxa (retirada = 0, delivery = R$6,50) |
| Mediator | Comportamental | `SAC` centraliza a comunicação entre cliente, cozinha e entregador |
| Memento | Comportamental | `HistoricoCliente` salva e restaura estados anteriores de pedidos |
| Visitor | Comportamental | `RelatorioVisitor` e `DescontoVisitor` aplicam operações sobre os itens sem alterar suas classes |
| Iterator | Comportamental | `HistoricoCliente` permite percorrer o histórico de pedidos com `for-each` nativo |
| Command | Comportamental | `FilaCozinha` encapsula ações da cozinha (adicionar, remover, priorizar pedido) com suporte a desfazer |
| Interpreter | Comportamental | `AplicadorPromocao` calcula promoções a partir de expressões matemáticas montadas dinamicamente |
