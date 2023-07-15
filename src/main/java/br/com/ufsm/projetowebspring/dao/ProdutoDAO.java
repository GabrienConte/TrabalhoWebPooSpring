package br.com.ufsm.projetowebspring.dao;

import br.com.ufsm.projetowebspring.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

}
