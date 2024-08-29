package controller;

import view.EmprestimoView;
import model.Veiculo;
import model.Cliente;
import model.Emprestimo;

import java.util.Date;

public class EmprestimoController {
    private EmprestimoView emprestimoView;

    public EmprestimoController(EmprestimoView emprestimoView) {
        this.emprestimoView = emprestimoView;
    }

    public void registrarEmprestimo() {
        String nomeCliente = emprestimoView.getNomeCliente();
        String documentoCliente = emprestimoView.getDocumentoCliente();
        String modeloVeiculo = emprestimoView.getModeloVeiculo();
        String placaVeiculo = emprestimoView.getPlacaVeiculo();

        Cliente cliente = new Cliente(nomeCliente, documentoCliente);
        Veiculo veiculo = new Veiculo(modeloVeiculo, placaVeiculo);

        if (veiculo.isDisponivel()) {
            veiculo.setDisponivel(false);
            Emprestimo emprestimo = new Emprestimo(veiculo, cliente, new Date(), null);
            emprestimoView.exibirMensagem("Empréstimo registrado com sucesso para " + cliente.getNome());
        } else {
            emprestimoView.exibirMensagem("Veículo não disponível.");
        }
    }
}
