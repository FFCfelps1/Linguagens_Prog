public class Desempregado extends PessoaFisica {
    public Desempregado(String nome, String cpf) {
        super(nome, cpf);
    }

    public String toString() {
        return super.toString() + "\nSituação: Desempregado\nRenda: 0.00";
    }
}