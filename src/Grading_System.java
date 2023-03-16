import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grading_System {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();
        List<String> series = new ArrayList<>();
        List<Double> notas = new ArrayList<>();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("0 - Encerrar o programa");
            System.out.println("1 - Visualizar a relação de alunos");
            System.out.println("2 - Cadastrar um novo aluno");
            System.out.print("\nOpção escolhida: ");
            String opcaoStr = scanner.nextLine();

            try {
                int opcao = Integer.parseInt(opcaoStr);

                switch (opcao) {
                    case 1 -> {
                        System.out.println("\nDados dos alunos:");
                        for (int i = 0; i < nomes.size(); i++) {
                            String status = notas.get(i) >= 6.0 ? "Aprovado" : "Reprovado";
                            System.out.println("Nome: " + nomes.get(i) + " | Série: " + series.get(i) + " | Nota: " + notas.get(i) + " | Status: " + status);
                        }
                    }
                    case 2 -> {
                        System.out.print("Digite o nome do aluno: ");
                        String nome = scanner.nextLine();
                        int serie;
                        do {
                            System.out.print("Digite a série do aluno: ");
                            serie = scanner.nextInt();
                            scanner.nextLine(); // consome a quebra de linha deixada pelo nextInt()
                            if (serie < 1 || serie > 9) {
                                System.out.println("Série inválida, tente novamente.");
                            }
                        } while (serie < 1 || serie > 9);
                        double nota;
                        do {
                            System.out.print("Digite a nota do aluno: ");
                            nota = scanner.nextDouble();
                            scanner.nextLine(); // consome a quebra de linha deixada pelo nextDouble()
                            if (nota < 0 || nota > 10) {
                                System.out.println("Nota inválida, tente novamente.");
                            }
                        } while (nota < 0 || nota > 10);
                        nomes.add(nome);
                        series.add(Integer.toString(serie));
                        notas.add(nota);
                        System.out.println("Aluno cadastrado com sucesso!");
                    }
                    case 0 -> {
                        System.out.println("Encerrando o programa...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
