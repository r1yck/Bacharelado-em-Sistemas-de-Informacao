package Bicicleta;

public class Bike {
  // atributos da classe
  String cor;
  String marca;
  int ano;
  double velocidade;

  // métodos da classe

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public double getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(double velocidade) {
    this.velocidade = velocidade;
  }

  public void setFrear(String frear) {
    if (frear == "true")
      this.velocidade = 0;
    else if (frear == "false")
      this.velocidade = velocidade;

  }

}
