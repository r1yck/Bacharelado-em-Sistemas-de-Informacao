package view;

import javax.swing.*;
import controller.LoginController;

public class LoginView extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private LoginController loginController;

    public LoginView() {
        loginController = new LoginController(this);
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsername = new JLabel("Usuário:");
        lblUsername.setBounds(20, 30, 80, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(100, 30, 160, 25);
        add(txtUsername);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 70, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 70, 160, 25);
        add(txtSenha);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 110, 80, 25);
        btnLogin.addActionListener(e -> loginController.autenticar());
        add(btnLogin);
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getSenha() {
        return new String(txtSenha.getPassword());
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    // Método principal (main) para iniciar o programa
    public static void main(String[] args) {
        // Cria e exibe a interface de login
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}
