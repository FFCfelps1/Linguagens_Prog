public class Empregado extends PessoaFisica {
    public Empregado() {
        super();
    }

    public Empregado(String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
    }

    @Override
    public String dados() {
        return super.dados();
    }
}
