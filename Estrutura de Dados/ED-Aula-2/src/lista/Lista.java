package lista;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Lista {
    
    //Declarando e inicializando um array de Object com capacidade 100.
    private Object[] objetos = new Object[3];
    
    private int totalDeObjetos = 0;
    
    private void garantaEspaço() {
        if (this.totalDeObjetos == this.objetos.length) {
            Object[] novaArray = new Object[this.objetos.length * 2];
            for (int i = 0; i < this.objetos.length; i++) {
                novaArray[i] = this.objetos[i];
            }
            this.objetos = novaArray;
        }
    }
    
    public void adiciona (Object objeto){
        garantaEspaço();
        
        this.objetos[this.totalDeObjetos] = objeto;
        this.totalDeObjetos++;
    }
    
    public void adiciona(int posicao, Object aluno) {
        garantaEspaço();
        
        if (!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        
        for (int i = this.totalDeObjetos - 1; i >= posicao; i--){
            this.objetos[i + 1] = this.objetos[i];
        }
        
        this.objetos[posicao] = aluno;
        this.totalDeObjetos++;
    }
    
    @Override
    public String toString() {
        
        if (this.totalDeObjetos == 0) {
            return "[]";

        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < this.totalDeObjetos - 1; i++) {
            builder.append(this.objetos[i]);
            builder.append(", ");

        }

        builder.append(this.objetos[this.totalDeObjetos - 1]);
        builder.append("]");

        return builder.toString();
    }
    
    public String toString2() {
        if (totalDeObjetos == 0) {
            return "[]";
        }
        
        String retorno;
        retorno = "[";
        
        for (int i = 0; i < totalDeObjetos -1; i++) {
            retorno += objetos[i] + ", ";
        }
        
        retorno += objetos[totalDeObjetos - 1] + "]";
        
        return retorno;
 }
    
    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.totalDeObjetos;
    }
    
    public Object pega(int posicao) {
        
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
            //return null;
        }
        return this.objetos[posicao];
        
    }
    
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeObjetos;
    }
    
    public void remove(int posicao) {
        
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posicao invalida");
        }
        for (int i = posicao; i < this.totalDeObjetos - 1; i++){
            this.objetos[i] = this.objetos[i + 1];
        }
        this.totalDeObjetos--;
    }
    
    //Exercicio LISTA - Q7 - Remove todos os objetos iguais encontrados
    public void remove (Object obj) {
        
        int i = 0; 
        while(i < totalDeObjetos){
            
            if(obj.equals(objetos[i]))
                remove(i);
            else
              i++;
        }
    }
    
        //Exercicio LISTA - Q8 - Remove todos os objetos
    public void clear () {
            
        totalDeObjetos = 0;
        
        /*int i = 0; 
        while(i < totalDeObjetos){
            
            remove(i);
        }*/
            
    }
    
        //Exercicio LISTA - 11 - Localize index de occorrencia passada
    public int indexOf(Object obj, int ocorr)
    {
        int posRetorno = -1;
        int quant = 0;
        
        for(int i=0; i<totalDeObjetos; i++)
        {
            quant++; // Contador de ocorrencia de objeto
            
            if(quant == ocorr){ // Já chegou na ocorrencia desejada
                posRetorno = i; // Pegado a posição do objeto
            break;
            }
        }
        
        
        if (posRetorno == -1){
            throw new IllegalArgumentException("Posicao nao encontrada");
        }
        else
            return posRetorno;
    }
    
    public int QuantOcorrencia(Object obj)
    {
        int quant = 0;
        
        for(int i=0; i<totalDeObjetos; i++)
        {
            
            if(obj.equals(objetos[i]))
                quant++; // Contador de ocorrência do objeto
            
        }
        
        return quant;
        
    }


    
    public boolean contem(Object objeto) {
        
        for(int i=0; i < totalDeObjetos; i++){
            
            if(objeto.equals(objetos[i]))
                return true;
        }
        
        return false;
    }
    
    public int tamanho(){
        
        return this.totalDeObjetos;  
    }
    
    
    public static void main(String[] args) {
        Object a1 = new Object("Rafael");
        Object a2 = new Object("Bernardo");
        Object a3 = new Object("Clesio");
        Object a4 = new Object("Henrique");

        ArrayList lista = new ArrayList();
                
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
        lista.add(0,a4);
        lista.add("Teste de String");
        Double d = 10.0;
        lista.add(d);
        
        lista.remove(2);
        System.out.println(lista);
        System.out.println();
          
        ArrayList<Object> listaAluno = new ArrayList<Object>();
        
        listaAluno.add(a2);
        listaAluno.add(a3);
        listaAluno.add(0,a4);
        //listaAluno.add("Teste");
        //listaAluno.add(d);
        
        Object y = listaAluno.get(0);
        
        
        /*try {
            lista.remove(20);
            System.out.println(lista);
            
        } catch (Exception x){
            System.out.println("Posicao 20 nao existe!" + x);
        }
        
        finally {
            System.out.println("Rodou Finally");
        } */
        
        /* if(lista.contem(a1))
            System.out.println("Sim");
        else
            System.out.println("Não");
        
        Object b;
        try {
            
            b = lista.pega(5);
            System.out.println(b.getNome());
            
        } catch (Exception e){
            System.out.println("Object não existe");
            
        } */
        
        /* if(b == null)
            System.out.println("Object não existe");
        else
            System.out.println(b.getNome()); */
    }
    
    
}