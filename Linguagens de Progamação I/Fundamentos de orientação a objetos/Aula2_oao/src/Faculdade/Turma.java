package Faculdade;

public class Turma {
  // atributos da classe
  private int ano;
  private int semestre;
  private int diaSemana;
  private String horarios;

  // métodos da classe
  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public int getSemestre() {
    return semestre;
  }

  public void setSemestre(int semestre) {
    this.semestre = semestre;
  }

  public int getDiaSemana() {
    return diaSemana;
  }

  public void setDiaSemana(int diaSemana) {
    this.diaSemana = diaSemana;
  }

  public String getHorarios() {
    return horarios;
  }

  public void setHorarios(String horarios) {
    this.horarios = horarios;
  }

  public String abrirTurma(int a, int s) {
    String retorna = "";
    this.ano = a;
    this.semestre = s;
    retorna = "" + a + " " + s;
    return retorna;
  }

  public int matricularAluno(int s) {
    this.semestre = s;
    return semestre;
  }
}
