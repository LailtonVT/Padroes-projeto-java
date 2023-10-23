# Simulador de Pagamento em Java

Este é um exemplo de projeto Java que demonstra o uso dos padrões de projeto Singleton, Strategy e Facade. O projeto é um simulador de pagamento que permite ao usuário escolher entre diferentes estratégias de pagamento, como cartão de crédito, PayPal e transferência bancária, e faz uso do padrão Facade para simplificar a interação com essas estratégias.

## Padrões de Projeto Utilizados

### Singleton

O padrão Singleton é usado para criar uma única instância do `GerenciadorEstrategiasPagamento`, que gerencia as estratégias de pagamento. Isso garante que haja uma única fonte de verdade para as estratégias de pagamento em todo o aplicativo.

### Strategy

O padrão Strategy é implementado com as classes `PagamentoCartaoCredito`, `PagamentoPayPal` e `PagamentoTransferenciaBancaria`, que representam diferentes estratégias de pagamento. Cada uma dessas classes implementa a interface `EstrategiaPagamento` e fornece sua própria implementação do método `processarPagamento`.

### Facade

O padrão Facade é utilizado na classe `FacadePagamento`. Ele simplifica o processo de pagamento, permitindo que o usuário selecione a estratégia desejada e, em seguida, usando o `GerenciadorEstrategiasPagamento`, a estratégia é definida e o pagamento é processado sem que o usuário precise conhecer os detalhes internos.



