package br.com.ufsm.projetowebspring.dao;


import br.com.ufsm.projetowebspring.models.Entidade;
import br.com.ufsm.projetowebspring.models.relatorios.RelatorioVendasPorEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadeDAO extends JpaRepository<Entidade, Integer> {
    @Query(value = "SELECT new br.com.ufsm.projetowebspring.models.relatorios.RelatorioVendasPorEntidade(e.nome, e.cpf, e.telefone, COUNT(p.id), SUM(pd.total))\n" +
            "FROM Entidade e\n" +
            "JOIN Pedido pd ON e.id = pd.entidade.id\n" +
            "JOIN Usuario u ON pd.usuario.id = u.id\n" +
            "JOIN ItemPedido ip ON pd.id = ip.pedido.id\n" +
            "JOIN Produto p ON ip.produto.id = p.id\n" +
            "GROUP BY e.id\n" +
            "ORDER BY SUM(pd.total) DESC")
    List<RelatorioVendasPorEntidade> obterRelatoriovendasPorEntidade();
}
