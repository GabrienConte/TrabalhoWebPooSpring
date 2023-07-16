package br.com.ufsm.projetowebspring.dao;

import br.com.ufsm.projetowebspring.models.ItemPedido;
import br.com.ufsm.projetowebspring.models.Pedido;
import br.com.ufsm.projetowebspring.models.relatorios.RelatorioPedidosPorUsuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Integer> {

    @Query(value = "SELECT new br.com.ufsm.projetowebspring.models.relatorios.RelatorioPedidosPorUsuario(u.nome, pd.id, e.nome, pd.dataVenda, pd.total)\n" +
            "FROM Pedido pd\n" +
            "JOIN Usuario u ON pd.usuario.id = u.id\n" +
            "JOIN Entidade e ON pd.entidade.id = e.id\n" +
            "ORDER BY u.nome, pd.dataVenda")
    List<RelatorioPedidosPorUsuario> obterRelatorioPedidosPorUsuario();
}
