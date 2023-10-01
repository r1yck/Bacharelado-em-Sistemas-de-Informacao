package Teste;

public class Aluno {

  private String nome;
  private String end;
  private String tel;

  public Aluno() {

  }

  // consultor de classe com 1 parametro
  public Aluno(String n) {
    this.nome = n;
  }

  // consultor de classe com 2 parametros
  public Aluno(String n, String e) {
    this.nome = n;
    this.end = e;
  }

  // consultor de classe com 3 parametros
  public Aluno(String n, String e, String t) {
    this.nome = n;
    this.end = e;
    this.tel = t;
  }

}