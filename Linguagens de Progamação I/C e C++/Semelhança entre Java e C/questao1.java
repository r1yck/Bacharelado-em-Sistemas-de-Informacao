import javax.swing.JOptionPane;

public class questao1 {

  public static void main(String[] args) {

    double n1, n2, n3, media, ma;

    n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota 1."));
    n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota 2."));
    n3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota 2."));

    media = (n1 + n2 + n3) / 3;
    ma = (n1 + (n2 * 2) + (n3 * 3) + media) / 7;

    if (ma >= 9 && ma <= 10) {
      JOptionPane.showMessageDialog(null, "Nota geral = A");
    }

    else if (ma >= 7.5 && ma < 9) {
      JOptionPane.showMessageDialog(null, "Nota geral = B");

    }

    else if (ma >= 6 && ma < 7.5) {
      JOptionPane.showMessageDialog(null, "Nota geral = C");

    }

    else if (ma >= 4 && ma < 6) {
      JOptionPane.showMessageDialog(null, "Nota geral = D");

    }

    else if (ma >= 0 && ma < 4) {
      JOptionPane.showMessageDialog(null, "Nota geral = E");

    }

    else {
      JOptionPane.showMessageDialog(null, "Erro. \nAlguma nota foi inserida negativa ou maior que 10.");

    }
  }

}