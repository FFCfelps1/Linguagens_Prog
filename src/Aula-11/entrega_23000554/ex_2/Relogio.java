public class Relogio {
    private Mostrador horas;
    private Mostrador minutos;

    public Relogio() {
        horas = new Mostrador(24);
        minutos = new Mostrador(60);
    }

    public void tictac() {
        minutos.incrementar();
        if (minutos.getValor() == 0) {
            horas.incrementar();
        }
    }

    public void acertaHora(int h) {
        horas.setValor(h);
    }

    public void acertaMinuto(int m) {
        minutos.setValor(m);
    }

    public String mostra() {
        return horas.getValorFormatado() + ":" + minutos.getValorFormatado();
    }
}