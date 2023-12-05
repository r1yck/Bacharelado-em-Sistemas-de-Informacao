// Pacote onde a classe está localizada
package listadesenhas;

// Importações de bibliotecas necessárias
import javax.swing.*;
import java.io.*;
import java.util.*;

// Definição da classe Menu
public class Menu {

    // Instância de ListaSenhas para manipular a lista de senhas
    private ListaSenhas listaSenhas = new ListaSenhas();

    // Método para exibir o menu principal
    public void exibirMenu() {
        int opcao;
        do {
            // Construção do menu em formato de string
            String menu = "Menu:\n"
                    + "1. Incluir senha na LISTA\n"
                    + "2. Deletar senha da LISTA\n"
                    + "3. Mostrar LISTA de senhas\n"
                    + "4. Inserir lista de senhas numa FILA\n"
                    + "5. Criar PILHAS com palavras que são do mesmo aplicativo\n"
                    + "6. Inserir lista de senhas numa ARVORE\n"
                    + "7. Salvar Lista\n"
                    + "8. [Extra] Criar índice invertido\n"
                    + "0. Sair\n"
                    + "Escolha uma opção:";
            // Obtenção da opção escolhida pelo usuário
            opcao = Integer.parseInt(exibirInput(menu));

            // Executar a opção escolhida
            executarOpcao(opcao);
        } while (opcao != 0);
    }

    // Método para executar a opção escolhida pelo usuário
    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                incluirSenha();
                break;
            case 2:
                listaSenhas.deletarSenha();
                break;
            case 3:
                listaSenhas.mostrarListaSenhas();
                break;
            case 4:
                inserirListaFila();
                break;
            case 5:
                criarPilhas();
                break;
            case 6:
                inserirListaArvore();
                break;
            case 7:
                salvarLista();
                break;
            case 8:
                criarIndiceInvertido();
                break;
            case 0:
                exibirMensagem("Saindo do programa. Obrigado!", "Saída");
                break;
            default:
                exibirMensagem("Opção inválida", "Erro");
        }
    }

    // Método para incluir uma senha na lista
    private void incluirSenha() {
        String aplicativo = exibirInput("Digite o nome do aplicativo:");
        String senha = exibirInput("Digite a senha:");
        listaSenhas.incluirSenha(aplicativo, senha);
        exibirMensagem("Senha incluída com sucesso!", "Sucesso");
    }

    // Método para inserir a lista de senhas em uma fila
    private void inserirListaFila() {
        LinkedList<Senha> listaSenhas = new LinkedList<>(this.listaSenhas.getListaSenhas());
        FilaSenhas filaSenhas = new FilaSenhas();
        filaSenhas.inserirListaFila(listaSenhas);
        filaSenhas.mostrarFilaSenhas();
    }

    // Método para criar pilhas com palavras que são do mesmo aplicativo
    private void criarPilhas() {
        listaSenhas.agruparSenhasPorAplicativo();
    }

    // Método para inserir a lista de senhas em uma árvore
    private void inserirListaArvore() {
        LinkedList<Senha> listaSenhas = new LinkedList<>(this.listaSenhas.getListaSenhas());
        ArvoreSenhas arvoreSenhas = new ArvoreSenhas();
        arvoreSenhas.inserirListaArvore(listaSenhas);
        arvoreSenhas.mostrarArvoreSenhas();
    }

    // Método para salvar a lista de senhas em um arquivo
    private void salvarLista() {
        String nomeArquivo = exibirInput("Digite o nome do arquivo para salvar a lista:");
        listaSenhas.salvarListaEmArquivo(nomeArquivo);
    }

    // Método para criar um índice invertido a partir de um arquivo de senhas
    private void criarIndiceInvertido() {
        String nomeArquivoSenhas = exibirInput("Digite o nome do arquivo de texto com senhas:");
        ListaSenhas listaSenhas = new ListaSenhas();  // Crie uma instância de ListaSenhas
        ListaSenhas.IndiceInvertido indiceInvertido = listaSenhas.new IndiceInvertido();  // Crie uma instância de IndiceInvertido usando a instância de ListaSenhas
        indiceInvertido.criarIndice(nomeArquivoSenhas);
        indiceInvertido.mostrarIndice();
    }

    // Método para exibir uma mensagem de entrada e obter a resposta do usuário
    private String exibirInput(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }

    // Método para exibir uma mensagem gráfica
    private void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.listaSenhas.carregarListaDeArquivo();  // Carregar a lista de senhas do arquivo ao iniciar
        menu.exibirMenu();  // Exibir o menu principal
    }
}
