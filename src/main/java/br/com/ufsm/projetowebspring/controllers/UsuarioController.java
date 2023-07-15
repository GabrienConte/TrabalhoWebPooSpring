package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.TipoUsuarioDAO;
import br.com.ufsm.projetowebspring.dao.UsuarioDAO;
import br.com.ufsm.projetowebspring.models.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private TipoUsuarioDAO tipoUsuarioDAO;

    @GetMapping
    public ModelAndView visualizarUsuarios() {
        ModelAndView mv = new ModelAndView("UsuarioView/usuarios");
        mv.addObject("usuarios", usuarioDAO.findAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView criarUsuario() {
        ModelAndView mv = new ModelAndView("UsuarioView/usuarioCriarOuEditar");
        mv.addObject("tiposUsuario", tipoUsuarioDAO.findAll());
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarUsuario(@PathVariable int id) {
        Usuario usuario = usuarioDAO.getReferenceById(id);
        ModelAndView mv = new ModelAndView("UsuarioView/usuarioCriarOuEditar");
        mv.addObject("tiposUsuario", tipoUsuarioDAO.findAll());
        mv.addObject("usuario", usuario);
        return mv;
    }

    @PostMapping
    public String salvarUsuario(@Valid Usuario usuario) {
        usuarioDAO.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/{id}/delete")
    public String excluirUsuario(@PathVariable int id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuarioDAO.delete(usuario);
        return "redirect:/usuarios";
    }
}
