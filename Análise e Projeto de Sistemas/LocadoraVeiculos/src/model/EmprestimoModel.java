package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoModel {
    private Connection getConnection() throws SQLException {
        // Substitua pelos detalhes da sua conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/LocadoraVeiculos";
        String user = "root";
        String password = "ifbaiano2024";
        return DriverManager.getConnection(url, user, password);
    }
    
    public List<String> listarVeiculosDisponiveis() {
        List<String> veiculos = new ArrayList<>();
        String sql = "SELECT modelo FROM Veiculos WHERE disponibilidade = TRUE";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                veiculos.add(rs.getString("modelo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return veiculos;
    }
    
    public boolean realizarEmprestimo(String modeloVeiculo) {
        String sqlAtualizarDisponibilidade = "UPDATE Veiculos SET disponibilidade = FALSE WHERE modelo = ?";
        String sqlInserirEmprestimo = "INSERT INTO Emprestimos (cliente_id, veiculo_id, data_emprestimo) VALUES (?, (SELECT id FROM Veiculos WHERE modelo = ?), NOW())";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmtAtualizar = conn.prepareStatement(sqlAtualizarDisponibilidade);
             PreparedStatement pstmtInserir = conn.prepareStatement(sqlInserirEmprestimo)) {
            
            // Atualizar disponibilidade
            pstmtAtualizar.setString(1, modeloVeiculo);
            int rowsUpdated = pstmtAtualizar.executeUpdate();
            
            // Inserir emprestimo
            pstmtInserir.setInt(1, obterIdCliente()); // Método fictício para obter o ID do cliente
            pstmtInserir.setString(2, modeloVeiculo);
            pstmtInserir.executeUpdate();
            
            return rowsUpdated > 0; // Retorna true se a atualização foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false se ocorrer uma exceção
        }
    }
    
    public List<String> listarEmprestimos() {
        List<String> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM Emprestimos"; // Adapte esta consulta conforme necessário
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String emprestimo = "ID: " + rs.getInt("id") + ", Veículo ID: " + rs.getInt("veiculo_id") + ", Data Empréstimo: " + rs.getDate("data_emprestimo");
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return emprestimos;
    }
    
    private int obterIdCliente() {
        // Implementar lógica para obter o ID do cliente atual
        return 1; // Exemplo, substitua pelo método correto
    }
}
