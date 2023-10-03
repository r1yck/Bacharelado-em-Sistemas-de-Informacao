package listacirculardupla;


public class CelulaCircularDupla {
    
    private CelulaCircularDupla proxima;
    private CelulaCircularDupla anterior;
    private Aluno aluno;
    
    public CelulaCircularDupla(Aluno aluno) {
        this.aluno = aluno;
    }

    public CelulaCircularDupla getProxima() {
        return proxima;
    }

    public void setProxima(CelulaCircularDupla proxima) {
        this.proxima = proxima;
    }

    public CelulaCircularDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaCircularDupla anterior) {
        this.anterior = anterior;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
