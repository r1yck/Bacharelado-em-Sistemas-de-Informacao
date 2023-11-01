package fila_ex2;

public class Senha {

    private String tipo;
    private String prioridade;
    private int numero;

    //Construtor passando parametros
    public Senha(String t, String p, int n) {
        this.tipo = t;
        this.prioridade = p;
        this.numero = n;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the prioridade
     */
    public String getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        String ret = "\n"
                + "Tipo: " + tipo + "\n"
                + "Prior.: " + prioridade + "\n"
                + "Nº:" + numero;

        return ret;
    }

    public boolean isPrioritaria() {
        return "Prioritário".equals(this.prioridade);
    }

}
