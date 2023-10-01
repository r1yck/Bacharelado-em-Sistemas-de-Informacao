package lista;

//import javax.swing.JOptionPane;

public class Object {

    private String nome;
    private int idade;
    private float nota;
    private String turma;

    //Construtor vazio
    public Object(){
    
    }
    
    //Construtor passando nome
    public Object(String nome) {
        this.nome = nome;
    }

    //Construtor passando dados
    public Object(String nome, int idade, float nota, String turma) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
        this.turma = turma;
    }

    //toString
    
     public String toString() {
        return this.getNome() + " - " + this.turma;
    }
    
     
     //equals
     public boolean equals(Object outro) {
        
         return this.nome.equals( outro.getNome());
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    //Método main
    /*
    public static void main(String[] args) {
        Object a1 = new Object("Rafael");
        Object a2 = new Object("Bernardo", 18, 8, "III Semestre");
        Object a3 = new Object("Rafael");

        JOptionPane.showMessageDialog(null,a1);
        JOptionPane.showMessageDialog(null,a2);
        JOptionPane.showMessageDialog(null,a3);

        if(a1.equals(a3))
            JOptionPane.showMessageDialog(null, "a1 = a3");
            
    }
    */
}