package model;

public class Cliente {
    private int id;
    private String cpf;
    private String nome;
    private String telefone;
    private boolean habilitacaoValida;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isHabilitacaoValida() {
        return habilitacaoValida;
    }

    public void setHabilitacaoValida(boolean habilitacaoValida) {
        this.habilitacaoValida = habilitacaoValida;
    }
    
}
