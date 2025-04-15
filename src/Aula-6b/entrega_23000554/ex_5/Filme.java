public class Filme {
    private String nome;
    private String diretor;
    private int anoDeLancamento;

    // Construtor
    public Filme(String nome, String diretor, int anoDeLancamento) {
        this.nome = nome;
        this.diretor = diretor;
        this.anoDeLancamento = anoDeLancamento;
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    // Métodos modificadores (setters)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    // Método para exibir informações do filme
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Diretor: " + diretor);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }
}