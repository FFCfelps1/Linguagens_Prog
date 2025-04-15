public class Celular {
    private String marca;
    private String modelo;
    private int capacidadeArmazenamento; // em GB

    // Construtor
    public Celular(String marca, String modelo, int capacidadeArmazenamento) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadeArmazenamento = capacidadeArmazenamento;
    }

    // Métodos de acesso (getters)
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadeArmazenamento() {
        return capacidadeArmazenamento;
    }

    // Métodos modificadores (setters)
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidadeArmazenamento(int capacidadeArmazenamento) {
        if (capacidadeArmazenamento > 0) {
            this.capacidadeArmazenamento = capacidadeArmazenamento;
        } else {
            System.out.println("A capacidade de armazenamento deve ser positiva.");
        }
    }

    // Método para exibir informações do celular
    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidade de Armazenamento: " + capacidadeArmazenamento + " GB");
    }
}