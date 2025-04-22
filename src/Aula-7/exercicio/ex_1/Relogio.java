public class Relogio {
    public Mostrador hora;
    public Mostrador minuto;
    public Mostrador segundos;
    public String mostrador;

    public Relogio() {
        hora = new Mostrador(24);
        minuto = new Mostrador(60);
        segundos = new Mostrador(60);
        atualizaMostrador();
    }

    public void ticTac(int tictac) {
        // Incrementa somente quando o usuário escreve tictac
        if (tictac == 1) {
            segundos.incrementa();
            if (segundos.getValor() == 0) {
                minuto.incrementa();
            }
            if (minuto.getValor() == 0 && segundos.getValor() == 0) {
                hora.incrementa();
            }
        }

        atualizaMostrador();
    }

    private void atualizaMostrador() {
        mostrador = hora.mostra() + ":" + minuto.mostra() + ":" + segundos.mostra();
    }

    public String mostra() {
        return mostrador;
    }
}