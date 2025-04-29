public class Main {
    public static void main(String[] args) {
        Desempregado d = new Desempregado("Carlos", "Silva", "123.456.789-00", 1200.0);
        System.out.println(d.dados());

        Mensalista m = new Mensalista("Ana", "Pereira", "987.654.321-00", 3500.0);
        System.out.println(m.dados());

        Comissionado c = new Comissionado("Paulo", "Lima", "111.222.333-44", 3000.0, 500.0);
        System.out.println(c.dados());

        Horista h = new Horista("Beatriz", "Costa", "555.666.777-88", 40.0, 160);
        System.out.println(h.dados());

        Tarefeiro t = new Tarefeiro("Roberta", "Oliveira", "999.000.111-22", 20, 50.0);
        System.out.println(t.dados());
    }
}
