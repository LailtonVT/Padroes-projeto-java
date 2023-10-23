import java.util.Scanner;

class GerenciadorEstrategiasPagamento {
    private static GerenciadorEstrategiasPagamento instancia = new GerenciadorEstrategiasPagamento();
    private EstrategiaPagamento estrategiaAtual;

    private GerenciadorEstrategiasPagamento() {
        // Inicializa a estratégia padrão
        estrategiaAtual = new PagamentoCartaoCredito();
    }

    public static GerenciadorEstrategiasPagamento getInstance() {
        return instancia;
    }

    public void setEstrategiaPagamento(EstrategiaPagamento estrategia) {
        estrategiaAtual = estrategia;
    }

    public void processarPagamento() {
        estrategiaAtual.processarPagamento();
    }
}

// Interface para as estratégias de pagamento
interface EstrategiaPagamento {
    void processarPagamento();
}

// Estratégia de pagamento com cartão de crédito
class PagamentoCartaoCredito implements EstrategiaPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Pagamento com cartão de crédito processado.");
    }
}

// Estratégia de pagamento com PayPal
class PagamentoPayPal implements EstrategiaPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Pagamento com PayPal processado.");
    }
}

// Estratégia de pagamento com transferência bancária
class PagamentoTransferenciaBancaria implements EstrategiaPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Pagamento com transferência bancária processado.");
    }
}

// Facade para simplificar o processo de pagamento
class FacadePagamento {
    public void realizarPagamento(EstrategiaPagamento estrategia) {
        GerenciadorEstrategiasPagamento.getInstance().setEstrategiaPagamento(estrategia);
        GerenciadorEstrategiasPagamento.getInstance().processarPagamento();
    }
}

public class SimuladorPagamento {
    public static void main(String[] args) {
        FacadePagamento facadePagamento = new FacadePagamento();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção de pagamento:");
            System.out.println("1. Cartão de Crédito");
            System.out.println("2. PayPal");
            System.out.println("3. Transferência Bancária");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
                facadePagamento.realizarPagamento(new PagamentoCartaoCredito());
            } else if (escolha == 2) {
                facadePagamento.realizarPagamento(new PagamentoPayPal());
            } else if (escolha == 3) {
                facadePagamento.realizarPagamento(new PagamentoTransferenciaBancaria());
            } else if (escolha == 4) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Obrigado por usar nosso simulador de pagamento!");

        scanner.close();
    }
}
