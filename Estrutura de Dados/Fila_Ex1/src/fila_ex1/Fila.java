package fila_ex1;

import java.util.LinkedList;
import java.util.List;

public class Fila<Tipo> {

    private List<Tipo> objetos = new LinkedList<Tipo>();

    public void insere(Tipo obj) {
        this.objetos.add(obj);
    }

    public Tipo remove() {
        if (vazia()) {
            return null;
        }
        return this.objetos.remove(0);
    }

    public boolean vazia() {
        return this.objetos.size() == 0;
    }

    public String toString() {
        return objetos.toString();
    }

    public int tamanho() {
        return objetos.size();
    }

    public static void main(String[] args) {

        // Teste da Fila
        Fila<Integer> fila = new Fila<>();

        // Inserindo elementos
        fila.insere(1);
        fila.insere(2);
        fila.insere(3);

        // Imprimindo a fila
        System.out.println("Fila: " + fila);

        // Removendo elementos
        System.out.println("Removido: " + fila.remove());
        System.out.println("Removido: " + fila.remove());

        // Verificando se a fila está vazia
        System.out.println("Fila está vazia? " + fila.vazia());

        // Imprimindo o tamanho da fila
        System.out.println("Tamanho da fila: " + fila.tamanho());
    }

}
