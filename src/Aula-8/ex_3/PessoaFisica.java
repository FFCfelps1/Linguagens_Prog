public class PessoaFisica {
    private String nome;
    private String sobrenome;
    private String cpf;

    public PessoaFisica() {
        this.nome = "Nome";
        this.sobrenome = "Sobrenome";
        this.cpf = "000.000.000-00";
    }

    public PessoaFisica(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String dados() {
        return "Nome: " + nome + " " + sobrenome + ", CPF: " + cpf;
    }
}
