/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Adapters.Repository;

import controleestoque.Domain.Produto;
import java.util.List;

/**
 *
 * @author max.silva
 */
public interface ProdutoRepository {
    void criarProduto();
    Produto buscarPorId(Long id);
    List<Produto> ListarTodos();
    void atualizarProduto(Produto produto);
    void deletarProduto(Long Id);
}
