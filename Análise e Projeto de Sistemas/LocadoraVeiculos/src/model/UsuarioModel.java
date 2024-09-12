package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/LocadoraVeiculos";
        String user = "root";
        String password = "ifbaiano2024";
        return DriverManager.getConnection(url, user, password);
    }

    public boolean autenticar(String email, String senha) {
        String query = "SELECT * FROM Usuarios WHERE email = ? AND senha = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean registrar(String cpf, String nome, String email, String telefone, String senha) {
        String query1 = "INSERT INTO Clientes (cpf, nome, telefone) VALUES (?, ?, ?)";
        String query2 = "INSERT INTO Usuarios (email, senha, tipo) VALUES (?, ?, 'cliente')";

        try (Connection conn = connect();
             PreparedStatement stmt1 = conn.prepareStatement(query1);
             PreparedStatement stmt2 = conn.prepareStatement(query2)) {

            conn.setAutoCommit(false); // Início da transação

            // Inserir cliente
            stmt1.setString(1, cpf);
            stmt1.setString(2, nome);
            stmt1.setString(3, telefone);
            int rowsAffected1 = stmt1.executeUpdate();

            // Inserir usuário
            stmt2.setString(1, email);
            stmt2.setString(2, senha);
            int rowsAffected2 = stmt2.executeUpdate();

            if (rowsAffected1 > 0 && rowsAffected2 > 0) {
                conn.commit(); // Confirma a transação
                return true;
            } else {
                conn.rollback(); // Desfaz a transação se algo falhar
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAvailableVehicles() {
    List<String> veiculos = new ArrayList<>();
    String query = "SELECT modelo FROM Veiculos WHERE disponibilidade = TRUE";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            veiculos.add(rs.getString("modelo"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return veiculos;
}



    public boolean realizarEmprestimo(String veiculo) {
        String query = "INSERT INTO Emprestimos (cliente_id, veiculo_id, data_emprestimo, data_devolucao, valor, pagamento) "
                     + "SELECT c.id, v.id, NOW(), NULL, NULL, NULL "
                     + "FROM Clientes c, Veiculos v "
                     + "WHERE c.email = ? AND v.modelo = ? AND v.disponibilidade = TRUE";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Obter o email do cliente
            // Assumindo que o email está armazenado em uma variável de instância
            stmt.setString(1, "cliente@example.com"); // Substitua pelo email do cliente atual
            stmt.setString(2, veiculo);

            int rowsAffected = stmt.executeUpdate();

            // Atualizar a disponibilidade do veículo
            if (rowsAffected > 0) {
                String updateQuery = "UPDATE Veiculos SET disponibilidade = FALSE WHERE modelo = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, veiculo);
                    updateStmt.executeUpdate();
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
