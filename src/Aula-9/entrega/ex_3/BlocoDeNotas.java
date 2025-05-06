import java.util.ArrayList;

public class BlocoDeNotas {
    private ArrayList<String> notas;

    public BlocoDeNotas() {
        notas = new ArrayList<>();
    }

    public void adicionarNota(String nota) {
        notas.add(nota);
    }

    public boolean removerNota(int indice) {
        if (indice >= 0 && indice < notas.size()) {
            notas.remove(indice);
            return true;
        } else {
            return false;
        }
    }

    public boolean alterarNota(int indice, String novaNota) {
        if (indice >= 0 && indice < notas.size()) {
            notas.set(indice, novaNota);
            return true;
        } else {
            return false;
        }
    }

    public String buscarNota(int indice) {
        if (indice >= 0 && indice < notas.size()) {
            return notas.get(indice);
        } else {
            return null;
        }
    }

    public void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
        } else {
            for (int i = 0; i < notas.size(); i++) {
                System.out.println((i + 1) + " - " + notas.get(i));
            }
        }
    }
}
