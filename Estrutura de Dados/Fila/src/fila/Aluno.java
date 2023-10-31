package fila;

public class Aluno {

    private String nome;
    private int id;
    private float nota;
    private String turma;

    public Aluno(String nome, int id, float nota, String turma) {
        this.nome = nome;
        this.id = id;
        this.nota = nota;
        this.turma = turma;
    }

    public String toString() {
        return this.getNome() + "-" + this.getId();
    }

    public boolean equals(Object outro) {
        Aluno a = (Aluno) outro;
        return this.nome.equals(a.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
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
}
