import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPagamentoTeste {
    private static List<Pagamento> historicoPagamentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    realizarPagamento();
                    break;
                case 2:
                    exibirHistorico();
                    break;
                case 3:
                    System.out.println("Encerrando o sistema...");
                    System.out.println("Obrigado pela preferência!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            System.out.println();
        } while (opcao != 3);
        
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=".repeat(50));
        System.out.println(" SISTEMA DE PAGAMENTO DA LOJA ONLINE");
        System.out.println("=".repeat(50));
        System.out.println("1 Realizar pagamento");
        System.out.println("2  Ver histórico de pagamentos");
        System.out.println("3  Sair");
        System.out.println("=".repeat(50));
    }

    private static void realizarPagamento() {
        System.out.println("\n📋 FORMAS DE PAGAMENTO DISPONÍVEIS:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Boleto Bancário");
        System.out.println("3 - Dinheiro");
        System.out.println("4 - PIX");
        
        int tipoPagamento = lerInteiro("\nEscolha a forma de pagamento: ");
        double valor = lerDouble("Digite o valor da compra: R$ ");
        
        Pagamento pagamento = null;
        
        switch (tipoPagamento) {
            case 1:
                pagamento = criarPagamentoCartao(valor);
                break;
            case 2:
                pagamento = criarPagamentoBoleto(valor);
                break;
            case 3:
                pagamento = criarPagamentoDinheiro(valor);
                break;
            case 4:
                pagamento = criarPagamentoPIX(valor);
                break;
            default:
                System.out.println("Forma de pagamento inválida!");
                return;
        }
        
        if (pagamento != null) {
            System.out.println("\n PROCESSANDO PAGAMENTO...");
            System.out.println("-".repeat(40));
            pagamento.processarPagamento();
            pagamento.imprimirRecibo();
            
           
            historicoPagamentos.add(pagamento);
            System.out.println("\n Pagamento registrado com sucesso!");
        }
    }

    private static Pagamento criarPagamentoCartao(double valor) {
        scanner.nextLine(); 
        System.out.print("Número do cartão: ");
        String numeroCartao = scanner.nextLine();
        System.out.print("Bandeira do cartão (Visa/Mastercard/Elo): ");
        String bandeira = scanner.nextLine();
        
        return new CartaoDeCredito(valor, numeroCartao, bandeira);
    }

    private static Pagamento criarPagamentoBoleto(double valor) {
        scanner.nextLine(); 
        System.out.print("Código de barras do boleto: ");
        String codigoBarras = scanner.nextLine();
        
        System.out.print("Dia do vencimento: ");
        int dia = lerInteiro("");
        System.out.print("Mês do vencimento: ");
        int mes = lerInteiro("");
        System.out.print("Ano do vencimento: ");
        int ano = lerInteiro("");
        
        LocalDate dataVencimento = LocalDate.of(ano, mes, dia);
        
        return new BoletoBancario(valor, codigoBarras, dataVencimento);
    }

    private static Pagamento criarPagamentoDinheiro(double valor) {
        double valorRecebido = lerDouble("Valor recebido em dinheiro: R$ ");
        return new Dinheiro(valor, valorRecebido);
    }

    private static Pagamento criarPagamentoPIX(double valor) {
        scanner.nextLine(); 
        System.out.print("Chave PIX (CPF/Email/Telefone): ");
        String chavePix = scanner.nextLine();
        
        return new PIX(valor, chavePix);
    }

    private static void exibirHistorico() {
        if (historicoPagamentos.isEmpty()) {
            System.out.println("\n Nenhum pagamento realizado ainda.");
            return;
        }
        
        System.out.println("\n HISTÓRICO DE PAGAMENTOS");
        System.out.println("=".repeat(50));
        
        int contador = 1;
        for (Pagamento p : historicoPagamentos) {
            System.out.printf("%d️ Pagamento no valor de R$ %.2f\n", contador, p.getValor());
            contador++;
        }
        
        System.out.println("=".repeat(50));
        System.out.printf("TOTAL DE PAGAMENTOS: R$ %.2f\n", calcularTotalPagamentos());
        System.out.printf(" QUANTIDADE DE PAGAMENTOS: %d\n", historicoPagamentos.size());
    }

    private static double calcularTotalPagamentos() {
        double total = 0;
        for (Pagamento p : historicoPagamentos) {
            total += p.getValor();
        }
        return total;
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido! Digite um número: ");
            scanner.next();
        }
        int numero = scanner.nextInt();
        return numero;
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor inválido! Digite um número: ");
            scanner.next();
        }
        double numero = scanner.nextDouble();
        return numero;
    }
}
