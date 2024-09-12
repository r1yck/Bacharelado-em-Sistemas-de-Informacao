package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private JButton voltarButton;

    public LoginView() {
        // Configuração da interface gráfica
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout());

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave

        // Cabeçalho
        JLabel headerLabel = new JLabel("Login", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(new Color(0, 102, 204)); // Cor do texto do cabeçalho
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Painel para campos de texto e botões
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Label e campo de email
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        emailField = new JTextField(15);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        centerPanel.add(emailField, gbc);

        // Label e campo de senha
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        centerPanel.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        senhaField = new JPasswordField(15);
        senhaField.setFont(new Font("Arial", Font.PLAIN, 16));
        centerPanel.add(senhaField, gbc);

        // Botões de login e voltar
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaçamento superior e inferior

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.setBackground(new Color(0, 153, 255)); // Cor de fundo do botão
        loginButton.setForeground(Color.WHITE); // Cor do texto do botão
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borda arredondada
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o cursor ao passar sobre o botão

        voltarButton = new JButton("Voltar");
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 18));
        voltarButton.setBackground(new Color(0, 153, 255)); // Cor de fundo do botão
        voltarButton.setForeground(Color.WHITE); // Cor do texto do botão
        voltarButton.setFocusPainted(false);
        voltarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borda arredondada
        voltarButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o cursor ao passar sobre o botão

        buttonPanel.add(Box.createHorizontalStrut(20)); // Espaçamento horizontal
        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createHorizontalStrut(10)); // Espaçamento horizontal
        buttonPanel.add(voltarButton);

        centerPanel.add(buttonPanel, gbc);

        // Adiciona o painel central ao painel principal
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Adiciona o painel principal ao JFrame
        add(mainPanel);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getSenha() {
        return new String(senhaField.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void addVoltarListener(ActionListener listener) {
        voltarButton.addActionListener(listener);
    }

    public void loginSuccess() {
        JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
    }

    public void loginFailed() {
        JOptionPane.showMessageDialog(this, "Falha no login. Tente novamente.");
    }
}
