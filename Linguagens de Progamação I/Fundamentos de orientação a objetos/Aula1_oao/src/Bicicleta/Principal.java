//Classe, metodo, objeto e mensagem.

package Bicicleta;

import javax.swing.JOptionPane;

public class Principal {

  public static void main(String[] args) {

    // Bike b1;
    // b1 = new Bike();

    Bike b1 = new Bike();

    b1.setCor("Branca");
    b1.setMarca("Caloi");
    b1.setAno(2007);
    b1.setVelocidade(15);
    b1.setFrear("true");

    JOptionPane.showMessageDialog(null,
        "Cor: " + b1.getCor() + "\nMarca: " + b1.getMarca() + "\nAno: " + b1.getAno() + "\nVelocidade atual: "
            + b1.getVelocidade() + "km/h  ");

  }

}
