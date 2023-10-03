package listaligadasimples;

public class Celula {
    
    private Celula proxima;
    private Aluno aluno;
    
    public Celula(Aluno aluno) {
        this.aluno = aluno;
    }

    public Celula getProxima() {
        return proxima;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }

    public Aluno getAluno() {
        return aluno;
    }
    
}
