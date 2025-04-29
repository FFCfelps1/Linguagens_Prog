// Teste.java
public class Teste {
    public static void main(String[] args) {
        Circulo c = new Circulo(5, 0, 0);
        System.out.println(c); // Deve exibir informações do círculo
        System.out.println("Área: " + c.area());
        System.out.println("Perímetro: " + c.perimetro());

        Cilindro cil = new Cilindro(10, 5, 0, 0);
        System.out.println(cil); // Deve exibir informações do cilindro
        System.out.println("Volume: " + cil.volume());
        System.out.println("Área da superfície externa: " + cil.areaDaSuperficieExterna());
    }
}