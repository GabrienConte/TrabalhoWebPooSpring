package br.com.ufsm.projetowebspring.services;


import br.com.ufsm.projetowebspring.dao.LoginDAO;
import br.com.ufsm.projetowebspring.models.Usuario;

public class LoginService {

    public boolean autenticar(String login, String senha){
        Usuario teste = new LoginDAO().getUsuarioByLogin(login);

        if(teste.getLogin() != null && senha.equals(teste.getSenha()))
        {
            return true;
        }else {
            return false;
        }
    }
}
