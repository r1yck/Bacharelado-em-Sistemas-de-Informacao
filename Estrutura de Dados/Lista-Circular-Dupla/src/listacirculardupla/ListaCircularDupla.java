package listacirculardupla;

public class ListaCircularDupla {
    
    private CelulaCircularDupla primeira;
    private CelulaCircularDupla ultima;
    private int totalDeElementos = 0;
    
    public void adiciona(Aluno aluno) {
        CelulaCircularDupla nova = new CelulaCircularDupla(aluno);
        // Lista vazia
        if (this.totalDeElementos == 0) {
            this.primeira = nova;
            this.ultima = nova;
        } else { // Lista com elementos
            nova.setAnterior(this.ultima);
            this.ultima.setProxima(nova);
            this.ultima = nova;
        }
        this.ultima.setProxima(this.primeira); // Tornando  a lista circular
        this.primeira.setAnterior(ultima);
        this.totalDeElementos++;
    }
    
    public void removeDoComeco() {
        if (this.totalDeElementos == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        this.primeira = this.primeira.getProxima();
        if (this.primeira != null) {
            this.primeira.setAnterior(null);
        }
        this.ultima.setProxima(this.primeira); // Tornando a lista circular
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }
    
    public void imprimeLista() {
        if (totalDeElementos == 0) {
            System.out.println("Lista vazia");
            return;
        }
        StringBuilder builder = new StringBuilder();
        CelulaCircularDupla atual = this.primeira;
        
        builder.append("[");
        do {
        builder.append(" ").append(atual.getAluno()).append(" ");
        atual = atual.getProxima();
        } while (atual != this.primeira);
        
        builder.append("]");
        System.out.println(builder.toString());
    }
    
    public int tamanho() {
        return this.totalDeElementos;
    }
    
    public static void main(String[] args) {
        ListaCircularDupla lista =  new ListaCircularDupla();
        lista.adiciona(new Aluno("Alice"));
        lista.adiciona(new Aluno("Bob"));
        lista.adiciona(new Aluno("Charlie"));
        
        lista.imprimeLista();
        
        lista.removeDoComeco();
        lista.imprimeLista();
        
        System.out.println("Tamanho da lista: " + lista.tamanho());
    }
    
}
