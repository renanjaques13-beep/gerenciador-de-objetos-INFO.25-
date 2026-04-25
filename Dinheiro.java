public class Dinheiro extends Pagamento {
    private double valorRecebido;
    private double troco;

    public Dinheiro(double valorCompra, double valorRecebido) {
        super(valorCompra);
        this.valorRecebido = valorRecebido;
        this.troco = calcularTroco();
    }

    @Override
    public void processarPagamento() {
        System.out.printf("Processando pagamento em Dinheiro: R$ %.2f\n", valor);
        System.out.printf("Valor recebido: R$ %.2f\n", valorRecebido);
        
        if (troco >= 0) {
            System.out.printf("Troco: R$ %.2f\n", troco);
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.printf("Valor insuficiente! Faltam R$ %.2f\n", Math.abs(troco));
            System.out.println("Pagamento não processado.");
        }
    }

    private double calcularTroco() {
        return valorRecebido - valor;
    }

    public double getTroco() {
        return troco;
    }
}
