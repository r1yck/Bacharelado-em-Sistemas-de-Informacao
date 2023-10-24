package pilha_ex1;

public class Peca {

    private String nome;
    
    public Peca(String no){
        nome = no;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString() {
        return this.nome;
    }

}
