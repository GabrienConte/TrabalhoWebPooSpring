package br.com.ufsm.projetowebspring.dao;


import br.com.ufsm.projetowebspring.models.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeDAO extends JpaRepository<Entidade, Integer> {

}
