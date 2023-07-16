package br.com.ufsm.projetowebspring.dao;

import br.com.ufsm.projetowebspring.models.Produto;
import br.com.ufsm.projetowebspring.models.relatorios.RelatorioProdutosMaisVendidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

    @Query(value = "SELECT new br.com.ufsm.projetowebspring.models.relatorios.RelatorioProdutosMaisVendidos(p.descricao , p.marca, SUM(ip.quantidade))\n" +
            "            FROM Produto p\n" +
            "            JOIN ItemPedido ip ON p.id = ip.produto.id\n" +
            "            GROUP BY p.id\n" +
            "            ORDER BY SUM(ip.quantidade) DESC")
    List<RelatorioProdutosMaisVendidos> obterRelatorioProdutosMaisVendidos();
}
