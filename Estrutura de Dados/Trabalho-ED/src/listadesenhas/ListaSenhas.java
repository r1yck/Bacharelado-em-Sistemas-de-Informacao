package listadesenhas;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ListaSenhas implements Serializable {

    private LinkedList<Senha> listaSenhas = new LinkedList<>();

    public void incluirSenha(String aplicativo, String senha) {
        Senha novaSenha = new Senha(aplicativo, senha);
        listaSenhas.addLast(novaSenha);
    }

    public void deletarSenha() {
        if (!listaSenhas.isEmpty()) {
            listaSenhas.removeLast();
        }
    }

    public void mostrarListaSenhas() {
        StringBuilder output = new StringBuilder();
        for (Senha senha : listaSenhas) {
            output.append(senha).append("\n");
        }
        exibirMensagem(output.toString(), "Lista de Senhas");
    }

    public void salvarListaEmArquivo(String nomeArquivo) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Lista de Senhas");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
                outputStream.writeObject(listaSenhas);
                exibirMensagem("Lista salva com sucesso!", "Sucesso");
            } catch (IOException e) {
                exibirMensagem("Erro ao salvar a lista: " + e.getMessage(), "Erro");
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarListaDeArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Carregar Lista de Senhas");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
                listaSenhas = (LinkedList<Senha>) inputStream.readObject();
                exibirMensagem("Lista carregada com sucesso!", "Sucesso");
            } catch (IOException | ClassNotFoundException e) {
                exibirMensagem("Erro ao carregar a lista: " + e.getMessage(), "Erro");
            }
        }
    }

    public LinkedList<Senha> getListaSenhas() {
        return listaSenhas;
    }

    public void agruparSenhasPorAplicativo() {
        Map<String, Stack<Senha>> pilhasPorAplicativo = new HashMap<>();

        for (Senha senha : listaSenhas) {
            pilhasPorAplicativo.computeIfAbsent(senha.aplicativo, k -> new Stack<>()).push(senha);
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Stack<Senha>> entry : pilhasPorAplicativo.entrySet()) {
            output.append("Pilha para aplicativo ").append(entry.getKey()).append(":\n");
            for (Senha senha : entry.getValue()) {
                output.append(senha).append("\n");
            }
        }
        exibirMensagem(output.toString(), "Pilhas por Aplicativo");
    }

    public class IndiceInvertido {
    private LinkedList<Senha> listaSenhas = new LinkedList<>();

    public void criarIndice(String arquivoSenhas) {
        lerArquivoSenhas(arquivoSenhas);
    }

    
        public void mostrarIndice() {
        Map<String, Integer> indice = new HashMap<>();

        for (Senha senha : listaSenhas) {
            String aplicativo = senha.aplicativo;
            String[] palavras = aplicativo.split("_");
            for (String palavra : palavras) {
                if (!palavra.isEmpty()) {
                    indice.put(palavra, indice.getOrDefault(palavra, 0) + 1);
                }
            }
        }

        StringBuilder output = new StringBuilder("Índice Invertido:\n");
        for (Map.Entry<String, Integer> entry : indice.entrySet()) {
            output.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        exibirMensagem(output.toString(), "Índice Invertido");
    }


        private void lerArquivoSenhas(String arquivoSenhas) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoSenhas))) {
            String linha;
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

    private static void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

class FilaSenhas {

    private Queue<Senha> filaSenhas = new LinkedList<>();

    public void inserirListaFila(LinkedList<Senha> listaSenhas) {
        filaSenhas.addAll(listaSenhas);
    }

    public void mostrarFilaSenhas() {
        StringBuilder output = new StringBuilder();
        for (Senha senha : filaSenhas) {
            output.append(senha).append("\n");
        }
        exibirMensagem(output.toString(), "Fila de Senhas");
    }

    private static void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

class ArvoreSenhas {

    private TreeSet<Senha> arvoreSenhas = new TreeSet<>((s1, s2) -> s1.senha.length() - s2.senha.length());

    public void inserirListaArvore(LinkedList<Senha> listaSenhas) {
        arvoreSenhas.addAll(listaSenhas);
    }

    public void mostrarArvoreSenhas() {
        StringBuilder output = new StringBuilder();
        for (Senha senha : arvoreSenhas) {
            output.append(senha).append("\n");
        }
        exibirMensagem(output.toString(), "Árvore de Senhas");
    }

    private static void exibirMensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

class Senha implements Serializable {

    String aplicativo;
    String senha;

    public Senha(String aplicativo, String senha) {
        this.aplicativo = aplicativo;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Aplicativo: " + aplicativo + ", Senha: " + senha;
    }
}
