public class CartaoDeCredito extends Pagamento {
    private String numeroCartao;
    private String bandeira;

    public CartaoDeCredito(double valor, String numeroCartao, String bandeira) {
        super(valor);
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
    }

    @Override
    public void processarPagamento() {
        System.out.printf("Processando pagamento com Cartão de Crédito (%s): R$ %.2f\n", bandeira, valor);

        if (validarCartao()) {
            System.out.println("Cartão validado com sucesso!");
            System.out.println("Autorizando transação...");
            System.out.println("Pagamento aprovado!");
        } else {
            System.out.println("Erro: Cartão inválido!");
        }
    }

    private boolean validarCartao() {
        
        return numeroCartao != null && numeroCartao.length() >= 16;
    }
}
