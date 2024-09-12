package app;

import controller.LoginController;
import controller.EmprestimoController;
import model.UsuarioModel;
import model.EmprestimoModel;
import view.LoginView;
import view.MainView;
import view.RegistroView;
import view.EmprestimoView;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // Criação das views
            MainView mainView = new MainView();
            LoginView loginView = new LoginView();
            RegistroView registroView = new RegistroView();
            EmprestimoView emprestimoView = new EmprestimoView();

            // Criação dos modelos
            UsuarioModel usuarioModel = new UsuarioModel();
            EmprestimoModel emprestimoModel = new EmprestimoModel();

            // Criação dos controladores
            LoginController loginController = new LoginController(loginView, usuarioModel, mainView, emprestimoView);
            EmprestimoController emprestimoController = new EmprestimoController(emprestimoModel, emprestimoView);

            // Configuração dos listeners da MainView
            mainView.addLoginButtonListener(e -> {
                mainView.setVisible(false);
                loginView.setVisible(true);
            });

            mainView.addRegisterButtonListener(e -> {
                mainView.setVisible(false);
                registroView.setVisible(true);
            });

            // Configuração dos listeners da LoginView
            loginView.addLoginListener(e -> {
                // A lógica de login já está no LoginController
            });

            loginView.addVoltarListener(e -> {
                loginView.setVisible(false);
                mainView.setVisible(true);
            });

            // Configuração dos listeners da RegistroView
            registroView.addRegisterListener(e -> {
                String cpf = registroView.getCpf();
                String nome = registroView.getNome();
                String email = registroView.getEmail();
                String telefone = registroView.getTelefone();
                String senha = registroView.getSenha();

                boolean sucesso = usuarioModel.registrar(cpf, nome, email, telefone, senha);

                if (sucesso) {
                    JOptionPane.showMessageDialog(registroView, "Registro bem-sucedido!");
                    registroView.setVisible(false);
                    mainView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(registroView, "Falha no registro. Tente novamente.");
                }
            });

            registroView.addVoltarListener(e -> {
                registroView.setVisible(false);
                mainView.setVisible(true);
            });

            // Configuração dos listeners da EmprestimoView
            emprestimoView.addListarVeiculosListener(e -> emprestimoController.listarVeiculos());
            emprestimoView.addListarEmprestimosListener(e -> emprestimoController.listarEmprestimos());
            emprestimoView.addVoltarListener(e -> {
                emprestimoView.setVisible(false);
                mainView.setVisible(true); // Ou outra tela adequada
            });

            // Exibição da tela principal
            mainView.setVisible(true);

            // Assegure-se de que outras views não sejam visíveis inicialmente
            loginView.setVisible(false);
            registroView.setVisible(false);
            emprestimoView.setVisible(false);
        });
    }
}
