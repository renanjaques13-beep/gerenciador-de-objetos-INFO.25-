public abstract class Pagamento {
    protected double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    
    public abstract void processarPagamento();

    
    public void imprimirRecibo() {
        System.out.printf("Recibo: Pagamento de R$ %.2f realizado com sucesso.\n", valor);
        System.out.println("----------------------------------------");
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
