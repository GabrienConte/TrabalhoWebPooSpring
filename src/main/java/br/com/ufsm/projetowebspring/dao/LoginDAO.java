package br.com.ufsm.projetowebspring.dao;

import br.com.ufsm.projetowebspring.dao.conexao.ConectaDB;
import br.com.ufsm.projetowebspring.models.TipoUsuario;
import br.com.ufsm.projetowebspring.models.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
    public Usuario getUsuarioByLogin(String login){
        StringBuilder sql = new StringBuilder();
        Usuario usuario = new Usuario();

        sql.append("SELECT * FROM usuario us WHERE us.login = '" + login  + "';");

        try (Connection conn = new ConectaDB().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            if(rs.next()) {
                usuario = ResultSetToObject(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    private Usuario ResultSetToObject(ResultSet rs) throws Exception {
        Usuario usuario = new Usuario();

        try {
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));

            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getInt("tipousuarioid"));
            usuario.setTipoUsuario(tipoUsuario);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }
}
