package listadesenhas;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSenhas listaSenhas = new ListaSenhas();

        while (true) {
            System.out.println("Menu de Opções:");
            System.out.println("1. Incluir senha na LISTA");
            System.out.println("2. Deletar senha da LISTA");
            System.out.println("3. Mostrar LISTA de senhas");
            System.out.println("0. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do aplicativo:");
                    String aplicativo = scanner.nextLine();
                    System.out.println("Digite a senha:");
                    String senha = scanner.nextLine();

                    Senha novaSenha = new Senha(aplicativo, senha);
                    listaSenhas.adicionarSenha(novaSenha);
                    break;

                case 2:
                    listaSenhas.removerUltimaSenha();
                    break;

                case 3:
                    System.out.println("Lista de Senhas:");
                    listaSenhas.imprimirListaSenhas();
                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

