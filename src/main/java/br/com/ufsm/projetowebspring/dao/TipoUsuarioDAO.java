package br.com.ufsm.projetowebspring.dao;

import br.com.ufsm.projetowebspring.models.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioDAO extends JpaRepository<TipoUsuario, Integer> {
}
