package fila_ex1;

public class Aluno {

    private String nome;
    private int matricula;

    // Construtor
    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    // to String
    public String toString() {
        return "Aluno [nome=" + nome + ", matricula=" + matricula + "]";
    }

    // Equals
    public boolean equals(Object outro) {
        Aluno a = (Aluno) outro;
        return this.nome.equals(a.getNome());
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
