import javax.swing.JOptionPane;

public class diferente {

  public static void main(String[] args) {

    String c1, c2;

    c1 = JOptionPane.showInputDialog(null, "Digite um caractere.");
    c2 = JOptionPane.showInputDialog(null, "Digite outro caractere.");

    if (c1 != c2) {
      JOptionPane.showMessageDialog(null, "Os caracateres são diferentes.");
    }

  }

}