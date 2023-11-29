package listadesenhas;

public class Senha {
    private String aplicativo;
    private String senha;

    public Senha(String aplicativo, String senha) {
        this.aplicativo = aplicativo;
        this.senha = senha;
    }

    public String getAplicativo() {
        return aplicativo;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Aplicativo: " + aplicativo + ", Senha: " + senha;
    }
}

