public class Turma {
    // Atributos privados
    private String nome;
    private String curso;
    private int quantidadeDeAlunos;
    private int serie;

    // Construtor
    public Turma(String nome, String curso, int quantidadeDeAlunos, int serie) {
        this.nome = nome;
        this.curso = curso;
        this.quantidadeDeAlunos = quantidadeDeAlunos;
        this.serie = serie;
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getQuantidadeDeAlunos() {
        return quantidadeDeAlunos;
    }

    public int getSerie() {
        return serie;
    }

    // Métodos modificadores (setters)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
        this.quantidadeDeAlunos = quantidadeDeAlunos;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
}