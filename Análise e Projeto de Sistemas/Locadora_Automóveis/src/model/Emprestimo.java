package model;

import java.util.Date;

public class Emprestimo {
    private Veiculo veiculo;
    private Cliente cliente;
    private Date dataEmprestimo;
    private Date dataDevolucaoPrevista;

    public Emprestimo(Veiculo veiculo, Cliente cliente, Date dataEmprestimo, Date dataDevolucaoPrevista) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }
}
