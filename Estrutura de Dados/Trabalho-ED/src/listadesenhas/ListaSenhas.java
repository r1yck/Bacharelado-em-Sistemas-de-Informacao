package listadesenhas;

import java.util.LinkedList;

public class ListaSenhas {
    private LinkedList<Senha> listaSenhas;

    public ListaSenhas() {
        this.listaSenhas = new LinkedList<>();
    }

    public void adicionarSenha(Senha senha) {
        listaSenhas.add(senha);
    }

    public void removerUltimaSenha() {
        if (!listaSenhas.isEmpty()) {
            listaSenhas.removeLast();
        }
    }

    public void imprimirListaSenhas() {
        for (Senha senha : listaSenhas) {
            System.out.println(senha);
        }
    }
}
