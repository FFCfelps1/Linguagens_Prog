public class PessoaFisica {
    protected String nome;
    protected String cpf;

    public PessoaFisica(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf;
    }
}