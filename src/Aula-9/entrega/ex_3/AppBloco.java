import java.util.Scanner;

public class AppBloco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlocoDeNotas bloco = new BlocoDeNotas();
        int opcao;

        do {
            System.out.println("\n---- MENU BLOCO DE NOTAS ----");
            System.out.println("1) Inserir nota");
            System.out.println("2) Remover nota");
            System.out.println("3) Alterar nota");
            System.out.println("4) Listar todas as notas");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a nota: ");
                    String nota = scanner.nextLine();
                    bloco.adicionarNota(nota);
                    System.out.println("Nota adicionada!");
                    break;
                case 2:
                    bloco.listarNotas();
                    System.out.print("Digite o número da nota para remover: ");
                    int indiceRemover = scanner.nextInt() - 1;
                    if (bloco.removerNota(indiceRemover)) {
                        System.out.println("Nota removida!");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;
                case 3:
                    bloco.listarNotas();
                    System.out.print("Digite o número da nota para alterar: ");
                    int indiceAlterar = scanner.nextInt() - 1;
                    scanner.nextLine(); // consumir quebra de linha
                    System.out.print("Digite o novo conteúdo da nota: ");
                    String novaNota = scanner.nextLine();
                    if (bloco.alterarNota(indiceAlterar, novaNota)) {
                        System.out.println("Nota alterada!");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;
                case 4:
                    bloco.listarNotas();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}
