package arvore;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<Integer>();
        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(5);
        arvore.adicionar(9);
        arvore.adicionar(20);
        arvore.adicionarRec(15, arvore.getRaiz());
        arvore.adicionarRec(17, arvore.getRaiz());
        arvore.adicionarRec(18, arvore.getRaiz());
        arvore.adicionarRec(14, arvore.getRaiz());
        arvore.adicionarRec(7, arvore.getRaiz());
        arvore.adicionarRec(6, arvore.getRaiz());
        
        System.out.println("\n\nEm-ordem");
        System.out.println(arvore.emOrdem(arvore.getRaiz()));
        System.out.println("\n\nPre-ordem");
        System.out.println(arvore.preOrdem(arvore.getRaiz()));       
 
        arvore.remover(20);
        arvore.remover(9);
        arvore.remover(17);
        
        System.out.println("\n\nEm-ordem");
        System.out.println(arvore.emOrdem(arvore.getRaiz()));
          
        arvore.remover(20);
        arvore.remover(5);
        arvore.remover(15);
        arvore.remover(10);
        arvore.remover(6);
        arvore.remover(9);
          
        System.out.println("\n\nEm-ordem");
        System.out.println(arvore.emOrdem(arvore.getRaiz()));
       
     
        // ------------- Arvore de Alunos  ----
        
        Arvore<Aluno> a2 = new Arvore<Aluno>();
        
        a2.adicionar(new Aluno("Carlo", 12));
        a2.adicionar(new Aluno("Julia", 22));
        a2.adicionar(new Aluno("Breno", 5));
        a2.adicionar(new Aluno("Rafael",8));
        
        System.out.println("\n\nEm-ordem - Alunos");
        System.out.println(a2.emOrdem(a2.getRaiz()));


        
        // ------------- Arvore no java ----
        TreeSet<String> ts = new TreeSet<String>();
 
        // Adicionar
        ts.add("A");
        ts.add("B");
        ts.add("C");
 
        // Duplicado
        ts.add("C");
 
        // impirmir
        System.out.println("\n\nTreeSet - Java");
        System.out.println(ts);
        
        System.out.println("\nContém A " + ts.contains("A"));
        System.out.println("Primeiro " + ts.first());
        System.out.println("Ultimo   " + ts.last());
        
        
        ts.remove("C");
 
        // impirmir
        System.out.println("\n\nTreeSet - Java");
        System.out.println(ts);
        
    }
    
}
