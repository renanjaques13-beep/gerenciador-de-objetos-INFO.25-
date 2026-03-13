import java.util.Scanner;

public class mainv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("SISTEMA BANCARIO ORIENTACAO A OBJETOS");
        System.out.println("");
        System.out.println("\nCADASTRO DA CONTA");
        
        int agencia = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite a agencia (apenas numeros seu burro!!!): ");
            String input = scanner.nextLine().trim();  
            
            if (input.matches("\\d+")) { 
                agencia = Integer.parseInt(input);
                
                entradaValida = true;
            } else {
                System.out.println("Erro: Digite apenas numeros para a agencia");
            }
        }  
        int numero = 0;
        entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite o numero da conta (apenas numeros): ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                numero = Integer.parseInt(input);
                entradaValida = true;
            } else {
                System.out.println("Erro: Digite apenas numeros para o numero da conta");
            }
        }
        
        System.out.print("Digite o nome do cliente: ");
        String cliente = scanner.nextLine().trim();
        while (cliente.isEmpty()) {
            System.out.print("Nome nao pode estar sem coisa letra ne Digite novamente: ");
            cliente = scanner.nextLine().trim();
        }
        
    
        double saldoInicial = 0;
        entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite o saldo inicial: R$ ");
            String input = scanner.nextLine().trim().replace(",", ".");
            
            if (input.matches("\\d+(\\.\\d{1,2})?")) {
                saldoInicial = Double.parseDouble(input);
                entradaValida = true;
            } else {
                System.out.println("Erro: Digite apenas numeros para o saldo e positivo (use ponto ou vírgula para decimais tbm fuciona em)");
            }
        }
        ContaBancaria conta = new ContaBancaria(agencia, numero, cliente, saldoInicial);
        System.out.println("\nConta cadastrada com sucesso");
        System.out.println(conta.toString());
        
    
        int opcao;
        do {
            System.out.println("\nMENU DE OPERACOES");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar (valor informado)");
            System.out.println("4 - Sacar (valor padrão R$ 49,90)");
            System.out.println("5 - Sacar com antecipação");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
          
            opcao = 0;
            entradaValida = false;
            while (!entradaValida) {
                String inputOpcao = scanner.nextLine().trim();
                if (inputOpcao.matches("\\d+")) {
                    opcao = Integer.parseInt(inputOpcao);
                    if (opcao >= 0 && opcao <= 5) {
                        entradaValida = true;
                    } else {
                        System.out.print("Opcao invalida! Digite um numero entre 0 e 5 ");
                    }
                } else {
                    System.out.print("Erro: Digite apenas numeroes Escolha uma opcao: ");
                }
            }
            
            switch(opcao) {
                case 1:
                    System.out.println("\nSaldo atual: R$ " + String.format("%.2f", conta.verSaldo()));
                    break;
                    
                case 2:
                   
                    double valorDeposito = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Digite o valor para deposito (minimo R$ 5,00) R$ ");
                        String input = scanner.nextLine().trim().replace(",", ".");
                        
                        if (input.matches("\\d+(\\.\\d{1,2})?")) {
                            valorDeposito = Double.parseDouble(input);
                            if (valorDeposito >= 5) {
                                entradaValida = true;
                            } else {
                                System.out.println("Erro: O deposito minimo e de R$ 5,00!");
                            }
                        } else {
                            System.out.println("Erro: Digite apenas numeros para o valor!");
                        }
                    }
                    conta.depositar(valorDeposito);
                    break;
                    
                case 3:
                
                    double valorSaque = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Digite o valor para saque: R$ ");
                        String input = scanner.nextLine().trim().replace(",", ".");
                        
                        if (input.matches("\\d+(\\.\\d{1,2})?")) {
                            valorSaque = Double.parseDouble(input);
                            if (valorSaque > 0) {
                                entradaValida = true;
                            } else {
                                System.out.println("Erro: O valor do saque deve ser maior que zero");
                            }
                        } else {
                            System.out.println("Erro: Digite apenas numeroes para o valor");
                        }
                    }
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    conta.sacar(); 
                    break;
                    
                case 5:
        
                    double valorSaqueAntecipado = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Digite o valor para saque: R$ ");
                        String input = scanner.nextLine().trim().replace(",", ".");
                        
                        if (input.matches("\\d+(\\.\\d{1,2})?")) {
                            valorSaqueAntecipado = Double.parseDouble(input);
                            if (valorSaqueAntecipado > 0) {
                                entradaValida = true;
                            } else {
                                System.out.println("Erro: O valor do saque deve ser maior que zero");
                            }
                        } else {
                            System.out.println("Erro: Digite apenas numeros para o valor");
                        }
                    }
                    
                  
                    int dias = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Digite os dias de antecipacao");
                        String input = scanner.nextLine().trim();
                        
                        if (input.matches("\\d+")) {
                            dias = Integer.parseInt(input);
                            if (dias >= 0) {
                                entradaValida = true;
                            } else {
                                System.out.println("Erro: Os dias devem ser um nimero positivo");
                            }
                        } else {
                            System.out.println("Erro: Digite apenas numeros para os dias");
                        }
                    }
                    
                    conta.sacar(valorSaqueAntecipado, dias);
                    break;
                    
                case 0:
                    System.out.println("\nObrigado por utilizar nosso sistema bancario");
                    System.out.println(conta.toString());
                    break;
            }
            
        } while(opcao != 0);
        
        scanner.close();
    }
}
