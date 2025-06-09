
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArvoreExpressao arvore = new ArvoreExpressao();
        String expressao = "";
        int escolha = -1;

        while (escolha != 5) {
            exibirMenu();
            System.out.print("Digite a opção desejada: ");

            if (entrada.hasNextInt()) {
                escolha = entrada.nextInt();
                entrada.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.print("Digite a expressão infixa: ");
                        expressao = entrada.nextLine();
                        System.out.println("Expressão salva com sucesso!");
                        break;

                    case 2:
                        try {
                            arvore.construir(expressao);
                            System.out.println("Árvore criada com sucesso.");
                        } catch (Exception e) {
                            System.out.println("Erro ao montar a árvore. Verifique a expressão.");
                        }
                        break;

                    case 3:
                        System.out.println("Pré-ordem:");
                        arvore.preOrdem();
                        System.out.println("\nIn-ordem:");
                        arvore.inOrdem();
                        System.out.println("\nPós-ordem:");
                        arvore.posOrdem();
                        break;

                    case 4:
                        float resultado = arvore.avaliar();
                        System.out.println("Resultado: " + resultado);
                        break;

                    case 5:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } else {
                System.out.println("Entrada inválida. Digite um número.");
                entrada.next();
            }
        }

        entrada.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1 - Informar expressão");
        System.out.println("2 - Montar árvore");
        System.out.println("3 - Mostrar árvore (Pré/In/Pós)");
        System.out.println("4 - Calcular resultado");
        System.out.println("5 - Sair");
    }
}
