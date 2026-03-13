public class ContaBancaria {

    private int numero;
    private int agencia;
    private double saldo;
    private String cliente;
    private int contadorDepositos;

    public ContaBancaria(int agencia, int numero, String cliente, double saldo) {
        setAgencia(agencia);
        setNumero(numero);
        setCliente(cliente);
        setSaldo(saldo);
        this.contadorDepositos = 0;
    }
    public ContaBancaria(int agencia, int numero) {
        setAgencia(agencia);
        setNumero(numero);
        this.saldo = 0;
        this.cliente = "Nao informado";
        this.contadorDepositos = 0;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("Numero da conta deve ser positivo");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        if (agencia > 0) {
            this.agencia = agencia;
        } else {
            throw new IllegalArgumentException("Agencia deve ser positiva");
        }
    }    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String novoNome) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            this.cliente = novoNome;
        } else {
            this.cliente = "Nao informadouuuu";
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0;
        }
    }

    public int getContadorDepositos() {
        return contadorDepositos;
    }

    public double verSaldo() {
        return saldo;
    }

    public void sacar() {
        double valorSaque = 49.90;
        if (saldo >= valorSaque) {
            saldo = saldo - valorSaque;
            System.out.println("Saque padrao de R$ 49,90 realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para saque padrao de R$ 49,90!");
        }
    }
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque invalido!");
        } else if (saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para saque de R$ " + String.format("%.2f", valor) + "!");
        }
    }

    public void sacar(double valor, int diasAntecipacao) {
        if (valor <= 0) {
            System.out.println("Valor de saque invalidoes");
            return;
        }
        
        if (diasAntecipacao < 0) {
            System.out.println("Dias de antecipacao invalidoes");
            return;
        }
        
        double taxa = valor * 0.10 * diasAntecipacao;
        double valorTotal = valor + taxa;
        
        if (saldo >= valorTotal) {
            saldo = saldo - valorTotal;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + 
                             " com antecipacao de " + diasAntecipacao + " dia(s) realizado!");
            System.out.println("Taxa aplicada: R$ " + String.format("%.2f", taxa));
        } else {
            System.out.println("Saldo insuficiente para saque com antecipaccao");
            System.out.println("Valor total com taxas: R$ " + String.format("%.2f", valorTotal));
            System.out.println("Saldo disponível: R$ " + String.format("%.2f", saldo));
        }
    }

    public void depositar(double valor) {
        if (valor < 5.00) {
            System.out.println("Deposito minimo he de R$ 5,00");
            return;
        }
        
        contadorDepositos++;
        
        if (contadorDepositos > 5) {
            double valorComTaxa = valor - 2.99;
            if (valorComTaxa >= 5.00) {
                saldo = saldo + valorComTaxa;
                System.out.println("Deposito de R$ " + String.format("%.2f", valor) + 
                                 " realizado com taxa de R$ 2,99!");
                System.out.println("Valor creditado: R$ " + String.format("%.2f", valorComTaxa));
            } else {
                System.out.println("Apos taxa de R$ 2,99, o valor minimo de deposito nao e atingido!");
                contadorDepositos--;
            }
        } else {
            saldo = saldo + valor;
            System.out.println("Deposito de R$ " + String.format("%.2f", valor) + " realizado com sucesso");
        }
    }

    
    public String toString() {
        return "\nDADOS DA CONTA" +
                "\nAgencia: " + agencia +
                "\nNumero: " + numero +
                "\nCliente: " + cliente +
                "\nSaldo: R$ " + String.format("%.2f", saldo) +
                "\nDepositos realizados: " + contadorDepositos +
                "\n";
    }
}
