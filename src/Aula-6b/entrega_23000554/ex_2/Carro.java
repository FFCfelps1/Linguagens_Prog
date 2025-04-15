public class Carro {
    private String marca;
    private String modelo;
    private int anoDeFabricacao;

    // Construtor
    public Carro(String marca, String modelo, int anoDeFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
    }

    // Métodos de acesso (getters)
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    // Métodos modificadores (setters)
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }
}