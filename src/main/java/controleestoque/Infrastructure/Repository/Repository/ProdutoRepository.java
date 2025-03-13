/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Infrastructure.Repository.Repository;

import controleestoque.Domain.Produto;
import java.util.List;

/**
 *
 * @author max.silva
 */
public interface ProdutoRepository {
    void criarProduto(Produto produto);
    Produto buscarPorId(Long id);
    List<Produto> listarTodos();
    void atualizarProduto(Produto produto);
    void deletarProduto(Long Id);
}
