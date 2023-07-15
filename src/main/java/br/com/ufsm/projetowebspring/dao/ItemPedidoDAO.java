package br.com.ufsm.projetowebspring.dao;


import br.com.ufsm.projetowebspring.models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoDAO extends JpaRepository<ItemPedido, Integer> {

}
