/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Infrastructure.DAO;

import controleestoque.Infrastructure.Repository.Database.DatabaseConnection;
import controleestoque.Infrastructure.Repository.Repository.ProdutoRepository;
import controleestoque.Domain.Produto;
import controleestoque.Infrastructure.Drivers.ConnectionFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author max.silva
 */
public class ProdutoDAO implements ProdutoRepository{
    
    private DatabaseConnection db = new ConnectionFactory();
    
    
    @Override
    public void criarProduto(Produto produto){
        Connection conn = db.getConnection();
        String sql = "INSERT INTO Produto (Name,Price,Description,IsActive,CreatedOn) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, produto.getName());
            stmt.setBigDecimal(2, produto.getPrice());
            stmt.setString(3, produto.getDescription());
            stmt.setBoolean(4, true);
            stmt.setTimestamp(5, produto.getCreatedOn());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Produto buscarPorId(Long Id){
        return null;
    }
    
    @Override
    public List<Produto> listarTodos(){
        return null;
    }
    
    @Override
    public void atualizarProduto(Produto produto){
        
    }
    
    @Override
    public void deletarProduto(Long Id){
        
    }
}
