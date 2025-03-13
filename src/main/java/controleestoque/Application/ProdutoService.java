/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Application;

import controleestoque.Domain.Produto;
import controleestoque.Infrastructure.DAO.ProdutoDAO;
import controleestoque.Infrastructure.Interface.Repository.ProdutoRepository;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 *
 * @author max.silva
 */
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository ProdutoRepository){
        this.produtoRepository = new ProdutoDAO();
    }
    
    public void criarProduto(String Nome, BigDecimal Price, String Description){
        Produto produto = new Produto(null,Nome,Price,Description,true,Timestamp.from(Instant.now()),null);
        produtoRepository.criarProduto(produto);
    }
    
    public Produto buscarPorId(Long Id){
        return produtoRepository.buscarPorId(Id);
    }
    
    public List<Produto> listarTodos(){
        return produtoRepository.listarTodos();
    }
    
    public void atualizarProduto(Long Id, String Name, BigDecimal Price, String Description){
        Produto produto = produtoRepository.buscarPorId(Id);
        if(produto != null){
            produto.setName(Name);
            produto.setPrice(Price);
            produto.setDescription(Description);
            produtoRepository.atualizarProduto(produto);
        }
    }
    
    public void deletarProduto(Long Id){
        produtoRepository.deletarProduto(Id);
    }
    
}
