package controller;

import model.UsuarioModel;
import view.RegistroView;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegistroController {
    private RegistroView view;
    private UsuarioModel model;
    private MainView mainView;

    public RegistroController(RegistroView view, UsuarioModel model, MainView mainView) {
        this.view = view;
        this.model = model;
        this.mainView = mainView;
        this.view.addRegisterListener(new RegisterListener());
        this.view.addVoltarListener(new VoltarListener());
    }

    private class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpf = view.getCpf();
            String nome = view.getNome();
            String email = view.getEmail();
            String telefone = view.getTelefone();
            String senha = view.getSenha();

            boolean success = model.registrar(cpf, nome, email, telefone, senha);
            if (success) {
                JOptionPane.showMessageDialog(null, "Registro bem-sucedido!");
                view.dispose();
                mainView.setVisible(true); // Volta para a tela principal
            } else {
                JOptionPane.showMessageDialog(null, "Falha no registro. Tente novamente.");
            }
        }
    }

    private class VoltarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Fecha a tela de registro
            mainView.setVisible(true); // Mostra a tela principal
        }
    }
}
