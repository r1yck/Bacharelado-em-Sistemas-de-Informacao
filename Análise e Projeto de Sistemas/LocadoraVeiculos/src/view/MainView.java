package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JButton loginButton;
    private JButton registerButton;

    public MainView() {
        // Configuração da interface gráfica
        setTitle("Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Painel principal com BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave

        // Cabeçalho
        JLabel headerLabel = new JLabel("Locadora de Veiculos", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(new Color(0, 102, 204)); // Cor do texto do cabeçalho
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Painel central para os botões com BoxLayout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave

        // Botão de Login
        loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.setBackground(new Color(0, 153, 255)); // Cor de fundo do botão
        loginButton.setForeground(Color.WHITE); // Cor do texto do botão
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borda arredondada
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o cursor ao passar sobre o botão

        // Botão de Registro
        registerButton = new JButton("Registrar");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        registerButton.setBackground(new Color(0, 153, 255)); // Cor de fundo do botão
        registerButton.setForeground(Color.WHITE); // Cor do texto do botão
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borda arredondada
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o cursor ao passar sobre o botão

        // Adiciona espaçamento e os botões ao painel central
        centerPanel.add(Box.createVerticalStrut(30)); // Espaçamento superior
        centerPanel.add(loginButton);
        centerPanel.add(Box.createVerticalStrut(20)); // Espaçamento entre botões
        centerPanel.add(registerButton);
        centerPanel.add(Box.createVerticalStrut(30)); // Espaçamento inferior

        // Adiciona o painel central ao centro do painel principal
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Adiciona o painel principal ao JFrame
        add(mainPanel);
    }

    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void addRegisterButtonListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }
}
