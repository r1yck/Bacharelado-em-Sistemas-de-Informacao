package listadesenhas;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Menu {

    private ListaSenhas listaSenhas = new ListaSenhas();

    public void exibirMenu() {
        int opcao;
        do {
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
            opcao = Integer.parseInt(exibirInput(menu));

            executarOpcao(opcao);
        } while (opcao != 0);
    }

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

    private void incluirSenha() {
        String aplicativo = exibirInput("Digite o nome do aplicativo:");
        String senha = exibirInput("Digite a senha:");
        listaSenhas.incluirSenha(aplicativo, senha);
        exibirMensagem("Senha incluída com sucesso!", "Sucesso");
    }

    private void inserirListaFila() {
        LinkedList<Senha> listaSenhas = new LinkedList<>(this.listaSenhas.getListaSenhas());
        FilaSenhas filaSenhas = new FilaSenhas();
        filaSenhas.inserirListaFila(listaSenhas);
        filaSenhas.mostrarFilaSenhas();
    }

    private void criarPilhas() {
        listaSenhas.agruparSenhasPorAplicativo();
    }

    private void inserirListaArvore() {
        LinkedList<Senha> listaSenhas = new LinkedList<>(this.listaSenhas.getListaSenhas());
        ArvoreSenhas arvoreSenhas = new ArvoreSenhas();
        arvoreSenhas.inserirListaArvore(listaSenhas);
        arvoreSenhas.mostrarArvoreSenhas();
    }

    private void salvarLista() {
    String nomeArquivo = exibirInput("Digite o nome do arquivo para salvar a lista:");
    listaSenhas.salvarListaEmArquivo(nomeArquivo);
}

    private void criarIndiceInvertido() {
        String nomeArquivoSenhas = exibirInput("Digite o nome do arquivo de texto com senhas:");
        ListaSenhas listaSenhas = new ListaSenhas();  // Crie uma instância de ListaSenhas
        ListaSenhas.IndiceInvertido indiceInvertido = listaSenhas.new IndiceInvertido();  // Crie uma instância de IndiceInvertido usando a instância de ListaSenhas
        indiceInvertido.criarIndice(nomeArquivoSenhas);
        indiceInvertido.mostrarIndice();
    }

    private String exibirInput(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }

    private void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
    Menu menu = new Menu();
    menu.listaSenhas.carregarListaDeArquivo();
    menu.exibirMenu();
}
}
