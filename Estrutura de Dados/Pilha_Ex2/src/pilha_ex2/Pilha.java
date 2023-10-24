package pilha_ex2;

import java.util.LinkedList;

public class Pilha<Tipo> {

    private LinkedList<Tipo> objetos = new LinkedList<Tipo>();

    public void insere(Tipo obj) {
        this.objetos.add(obj);
    }

    public Tipo remove() {
        return this.objetos.removeLast();
    }

    public boolean vazia() {
        return this.objetos.size() == 0;
    }

    public int tamanho() {
        return this.objetos.size();
    }

    public String toString() {
        return objetos.toString();
    }

    /*public static void main(String[] args) {

        Peca p1 = new Peca("Parafuso");
        Peca p2 = new Peca("Protecao");
        Peca p3 = new Peca("LCD");
        Peca p4 = new Peca("flex");
        Peca p5 = new Peca("Botao home");

        Pilha<Peca> pilha = new Pilha<Peca>();
        pilha.insere(p1);
        pilha.insere(p2);
        pilha.insere(p3);
        pilha.insere(p4);
        pilha.insere(p5);

        System.out.println(pilha);

        Peca x = pilha.remove();
        System.out.println(pilha);
        System.out.println(pilha.tamanho());

        Pilha<String> p = new Pilha<String>();

        p.insere("String 1");
        p.insere("String 2");
        System.out.println(p);
        System.out.println(p.tamanho());
    }*/
}
