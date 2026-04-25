import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoBancario extends Pagamento {
    private String codigoBarras;
    private LocalDate dataVencimento;

    public BoletoBancario(double valor, String codigoBarras, LocalDate dataVencimento) {
        super(valor);
        this.codigoBarras = codigoBarras;
        this.dataVencimento = dataVencimento;
    }

    @Override
    public void processarPagamento() {
        System.out.printf("Processando pagamento com Boleto Bancário: R$ %.2f\n", valor);
        System.out.println("Código de barras: " + codigoBarras);
        System.out.println("Vencimento: " + dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        if (verificarVencimento()) {
            System.out.println("Boleto dentro do prazo. Processando...");
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Atenção: Boleto vencido! Pagamento sujeito a multa.");
            System.out.println("Processando com acréscimo de 2%...");
            double valorComMulta = valor * 1.02;
            System.out.printf("Valor total com multa: R$ %.2f\n", valorComMulta);
        }
    }

    private boolean verificarVencimento() {
        return !LocalDate.now().isAfter(dataVencimento);
    }
}
