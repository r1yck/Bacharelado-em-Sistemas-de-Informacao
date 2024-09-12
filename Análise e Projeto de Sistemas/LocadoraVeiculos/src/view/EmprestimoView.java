package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class EmprestimoView extends JFrame {
    private JButton listarVeiculosButton;
    private JButton realizarEmprestimoButton;
    private JButton listarEmprestimosButton;
    private JButton voltarButton;
    private JComboBox<String> veiculosComboBox;
    private JList<String> emprestimosList;

    public EmprestimoView() {
        setTitle("Empréstimo de Veículos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel para campos e botões
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245)); // Cor de fundo suave
        add(panel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Botão Listar Veículos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        listarVeiculosButton = new JButton("Listar Veículos");
        listarVeiculosButton.setFont(new Font("Arial", Font.PLAIN, 16));
        listarVeiculosButton.setBackground(new Color(0, 153, 255)); // Cor de fundo
        listarVeiculosButton.setForeground(Color.WHITE); // Cor do texto
        listarVeiculosButton.setFocusPainted(false);
        panel.add(listarVeiculosButton, gbc);

        // Botão Realizar Empréstimo
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        realizarEmprestimoButton = new JButton("Realizar Empréstimo");
        realizarEmprestimoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        realizarEmprestimoButton.setBackground(new Color(0, 153, 255)); // Cor de fundo
        realizarEmprestimoButton.setForeground(Color.WHITE); // Cor do texto
        realizarEmprestimoButton.setFocusPainted(false);
        panel.add(realizarEmprestimoButton, gbc);

        // Botão Listar Empréstimos
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        listarEmprestimosButton = new JButton("Listar Empréstimos");
        listarEmprestimosButton.setFont(new Font("Arial", Font.PLAIN, 16));
        listarEmprestimosButton.setBackground(new Color(0, 153, 255)); // Cor de fundo
        listarEmprestimosButton.setForeground(Color.WHITE); // Cor do texto
        listarEmprestimosButton.setFocusPainted(false);
        panel.add(listarEmprestimosButton, gbc);

        // Botão Voltar
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        voltarButton = new JButton("Sair");
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        voltarButton.setBackground(new Color(0, 153, 255)); // Cor de fundo
        voltarButton.setForeground(Color.WHITE); // Cor do texto
        voltarButton.setFocusPainted(false);
        panel.add(voltarButton, gbc);

        // ComboBox para veículos
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        veiculosComboBox = new JComboBox<>();
        veiculosComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        veiculosComboBox.setPreferredSize(new Dimension(400, 25));
        panel.add(veiculosComboBox, gbc);

        // Lista de empréstimos
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        emprestimosList = new JList<>();
        emprestimosList.setFont(new Font("Arial", Font.PLAIN, 16));
        emprestimosList.setVisibleRowCount(8);
        JScrollPane scrollPane = new JScrollPane(emprestimosList);
        panel.add(scrollPane, gbc);

        setVisible(true);
    }

    public void addListarVeiculosListener(ActionListener listener) {
        listarVeiculosButton.addActionListener(listener);
    }

    public void addRealizarEmprestimoListener(ActionListener listener) {
        realizarEmprestimoButton.addActionListener(listener);
    }

    public void addListarEmprestimosListener(ActionListener listener) {
        listarEmprestimosButton.addActionListener(listener);
    }

    public void addVoltarListener(ActionListener listener) {
        voltarButton.addActionListener(listener);
    }

    public String getSelectedVeiculo() {
        return (String) veiculosComboBox.getSelectedItem();
    }

    public void setVeiculos(List<String> veiculos) {
        veiculosComboBox.removeAllItems();
        for (String veiculo : veiculos) {
            veiculosComboBox.addItem(veiculo);
        }
        veiculosComboBox.setSelectedIndex(-1); // Nenhum item selecionado por padrão
    }

    public void setEmprestimos(List<String> emprestimos) {
        emprestimosList.setListData(emprestimos.toArray(new String[0]));
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
