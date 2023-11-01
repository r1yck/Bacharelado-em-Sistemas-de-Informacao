package fila;

import java.util.LinkedList;

public class Fila<Tipo> {

    private LinkedList<Tipo> objetos = new LinkedList<Tipo>();

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
        return objetos.toString();
    }

    public int tamanho() {
        return objetos.size();
    }

    public Tipo espia() {
        if (!vazia()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

    public int verificaElemento(Tipo elemento) {

        return objetos.indexOf(elemento);
    }

    public static void main(String[] args) {

        Aluno aluno = new Aluno("Bruno", 20);

        Fila<Object> fila = new Fila<Object>();

        fila.insere(aluno);
        fila.insere("Clesio");
        fila.insere("Rafael");
        System.out.println(fila);

        Aluno a1 = (Aluno) fila.remove();
        System.out.println(a1);

        Fila<Aluno> filaAluno = new Fila<Aluno>();
        filaAluno.insere(aluno);

        Aluno a2 = filaAluno.remove();
        System.out.println(a2);

    }

}
