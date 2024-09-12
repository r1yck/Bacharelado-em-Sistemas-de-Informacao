package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UsuarioModel;
import view.LoginView;
import view.MainView;
import view.EmprestimoView; // Adicione a referência para a EmprestimoView

public class LoginController implements ActionListener {
    private LoginView view;
    private UsuarioModel model;
    private MainView mainView;
    private EmprestimoView emprestimoView; // Adicione a referência para a EmprestimoView

    public LoginController(LoginView view, UsuarioModel model, MainView mainView, EmprestimoView emprestimoView) {
        this.view = view;
        this.model = model;
        this.mainView = mainView;
        this.emprestimoView = emprestimoView; // Inicialize a EmprestimoView
        this.view.addLoginListener(this);
        this.view.addVoltarListener(e -> {
            view.setVisible(false); // Esconde a tela de login
            mainView.setVisible(true); // Mostra a tela principal
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = view.getEmail();
        String senha = view.getSenha();

        if (model.autenticar(email, senha)) {
            view.loginSuccess();
            view.setVisible(false); // Esconde a tela de login
            emprestimoView.setVisible(true); // Mostra a tela de empréstimo
        } else {
            view.loginFailed();
        }
    }
}
