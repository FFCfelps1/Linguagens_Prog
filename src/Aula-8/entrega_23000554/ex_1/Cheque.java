public class Cheque extends Pagamento {
    private String numeroDoCheque;

    public Cheque() {
        super();
        this.numeroDoCheque = "";
    }

    public Cheque(String nome, String cpf, double valor, String numeroDoCheque) {
        super(nome, cpf, valor);
        this.numeroDoCheque = numeroDoCheque;
    }

    public String getNumeroDoCheque() {
        return numeroDoCheque;
    }

    public void setNumeroDoCheque(String numeroDoCheque) {
        this.numeroDoCheque = numeroDoCheque;
    }
}
