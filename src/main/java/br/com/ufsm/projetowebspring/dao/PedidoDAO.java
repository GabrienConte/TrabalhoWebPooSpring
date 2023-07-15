package br.com.ufsm.projetowebspring.dao;

import br.com.ufsm.projetowebspring.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Integer> {

}
