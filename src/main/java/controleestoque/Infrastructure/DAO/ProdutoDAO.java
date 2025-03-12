/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Infrastructure.DAO;

import controleestoque.Adapters.Database.DatabaseConnection;
import controleestoque.Adapters.Repository.ProdutoRepository;
import controleestoque.Domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author max.silva
 */
public class ProdutoDAO /*implements ProdutoRepository*/{
    
    /*@Override
    public void criarProduto(Produto produto){
        String sql = "INSERT INTO Produto (Name,Price,Description,IsActive,CreatedOn) VALUES (?,?,?,?,?)";
        try(Database conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }*/
}
