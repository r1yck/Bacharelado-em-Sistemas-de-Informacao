package fila;

public class Aluno {

    private String nome;
    private int idade;
    private float nota;
    private String turma;

    //Construtor  vazio
    public Aluno() {
    }

    //Construtor passando nome
    public Aluno(String no) {
        this.nome = no;
    }

    public Aluno(String no, int id) {
        this.nome = no;
        this.idade = id;
    }

    //Construtor passando dados
    public Aluno(String no, int id, float n, String t) {
        this.nome = no;
        this.idade = id;
        this.nota = n;
        this.turma = t;
    }

    public String toString() {
        return this.getNome() + "-" + this.getIdade();
    }

    public boolean equals(Aluno outro) {

        return this.nome.equals(outro.getNome());
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

}
