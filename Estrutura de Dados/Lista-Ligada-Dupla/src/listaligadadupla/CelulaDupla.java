package listaligadadupla;


public class CelulaDupla {
   
    private CelulaDupla proxima;
    private CelulaDupla anterior;
    private Aluno aluno;
    
    public CelulaDupla (Aluno aluno) {
        this.aluno = aluno;
    }

    public CelulaDupla getProxima() {
        return proxima;
    }

    public void setProxima(CelulaDupla proxima) {
        this.proxima = proxima;
    }

    public CelulaDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaDupla anterior) {
        this.anterior = anterior;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
