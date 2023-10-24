package pilha_ex2;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        // Digitar texto
        String textoCrip = "";
        String texto = JOptionPane.showInputDialog("Digite o Texto");

        LinkedList<Pilha<Character>> lista = new LinkedList<Pilha<Character>>();

        String palavra = "";

        //---- Identificar as palavras e inserir em pilhas
        // Percorrer o texto
        for (int i = 0; i < texto.length(); i++) {

            if (texto.charAt(i) != ' ') {
                palavra += texto.charAt(i); // Pega caracter e acumula a palavra
            } else {  // Fim de palavra

                // Inserir palavra na pilha (Caracter por caracter)
                Pilha<Character> Patual = new Pilha<Character>();
                for (int j = 0; j < palavra.length(); j++) {
                    Patual.insere(palavra.charAt(j));
                }

                // Inserir pilha na lista
                lista.add(Patual);

                palavra = "";
            }
        }
        // ------ Última palavra pois não achou espaço vazio
        if (palavra.length() > 0) {
            //Inserir palavra na pilha (Caracter por caracter)
            Pilha<Character> Pfinal = new Pilha<Character>();
            for (int f = 0; f < palavra.length(); f++) {
                Pfinal.insere(palavra.charAt(f));
            }

            // Inserir pilha na lista
            lista.add(Pfinal);

        }

        //-------- Remover palavra por palavra das pilhas
        for(int i = 0; i < lista.size(); i++) {

            Pilha<Character> pilha = lista.get(i); // Pilha da lista

            // Pegar caracter para montar a palavra
            while (pilha.tamanho() > 0) {
                textoCrip += pilha.remove();
            }

            textoCrip += " ";
        }

        System.out.println(textoCrip);
    }

}