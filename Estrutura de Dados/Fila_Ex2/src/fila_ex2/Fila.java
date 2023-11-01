package fila_ex2;

import java.util.LinkedList;

public class Fila<Tipo> {

    private LinkedList<Tipo> objetos = new LinkedList<Tipo>();
    private String nomeFila;

    public Fila() {

    }

    //Construtor seta um nome para a Fila
    public Fila(String nome) {
        nomeFila = nome;
    }

    public String getNomeFila() {
        return nomeFila;
    }

    public void insere(Tipo obj) {
        this.objetos.add(obj);
    }

    public Tipo remove() {
        if (!vazia()) {
            return this.objetos.remove(0);
        } else {
            return null;
        }
    }

    public boolean vazia() {
        return this.objetos.size() == 0;
    }

    public String toString() {
        return " ===> " + nomeFila + " <===\n"
                + objetos.toString() + "\n";
    }

    public Tipo espia() {
        if (!vazia()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

    public int tamanho() {
        return objetos.size();
    }

    public int verificaElemento(Tipo elemento) {

        return objetos.indexOf(elemento);
    }

    public void inserePrioritario(Tipo obj) {
        if (!vazia() && obj.isPrioritaria()) {
            int i = 0;
            while (i < objetos.size() && objetos.get(i).isPrioritaria()) {
                i++;
            }
            objetos.add(i, obj);
        } else {
            objetos.add(obj);
        }
    }
}
