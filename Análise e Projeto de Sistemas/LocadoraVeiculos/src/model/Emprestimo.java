package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private BigDecimal valor;
    private String pagamento;

    // Construtor completo
    public Emprestimo(int id, Cliente cliente, Veiculo veiculo, LocalDate dataEmprestimo, 
                      LocalDate dataDevolucao, BigDecimal valor, String pagamento) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        this.pagamento = pagamento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }
        this.valor = valor;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", valor=" + valor +
                ", pagamento='" + pagamento + '\'' +
                '}';
    }
}
