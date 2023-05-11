package Faculdade;

public class Turma {
  // atributos da classe
  String turma;
  String aluno;

  // métodos da classe

  public String getTurma() {
    return turma;
  }

  public void abrirTurma(String turma) {
    this.turma = turma;
  }

  public String getAluno() {
    return aluno;
  }

  public void matricularAluno(String aluno) {
    this.aluno = aluno;
  }

}
