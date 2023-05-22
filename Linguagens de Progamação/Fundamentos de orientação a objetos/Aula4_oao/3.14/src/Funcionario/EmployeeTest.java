package Funcionario;

import javax.swing.JOptionPane;

public class EmployeeTest {
  public static void main(String[] args) {
    // Criando dois objetos Employee
    Employee employee1 = new Employee("João", "Silva", 5000.0);
    Employee employee2 = new Employee("Maria", "Souza", 6000.0);

    // Exibindo o salário anual de cada objeto Employee
    JOptionPane.showMessageDialog(null, "Salário anual do Employee 1: " + employee1.getSalarioAnual());
    JOptionPane.showMessageDialog(null, "Salário anual do Employee 2: " + employee2.getSalarioAnual());

    // Dando um aumento de 10% para cada Employee
    employee1.setSalarioMensal(employee1.getSalarioMensal() * 1.1);
    employee2.setSalarioMensal(employee2.getSalarioMensal() * 1.1);

    // Exibindo o novo salário anual de cada Employee
    JOptionPane.showMessageDialog(null, "\nNovo salário anual do Employee 1: " + employee1.getSalarioAnual());
    JOptionPane.showMessageDialog(null, "Novo salário anual do Employee 2: " + employee2.getSalarioAnual());
  }
}
