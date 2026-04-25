import java.util.UUID;

public class PIX extends Pagamento {
    private String chavePix;
    private String codigoTransacao;

    public PIX(double valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
        this.codigoTransacao = gerarCodigoTransacao();
    }

    @Override
    public void processarPagamento() {
        System.out.printf("Processando pagamento via PIX: R$ %.2f\n", valor);
        System.out.println("Chave PIX: " + chavePix);
        System.out.println("Código da transação: " + codigoTransacao);
        
        System.out.println("Verificando saldo...");
        System.out.println("Transferência realizada em tempo real!");
        System.out.println(" Pagamento via PIX confirmado!");
    }

    private String gerarCodigoTransacao() {
        return "PIX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }
}
