import javax.swing.JOptionPane;

public class negação {
  public static void main(String[] args) {

    boolean a = true;
    boolean b = false;

    JOptionPane.showMessageDialog(null, "a = " + a + "\nNegação de a = " + !a);
    JOptionPane.showMessageDialog(null, "b = " + b + "\nNegação de b = " + !b);

  }
}
