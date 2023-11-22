
package arvore;

import javax.swing.JOptionPane;


public class Aluno implements Comparable{

   private String  nome;
    private int    idade;
    private float  nota;
    private String turma;


    //Construtor passando nome e idade
    public  Aluno( String no, int id)
    {
      this.nome = no;
      this.idade = id;
    }
    
   
    @Override 
    public int compareTo(Object outro){
        if(this.idade < ((Aluno)outro).getIdade())
            return -1;
        if(this.idade > ((Aluno)outro).getIdade())
            return 1;
        
        return 0;
    }
    
     
    public String toString() {
         return this.getNome() + " - " + this.idade;
    }

    public boolean equals(Aluno outro) {
     
        return this.nome.equals( outro.getNome() );
    }
   
    
     /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the nota
     */
    public float getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * @return the turma
     */
    public String getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(String turma) {
        this.turma = turma;
    }


}
