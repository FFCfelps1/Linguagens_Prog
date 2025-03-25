/*
 * Escrever um algoritmo de urna eletrônica, para uma eleição
com 4 candidatos. O usuário vota, digitando o número do
candidato (1,2, 3 ou 4). O número de eleitores é
desconhecido. Quando for digitado o valor -1, o algoritmo
encerra a eleição, escrevendo o percentual de votos de cada
candidato e o total de eleitores que participaram da eleição;
 */

 import java.util.Scanner;

public class ex_24 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int voto;

        int candidato1 = 0;
        int candidato2 = 0;
        int candidato3 = 0;
        int candidato4 = 0;

        int total = 0;

        do {
            System.out.println("Digite o candidato que deseja (1 a 4): ");
            voto = scanner.nextInt();
            if (voto == -1) {
                System.out.println("Eleição encerrada.");
            } else if (voto < 1 || voto > 4) {
                System.out.println("Candidato inválido, digite novamente.");
            }
            else {
                total++;
                switch (voto) {
                    case 1:
                        candidato1++;
                        break;
                    case 2:
                        candidato2++;
                        break;
                    case 3:
                        candidato3++;
                        break;
                    case 4:
                        candidato4++;
                        break;
                }
            }

        } while (voto != -1);

        //Imprime as porcentagens de votos e por fim o ganhador
        System.out.println("Total de eleitores: " + total);
        System.out.println("Candidato 1: " + (candidato1 * 100) / total + "%");
        System.out.println("Candidato 2: " + (candidato2 * 100) / total + "%");
        System.out.println("Candidato 3: " + (candidato3 * 100) / total + "%");
        System.out.println("Candidato 4: " + (candidato4 * 100) / total + "%");
        // Ganha quem tiver mais votos
        if (candidato1 > candidato2 && candidato1 > candidato3 && candidato1 > candidato4) {
            System.out.println("Candidato 1 ganhou!");
        } else if (candidato2 > candidato1 && candidato2 > candidato3 && candidato2 > candidato4) {
            System.out.println("Candidato 2 ganhou!");
        } else if (candidato3 > candidato1 && candidato3 > candidato2 && candidato3 > candidato4) {
            System.out.println("Candidato 3 ganhou!");
        } else if (candidato4 > candidato1 && candidato4 > candidato2 && candidato4 > candidato3) {
            System.out.println("Candidato 4 ganhou!");
        }

    }
}