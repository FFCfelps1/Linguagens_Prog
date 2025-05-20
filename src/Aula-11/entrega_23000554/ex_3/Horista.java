public class Horista extends Empregado {
    private double horas;
    private double valorHora;

    public Horista(String nome, double horas, double valorHora) {
        super(nome);
        this.horas = horas;
        this.valorHora = valorHora;
    }

    public double calcularSalario() {
        return horas * valorHora;
    }
}