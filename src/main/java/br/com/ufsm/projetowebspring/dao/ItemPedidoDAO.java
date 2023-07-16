package br.com.ufsm.projetowebspring.dao;


import br.com.ufsm.projetowebspring.models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoDAO extends JpaRepository<ItemPedido, Integer> {
    List<ItemPedido> findAllByPedidoId(final int pedidoId);

    List<ItemPedido> findAllByProdutoId(final int produtoId);

    @Query("SELECT SUM(ip.total) FROM ItemPedido ip WHERE ip.pedido.id = :pedidoId")
    Float selectTotals(@Param("pedidoId") int pedidoId);
}
