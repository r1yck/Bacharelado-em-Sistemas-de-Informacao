package Faculdade;

public class Aluno {
  // atributos da classe
  private String matricula;
  private String situacao;

  // métodos da classe

  public String getMatricularCurso() {
    return matricula;
  }

  public void setMatricularCurso(String matricula) {
    this.matricula = matricula;
  }

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(String situacao) {
    this.situacao = situacao;
  }

  public void setTrancar(String trancar) {
    if (trancar == "true")
      this.situacao = "Trancado.";
  }

  public void setFormar(String formar) {
    if (formar == "true")
      this.situacao = "Formado.";
  }

  public void setEvadir(String evadir) {
    if (evadir == "true")
      this.situacao = "Evadido.";
  }

  // retorna o curso que o aluno esta matriculado
  public String novaMat(String m) {
    return matricula = m;
  }

}
