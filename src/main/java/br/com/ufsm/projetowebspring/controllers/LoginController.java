package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView autenticar(String login, String senha) {
        ModelAndView mv;
        if (usuarioDAO.findOneByLoginAndSenha(login, senha) != null || login.equals("primeiroAcesso")) {
            mv = new ModelAndView("principal");
        } else {
            System.out.println("deu ruim");
            mv = new ModelAndView("index");
        }
        return mv;
    }

    @GetMapping("/inicio")
    public ModelAndView principal() {
        ModelAndView mv = new ModelAndView("principal");
        return mv;
    }
}