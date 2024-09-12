package model;

public class Veiculo {
    private int id;
    private String modelo;
    private String placa;
    private boolean disponibilidade;

    public Veiculo(int id, String modelo, String placa, boolean disponibilidade) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.disponibilidade = disponibilidade;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Veiculo{id=" + id + ", modelo='" + modelo + "', placa='" + placa + "', disponibilidade=" + disponibilidade + "}";
    }
}
