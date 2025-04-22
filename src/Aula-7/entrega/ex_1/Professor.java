/*
 * a. Crie a classe Professor com seu construtor, métodos de acesso e modificadores e os atributos privados nome, do 
 * tipo String, idade, do tipo int. Crie o método getDados() que retorna os valores dos atributos;
 */

public class Professor {
    private String nome;
    private int idade;

    // Construtor
    public Professor(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // Método para retornar os dados do professor
    public String getDados() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}