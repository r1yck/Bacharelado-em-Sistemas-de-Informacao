package Funcionario;

public class Employee {
    private String nome;
    private String sobrenome;
    private double salariomensal;

    public Employee(String nome, String sobrenome, double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        if (salariomensal > 0) {
            this.salariomensal = salariomensal;
        } else {
            this.salariomensal = 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalarioMensal() {
        return salariomensal;
    }

    public void setSalarioMensal(double salariomensal) {
        if (salariomensal > 0) {
            this.salariomensal = salariomensal;
        }
    }

    public double getSalarioAnual() {
        return salariomensal * 12;
    }
}
