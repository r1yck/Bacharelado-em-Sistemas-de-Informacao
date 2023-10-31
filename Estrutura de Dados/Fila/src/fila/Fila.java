package fila;

import java.util.LinkedList;
import java.util.List;

public class Fila<Tipo> {

    private List<Tipo> objetos = new LinkedList<Tipo>();

    public void insere(Tipo obj) {
        this.objetos.add(obj);
    }

    public Tipo remove() {
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

    }

}
