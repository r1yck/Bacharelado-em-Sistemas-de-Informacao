package controller;

import model.EmprestimoModel;
import view.EmprestimoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmprestimoController {
    private EmprestimoModel model;
    private EmprestimoView view;

    public EmprestimoController(EmprestimoModel model, EmprestimoView view) {
        this.model = model;
        this.view = view;

        // Adiciona os listeners de ação aos botões da view
        this.view.addListarVeiculosListener(new ListarVeiculosListener());
        this.view.addRealizarEmprestimoListener(new RealizarEmprestimoListener());
        this.view.addListarEmprestimosListener(new ListarEmprestimosListener());
    }

    // Método para listar veículos disponíveis
    public void listarVeiculos() {
        List<String> veiculos = model.listarVeiculosDisponiveis();
        view.setVeiculos(veiculos);
    }

    // Método para realizar empréstimo
    public void realizarEmprestimo() {
        String veiculoSelecionado = view.getSelectedVeiculo();
        
        // Verifica se um veículo foi selecionado
        if (veiculoSelecionado != null && !veiculoSelecionado.isEmpty()) {
            boolean sucesso = model.realizarEmprestimo(veiculoSelecionado);
            if (sucesso) {
                // Atualize a lista de veículos e empréstimos após realizar o empréstimo
                listarVeiculos(); // Atualiza a lista de veículos disponíveis
                listarEmprestimos(); // Atualiza a lista de empréstimos
                
                view.exibirMensagem("Empréstimo realizado com sucesso!");
            } else {
                view.exibirMensagem("Falha ao realizar o empréstimo. Tente novamente.");
            }
        } else {
            view.exibirMensagem("Nenhum veículo selecionado.");
        }
    }

    // Método para listar empréstimos
    public void listarEmprestimos() {
        List<String> emprestimos = model.listarEmprestimos();
        view.setEmprestimos(emprestimos);
    }

    // Classe interna para o listener de listar veículos
    class ListarVeiculosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listarVeiculos();
        }
    }

    // Classe interna para o listener de realizar empréstimo
    class RealizarEmprestimoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarEmprestimo();
        }
    }

    // Classe interna para o listener de listar empréstimos
    class ListarEmprestimosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listarEmprestimos();
        }
    }
}
