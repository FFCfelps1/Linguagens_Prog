public class CartaoDeCredito extends Pagamento {
    private String numeroDoCartao;

    public CartaoDeCredito() {
        super();
        this.numeroDoCartao = "";
    }

    public CartaoDeCredito(String nome, String cpf, double valor, String numeroDoCartao) {
        super(nome, cpf, valor);
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }
}
