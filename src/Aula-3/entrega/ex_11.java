import java.util.Scanner;  // Importa a classe Scanner

public class ex_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        String txt1;
        String txt2;
        String txt3;

        // Entrada de dados
        System.out.print("Informe a string 1: ");
        txt1 = scanner.nextLine();
        System.out.print("Informe a string 2: ");
        txt2 = scanner.nextLine();
        System.out.print("Informe a string 3: ");
        txt3 = scanner.nextLine();
        
        // Contatena as 3 strings em uma só
        String concatenada = txt1.concat(txt2).concat(txt3);

        // Separa e junta os respectivos
        String sub1_txt1 = txt1.substring(0, (txt1.length()/2));
        String sub2_txt1 = txt1.substring((txt1.length()/2), txt1.length());
        String sub1_txt2 = txt2.substring(0, (txt2.length()/2));
        String sub2_txt2 = txt2.substring((txt2.length()/2), txt2.length());
        String sub1_txt3 = txt3.substring(0, (txt3.length()/2));
        String sub2_txt3 = txt3.substring((txt3.length()/2), txt3.length());

        // Contatena na ordem pedida
        String resultado = sub1_txt2.concat(sub2_txt3).concat(sub2_txt2).concat(sub1_txt1).concat(sub1_txt3).concat(sub2_txt1);
        
        // Imprime resultado
        System.out.println("A string obtida concatenada: " + concatenada);
        System.out.println("A string obtida embaralhada: " + resultado);
        
        // Fecha o scanner
        scanner.close();
    }
}