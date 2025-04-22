/*
 * b. Crie a classe Disciplina com seu construtor, métodos de acesso e modificadores e os atributos privados nome, do
 * tipo String, pratica, do tipo boolean. Crie o método getDados() que retorna os valores dos atributos;
 */

public class Disciplina {
    private String nome;
    private boolean pratica;

    // Construtor
    public Disciplina(String nome, boolean pratica) {
        this.nome = nome;
        this.pratica = pratica;
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }

    public boolean isPratica() {
        return pratica;
    }

    // Método para retornar os dados da disciplina
    public String getDados() {
        return "Nome: " + nome + ", Prática: " + pratica;
    }
}
