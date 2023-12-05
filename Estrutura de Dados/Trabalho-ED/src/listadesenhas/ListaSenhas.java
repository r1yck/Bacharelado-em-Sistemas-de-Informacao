// Pacote onde a classe está localizada
package listadesenhas;

// Importações de bibliotecas necessárias
import javax.swing.*;
import java.io.*;
import java.util.*;

// Definição da classe ListaSenhas que implementa Serializable
public class ListaSenhas implements Serializable {

    // Lista encadeada de senhas
    private LinkedList<Senha> listaSenhas = new LinkedList<>();

    // Método para incluir uma nova senha na lista
    public void incluirSenha(String aplicativo, String senha) {
        Senha novaSenha = new Senha(aplicativo, senha);
        listaSenhas.addLast(novaSenha);
    }

    // Método para deletar a última senha da lista, se existir
    public void deletarSenha() {
        if (!listaSenhas.isEmpty()) {
            listaSenhas.removeLast();
        }
    }

    // Método para mostrar todas as senhas na lista
    public void mostrarListaSenhas() {
        // Construção de uma representação da lista em formato de string
        StringBuilder output = new StringBuilder();
        for (Senha senha : listaSenhas) {
            output.append(senha).append("\n");
        }
        // Exibir a lista de senhas em uma mensagem gráfica
        exibirMensagem(output.toString(), "Lista de Senhas");
    }

    // Método para salvar a lista de senhas em um arquivo
    public void salvarListaEmArquivo(String nomeArquivo) {
        // Janela de seleção de arquivo para salvar
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Lista de Senhas");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obter o arquivo selecionado pelo usuário
            File arquivoSelecionado = fileChooser.getSelectedFile();
            String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
                // Escrever a lista de senhas no arquivo
                outputStream.writeObject(listaSenhas);
                exibirMensagem("Lista salva com sucesso!", "Sucesso");
            } catch (IOException e) {
                exibirMensagem("Erro ao salvar a lista: " + e.getMessage(), "Erro");
            }
        }
    }

    // Método para carregar a lista de senhas de um arquivo
    @SuppressWarnings("unchecked")
    public void carregarListaDeArquivo() {
        // Janela de seleção de arquivo para carregar
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Carregar Lista de Senhas");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obter o arquivo selecionado pelo usuário
            File arquivoSelecionado = fileChooser.getSelectedFile();
            String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
                // Ler a lista de senhas do arquivo
                listaSenhas = (LinkedList<Senha>) inputStream.readObject();
                exibirMensagem("Lista carregada com sucesso!", "Sucesso");
            } catch (IOException | ClassNotFoundException e) {
                exibirMensagem("Erro ao carregar a lista: " + e.getMessage(), "Erro");
            }
        }
    }

    // Método para obter a lista de senhas
    public LinkedList<Senha> getListaSenhas() {
        return listaSenhas;
    }

    // Método para agrupar as senhas por aplicativo e exibir em pilhas
    public void agruparSenhasPorAplicativo() {
        // Mapa para armazenar pilhas de senhas por aplicativo
        Map<String, Stack<Senha>> pilhasPorAplicativo = new HashMap<>();

        // Iterar sobre a lista de senhas
        for (Senha senha : listaSenhas) {
            // Adicionar a senha à pilha correspondente no mapa
            pilhasPorAplicativo.computeIfAbsent(senha.aplicativo, k -> new Stack<>()).push(senha);
        }

        // Construção de uma representação das pilhas em formato de string
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Stack<Senha>> entry : pilhasPorAplicativo.entrySet()) {
            output.append("Pilha para aplicativo ").append(entry.getKey()).append(":\n");
            for (Senha senha : entry.getValue()) {
                output.append(senha).append("\n");
            }
        }
        // Exibir as pilhas por aplicativo em uma mensagem gráfica
        exibirMensagem(output.toString(), "Pilhas por Aplicativo");
    }

    // Classe interna IndiceInvertido para operações específicas
    public class IndiceInvertido {

        // Lista de senhas específica para o índice invertido
        private LinkedList<Senha> listaSenhas = new LinkedList<>();

        // Método para criar um índice invertido a partir de um arquivo de senhas
        public void criarIndice(String arquivoSenhas) {
            lerArquivoSenhas(arquivoSenhas);
        }

        // Método para mostrar o índice invertido
        public void mostrarIndice() {
            // Mapa para armazenar a contagem de palavras no índice
            Map<String, Integer> indice = new HashMap<>();

            // Iterar sobre a lista de senhas
            for (Senha senha : listaSenhas) {
                String aplicativo = senha.aplicativo;
                String[] palavras = aplicativo.split("_");
                // Contar a ocorrência de cada palavra no índice
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        indice.put(palavra, indice.getOrDefault(palavra, 0) + 1);
                    }
                }
            }

            // Construção de uma representação do índice em formato de string
            StringBuilder output = new StringBuilder("Índice Invertido:\n");
            for (Map.Entry<String, Integer> entry : indice.entrySet()) {
                output.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
            }
            // Exibir o índice invertido em uma mensagem gráfica
            exibirMensagem(output.toString(), "Índice Invertido");
        }

        // Método privado para ler senhas de um arquivo e adicionar à lista
        private void lerArquivoSenhas(String arquivoSenhas) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivoSenhas))) {
                String linha;
                // Ler cada linha do arquivo e adicionar uma senha à lista
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(" ");
                    String aplicativo = partes[0];
                    listaSenhas.add(new Senha(aplicativo, ""));
                }
                exibirMensagem("Índice invertido criado com sucesso!", "Sucesso");
            } catch (IOException e) {
                exibirMensagem("Erro ao ler o arquivo de senhas: " + e.getMessage(), "Erro");
            }
        }
    }

    // Método privado para exibir uma mensagem gráfica
    private static void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

// Classe FilaSenhas para operações com uma fila de senhas
class FilaSenhas {

    // Fila de senhas usando uma estrutura de fila encadeada
    private Queue<Senha> filaSenhas = new LinkedList<>();

    // Método para inserir uma lista de senhas na fila
    public void inserirListaFila(LinkedList<Senha> listaSenhas) {
        filaSenhas.addAll(listaSenhas);
    }

    // Método para mostrar todas as senhas na fila
    public void mostrarFilaSenhas() {
        // Construção de uma representação da fila em formato de string
        StringBuilder output = new StringBuilder();
        for (Senha senha : filaSenhas) {
            output.append(senha).append("\n");
        }
        // Exibir a fila de senhas em uma mensagem gráfica
        exibirMensagem(output.toString(), "Fila de Senhas");
    }

    // Método privado para exibir uma mensagem gráfica
    private static void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

// Classe ArvoreSenhas para operações com uma árvore de senhas
class ArvoreSenhas {

    // Árvore de senhas usando uma estrutura de árvore ordenada
    private TreeSet<Senha> arvoreSenhas = new TreeSet<>((s1, s2) -> s1.senha.length() - s2.senha.length());

    // Método para inserir uma lista de senhas na árvore
    public void inserirListaArvore(LinkedList<Senha> listaSenhas) {
        arvoreSenhas.addAll(listaSenhas);
    }

    // Método para mostrar todas as senhas na árvore
    public void mostrarArvoreSenhas() {
        // Construção de uma representação da árvore em formato de string
        StringBuilder output = new StringBuilder();
        for (Senha senha : arvoreSenhas) {
            output.append(senha).append("\n");
        }
        // Exibir a árvore de senhas em uma mensagem gráfica
        exibirMensagem(output.toString(), "Árvore de Senhas");
    }

    // Método privado para exibir uma mensagem gráfica
    private static void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
