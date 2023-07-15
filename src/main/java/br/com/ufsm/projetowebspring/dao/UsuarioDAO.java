package br.com.ufsm.projetowebspring.dao;


import br.com.ufsm.projetowebspring.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

}
