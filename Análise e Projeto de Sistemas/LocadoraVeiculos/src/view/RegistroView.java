package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistroView extends JFrame {
    private JTextField tfCpf;
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfTelefone;
    private JPasswordField tfSenha;
    private JButton btnRegistrar;
    private JButton btnVoltar;

    public RegistroView() {
        setTitle("Registro de Usuário");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave

        // Cabeçalho
        JLabel headerLabel = new JLabel("Registro de Usuário", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(new Color(0, 102, 204)); // Cor do texto do cabeçalho
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Painel para campos de texto e botões
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Label e campo de CPF
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(new JLabel("CPF:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        tfCpf = new JTextField(20);
        tfCpf.setFont(new Font("Arial", Font.PLAIN, 16));
        centerPanel.add(tfCpf, gbc);

        // Label e campo de Nome
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        centerPanel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        tfNome = new JTextField(20);
        tfNome.setFont(new Font("Arial", Font.PLAIN, 16));
        centerPanel.add(tfNome, gbc);

        // Label e campo de Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        tfEmail = new JTextField(20);
        tfEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        centerPanel.add(tfEmail, gbc);

        // Label e campo de Telefone
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        tfTelefone = new JTextField(20);
        tfTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
        centerPanel.add(tfTelefone, gbc);

        // Label e campo de Senha
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        tfSenha = new JPasswordField(20);
        tfSenha.setFont(new Font("Arial", Font.PLAIN, 16));
        centerPanel.add(tfSenha, gbc);

        // Botões de registrar e voltar
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaçamento superior e inferior

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnRegistrar.setBackground(new Color(0, 153, 255)); // Cor de fundo do botão
        btnRegistrar.setForeground(Color.WHITE); // Cor do texto do botão
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borda arredondada
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o cursor ao passar sobre o botão

        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVoltar.setBackground(new Color(0, 153, 255)); // Cor de fundo do botão
        btnVoltar.setForeground(Color.WHITE); // Cor do texto do botão
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borda arredondada
        btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o cursor ao passar sobre o botão

        buttonPanel.add(Box.createHorizontalStrut(20)); // Espaçamento horizontal
        buttonPanel.add(btnRegistrar);
        buttonPanel.add(Box.createHorizontalStrut(10)); // Espaçamento horizontal
        buttonPanel.add(btnVoltar);

        centerPanel.add(buttonPanel, gbc);

        // Adiciona o painel central ao painel principal
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Adiciona o painel principal ao JFrame
        add(mainPanel);
    }

    public String getCpf() {
        return tfCpf.getText();
    }

    public String getNome() {
        return tfNome.getText();
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public String getTelefone() {
        return tfTelefone.getText();
    }

    public String getSenha() {
        return new String(tfSenha.getPassword());
    }

    public void addRegisterListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    public void addVoltarListener(ActionListener listener) {
        btnVoltar.addActionListener(listener);
    }
}
