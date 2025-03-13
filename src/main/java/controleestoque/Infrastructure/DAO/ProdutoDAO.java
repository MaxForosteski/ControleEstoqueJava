/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Infrastructure.DAO;

import controleestoque.Infrastructure.Interface.Database.DatabaseConnection;
import controleestoque.Infrastructure.Interface.Repository.ProdutoRepository;
import controleestoque.Domain.Produto;
import controleestoque.Infrastructure.Drivers.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max.silva
 */
public class ProdutoDAO implements ProdutoRepository {

    private final DatabaseConnection db = new ConnectionFactory();

    @Override
    public void criarProduto(Produto produto) {

        String sql = "INSERT INTO Produto (Name,Price,Description,IsActive,CreatedOn) VALUES (?,?,?,?,?)";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getName());
            stmt.setBigDecimal(2, produto.getPrice());
            stmt.setString(3, produto.getDescription());
            stmt.setBoolean(4, true);
            stmt.setTimestamp(5, produto.getCreatedOn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto buscarPorId(Long Id) {
        String sql = "SELECT * FROM Produto WHERE id = ? AND IsActive = 1";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getLong("Id"),
                        rs.getString("Name"),
                        rs.getBigDecimal("Price"),
                        rs.getString("Description"),
                        rs.getBoolean("IsActive"),
                        rs.getTimestamp("CreatedOn"),
                        rs.getTimestamp("UpdatedOn")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produtos WHERE IsActive = 1";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getLong("Id"),
                        rs.getString("Name"),
                        rs.getBigDecimal("Price"),
                        rs.getString("Description"),
                        rs.getBoolean("IsActive"),
                        rs.getTimestamp("CreatedOn"),
                        rs.getTimestamp("UpdatedOn")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE Produto SET Name = ?, Price = ?, Description = ?, UpdatedOn = ? WHERE Id = ?";
        try(Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, produto.getName());
            stmt.setBigDecimal(2, produto.getPrice());
            stmt.setString(3, produto.getDescription());
            stmt.setTimestamp(4, produto.getUpdatedOn());
            stmt.setLong(5, produto.getId());
            
            stmt.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deletarProduto(Long Id) {
        String sql = "UPDATE Produto IsActive = 0 WHERE Id = ?";
        try(Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, Id);
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
