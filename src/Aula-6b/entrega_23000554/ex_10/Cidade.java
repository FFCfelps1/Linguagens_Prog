public class Cidade {
    private String nome;
    private String estado;
    private int populacao;

    // Construtor
    public Cidade(String nome, String estado, int populacao) {
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao >= 0 ? populacao : 0; // Garante que a população não seja negativa
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public int getPopulacao() {
        return populacao;
    }

    // Métodos modificadores (setters)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPopulacao(int populacao) {
        if (populacao >= 0) {
            this.populacao = populacao;
        } else {
            System.out.println("A população não pode ser negativa.");
        }
    }

    // Método para exibir informações da cidade
    public void exibirInformacoes() {
        System.out.println("Nome da Cidade: " + nome);
        System.out.println("Estado: " + estado);
        System.out.println("População: " + populacao);
    }
}