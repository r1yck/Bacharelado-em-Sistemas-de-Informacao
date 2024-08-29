package controller;

import view.LoginView;
import view.EmprestimoView;
import model.Usuario;

public class LoginController {
    private LoginView loginView;
    private Usuario usuario;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        // Usuário exemplo (substituir por acesso ao banco de dados)
        this.usuario = new Usuario("admin", "123", "gerente");
    }

    public void autenticar() {
        String username = loginView.getUsername();
        String senha = loginView.getSenha();
        
        if (usuario.autenticar(username, senha)) {
            loginView.exibirMensagem("Login realizado com sucesso!");
            
            // Abrir a janela de empréstimo
            new EmprestimoView(); // Cria a nova instância da janela de empréstimo
            
            // Fechar a janela de login
            loginView.dispose(); // Fecha a janela de login
        } else {
            loginView.exibirMensagem("Usuário ou senha inválidos.");
        }
    }
}
