package listaligadadupla;

public class ListaLigadaDupla {
   
    private CelulaDupla primeira;
    private CelulaDupla ultima;
    private int totalDeElementos = 0;
    
    public void adiciona(Aluno aluno) {
        CelulaDupla nova = new CelulaDupla(aluno);
        // Lista vazia
        if (this.totalDeElementos == 0) {
            this.primeira = nova;
            this.ultima = nova;
        } else { // Lista com elementos
            nova.setAnterior(this.ultima);
            this.ultima.setProxima(nova);
            this.ultima = nova;
        }
        this.totalDeElementos++;
    }
    
    public void removeDoComeco(){
        if (this.totalDeElementos == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        this.primeira = this.primeira.getProxima();
        if (this.primeira != null) {
            this.primeira.setAnterior(null);
        }
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }
    
    public void imprimeLista() {
        StringBuilder builder = new StringBuilder();
        CelulaDupla atual = this.primeira;
        
        builder.append("[");
        while (atual != null) {
        builder.append(" ").append(atual.getAluno()).append(" ");
        atual = atual.getProxima();
    }
        builder.append("]");
        System.out.println(builder.toString());
    }
    
    public int tamanho() {
        return this.totalDeElementos;
    }
    
    public static void main(String[] args) {
        ListaLigadaDupla lista =  new ListaLigadaDupla();
        lista.adiciona(new Aluno("Alice"));
        lista.adiciona(new Aluno("Bob"));
        lista.adiciona(new Aluno("Charlie"));
        
        lista.imprimeLista();
        
        lista.removeDoComeco();
        lista.imprimeLista();
        
        System.out.println("Tamanho da lista: " + lista.tamanho());
    }
}
