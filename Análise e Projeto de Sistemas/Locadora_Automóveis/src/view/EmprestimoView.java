package view;

import javax.swing.*;
import controller.EmprestimoController;

public class EmprestimoView extends JFrame {
    private JTextField txtNomeCliente;
    private JTextField txtDocumentoCliente;
    private JTextField txtModeloVeiculo;
    private JTextField txtPlacaVeiculo;
    private JButton btnEmprestar;
    private EmprestimoController emprestimoController;

    public EmprestimoView() {
        emprestimoController = new EmprestimoController(this);
        setTitle("Empréstimo de Veículo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
        lblNomeCliente.setBounds(20, 30, 150, 25);
        add(lblNomeCliente);

        txtNomeCliente = new JTextField();
        txtNomeCliente.setBounds(180, 30, 160, 25);
        add(txtNomeCliente);

        JLabel lblDocumentoCliente = new JLabel("Documento:");
        lblDocumentoCliente.setBounds(20, 70, 150, 25);
        add(lblDocumentoCliente);

        txtDocumentoCliente = new JTextField();
        txtDocumentoCliente.setBounds(180, 70, 160, 25);
        add(txtDocumentoCliente);

        JLabel lblModeloVeiculo = new JLabel("Modelo do Veículo:");
        lblModeloVeiculo.setBounds(20, 110, 150, 25);
        add(lblModeloVeiculo);

        txtModeloVeiculo = new JTextField();
        txtModeloVeiculo.setBounds(180, 110, 160, 25);
        add(txtModeloVeiculo);

        JLabel lblPlacaVeiculo = new JLabel("Placa do Veículo:");
        lblPlacaVeiculo.setBounds(20, 150, 150, 25);
        add(lblPlacaVeiculo);

        txtPlacaVeiculo = new JTextField();
        txtPlacaVeiculo.setBounds(180, 150, 160, 25);
        add(txtPlacaVeiculo);

        btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(150, 200, 100, 25);
        btnEmprestar.addActionListener(e -> emprestimoController.registrarEmprestimo());
        add(btnEmprestar);
        
        // Tornar a janela visível
        setVisible(true);
    }

    public String getNomeCliente() {
        return txtNomeCliente.getText();
    }

    public String getDocumentoCliente() {
        return txtDocumentoCliente.getText();
    }

    public String getModeloVeiculo() {
        return txtModeloVeiculo.getText();
    }

    public String getPlacaVeiculo() {
        return txtPlacaVeiculo.getText();
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
