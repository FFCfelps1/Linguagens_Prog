/*
 * c. Crie a classe Atribuicao com seu construtor, métodos de acesso e modificadores e os atributos privados professor,
 * do tipo Professor, e disciplina, do tipo Disciplina. Crie o método getDados() que retorna os valores dos atributos;
 */

public class Atribuicao {
    private Professor professor;
    private Disciplina disciplina;

    // Construtor
    public Atribuicao(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    // Métodos de acesso (getters)
    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    // Método para retornar os dados da atribuição
    public String getDados() {
        return "Professor: " + professor.getDados() + ", Disciplina: " + disciplina.getDados();
    }
}