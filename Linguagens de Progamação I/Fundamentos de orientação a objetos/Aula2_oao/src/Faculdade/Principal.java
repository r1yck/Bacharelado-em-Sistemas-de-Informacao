//Classe, metodo, objeto e mensagem.

package Faculdade;

import javax.swing.JOptionPane;

public class Principal {

  public static void main(String[] args) {

    Aluno a1 = new Aluno();
    Turma t1 = new Turma();

    a1.setMatricularCurso("BSI");
    a1.setSituacao("Cursando.");
    a1.setTrancar(null);
    a1.setFormar(null);
    a1.setEvadir(null);

    t1.abrirTurma("BSI");
    t1.matricularAluno(null);

    JOptionPane.showMessageDialog(null,
        "Aluno 1 \nMatrícula: " + a1.getMatricularCurso() + "\nSituação: " + a1.getSituacao() + "\nTurma: "
            + t1.getTurma());

  }

}
