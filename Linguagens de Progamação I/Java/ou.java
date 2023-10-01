import javax.swing.JOptionPane;

public class ou {

  public static void main(String[] args) {

    int n1, n2;

    n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número."));
    n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite outro número."));

    if (n1 % 2 == 0 || n2 % 2 == 0) {
      JOptionPane.showMessageDialog(null, "Pelo menos um dos números digitados é par.");
    }

  }

}
