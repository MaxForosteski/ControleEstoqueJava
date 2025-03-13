package controleestoque;

import controleestoque.Application.ProdutoService;
import controleestoque.Infrastructure.DAO.ProdutoDAO;
import controleestoque.Infrastructure.Interface.Repository.ProdutoRepository;
import controleestoque.Domain.Produto;

import java.math.BigDecimal;
import java.util.List;

public class Controleestoque {
    public static void main(String[] args) {
        // Criando instância do repositório (simulação de dependência)
        ProdutoRepository produtoRepository = new ProdutoDAO();
        
        // Criando o serviço com o repositório
        ProdutoService produtoService = new ProdutoService(produtoRepository);

        // Criar Produto
        System.out.println("Criando produto...");
        produtoService.criarProduto("Caderno", new BigDecimal("15.90"), "Caderno 200 folhas");
        produtoService.criarProduto("Caneta", new BigDecimal("3.50"), "Caneta azul esferográfica");

        // Listar Produtos
        System.out.println("\nListando produtos...");
        List<Produto> produtos = produtoService.listarTodos();
        for (Produto p : produtos) {
            System.out.println(p);
        }

        // Buscar Produto pelo ID
        if (!produtos.isEmpty()) {
            Long idProduto = produtos.get(0).getId();
            System.out.println("\nBuscando produto com ID: " + idProduto);
            Produto produtoEncontrado = produtoService.buscarPorId(idProduto);
            System.out.println("Produto encontrado: " + produtoEncontrado);

            // Atualizar Produto
            System.out.println("\nAtualizando produto...");
            produtoService.atualizarProduto(idProduto, "Caderno Universitário", new BigDecimal("20.00"), "Caderno capa dura 200 folhas");

            // Buscar novamente para ver atualização
            System.out.println("Produto atualizado: " + produtoService.buscarPorId(idProduto));

            // Deletar Produto
            System.out.println("\nDeletando produto com ID: " + idProduto);
            produtoService.deletarProduto(idProduto);
            System.out.println("Produto deletado!");
        }

        // Listar novamente após deletar
        System.out.println("\nLista final de produtos:");
        produtos = produtoService.listarTodos();
        for (Produto p : produtos) {
            System.out.println(p);
        }

        System.out.println("\nFim dos testes!");
    }
}
