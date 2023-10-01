package listaligada;

import java.util.LinkedList;

public class ListaLigada {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos = 0;

    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0) { // no comeco
            this.adicionaNoComeco(elemento);
        } else if (posicao == this.totalDeElementos) { // no fim
            this.adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public void remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posicao nao existe");
        }

        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;

        }
    }

    public int tamanho() {
        return this.totalDeElementos;
    }

    public boolean contem(Object elemento) {
        Celula atual = this.primeira;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) { 
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }

    public void adicionaNoComeco(Object elemento) {
        
        if (this.totalDeElementos == 0) {
            // caso especial da lista vazia
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        }
        else {
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;

    }

    public void removeDoComeco() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posicao simplesmente nao existe.");
        }

        this.primeira = this.primeira.getProxima();

        if (primeira != null) {
            this.primeira.setAnterior(null);
        }

        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }

        System.gc();
    }

    public void removeDoFim() {
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posicao nao existe");
        }
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;

    }

    private Celula pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posicao nao encontrada");
        }

        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    public String toString() {
        // Verificando se alista está vazia
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;

        // Percorrendo até o penúltimo elemento.
        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }

        // último elemento
        builder.append(atual.getElemento());
        builder.append("]");

        return builder.toString();
    }

    public String toString2() {

        String retorno = "[";
        Celula atual = primeira;

        while (atual != null) {
            retorno += atual.getElemento(); // pega elemento

            if (atual.getProxima() != null) // Se não é o último
                retorno += ", "; // add ,

            atual = atual.getProxima(); // pula pro próximo
        }

        retorno += "]";
        return retorno;
    }

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Sampas");
        Aluno a2 = new Aluno("Ricks");
        Aluno a3 = new Aluno("Kauas");
        Aluno a4 = new Aluno("Pernas");
        Aluno a5 = new Aluno("Relfs");

        ListaLigada lista = new ListaLigada();
        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(a3);

        System.out.println(lista);

        lista.adicionaNoComeco(a4);
        System.out.println(lista.toString2());

        lista.adiciona(3, a5);
        System.out.println(lista.toString2());
        
        lista.removeDoComeco();
        System.out.println(lista);
        
        lista.remove(2);
        System.out.println(lista);
        
        System.out.println(lista.tamanho());
        
        Aluno teste = new Aluno("Kauas");
        if(lista.contem(teste)){
            System.out.println("Contem aluno - " + teste);
        }

        if(lista.contem( new Aluno("Ricks"))){
            System.out.println("Contem aluno!");
        }
        else
            System.out.println("Nao contem aluno!");
        
        lista.removeDoFim();
        System.out.println(lista);
        lista.removeDoFim();
        System.out.println(lista);
        lista.removeDoFim();
        System.out.println(lista);
        
        // Lista LinkedList Java
        LinkedList         listaJava = new LinkedList();
        LinkedList<Aluno>  listaJava2 = new LinkedList<Aluno>();
        LinkedList<String> listaJava3 = new LinkedList<String>();
        
        listaJava.add(a1);
        listaJava.add(a2);
        listaJava.addFirst(a3);
        System.out.println(listaJava);
        System.out.println("\nTamanho lista: " + listaJava.size() + "\n");
    }
}