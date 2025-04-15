public class Animal {
    private String especie;
    private String nome;
    private int idade;

    // Construtor
    public Animal(String especie, String nome, int idade) {
        this.especie = especie;
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos de acesso (getters)
    public String getEspecie() {
        return especie;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // Métodos modificadores (setters)
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        } else {
            System.out.println("A idade não pode ser negativa.");
        }
    }

    // Método para exibir informações do animal
    public void exibirInformacoes() {
        System.out.println("Espécie: " + especie);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
    }
}