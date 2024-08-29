package model;

public class Usuario {
    private String username;
    private String senha;
    private String tipo; // "funcionario" ou "gerente"

    public Usuario(String username, String senha, String tipo) {
        this.username = username;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean autenticar(String username, String senha) {
        return this.username.equals(username) && this.senha.equals(senha);
    }
}
