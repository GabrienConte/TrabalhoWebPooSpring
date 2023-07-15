package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.TipoUsuarioDAO;
import br.com.ufsm.projetowebspring.models.TipoUsuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tiposusuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioDAO tipoUsuarioDAO;

    @GetMapping
    public ModelAndView visualizarTipoUsuarios() {
        ModelAndView mv = new ModelAndView("TipoUsuarioView/tiposusuario");
        mv.addObject("tiposUsuario", tipoUsuarioDAO.findAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView criarTipoUsuario() {
        ModelAndView mv = new ModelAndView("TipoUsuarioView/tipousuarioCriarOuEditar");
        mv.addObject("tipoUsuario", new TipoUsuario());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarTipoUsuario(@PathVariable int id) {
        TipoUsuario tipoUsuario = tipoUsuarioDAO.getReferenceById(id);

        ModelAndView mv = new ModelAndView("TipoUsuarioView/tipousuarioCriarOuEditar");
        mv.addObject("tipoUsuario", tipoUsuario);
        return mv;
    }

    @PostMapping()
    public String salvarTipoUsuario(@Valid TipoUsuario tipoUsuario) {
        tipoUsuarioDAO.save(tipoUsuario);

        return "redirect:/tiposusuario";
    }

    @GetMapping("/{id}/delete")
    public String excluirTipoUsuario(@PathVariable int id) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setId(id);

        tipoUsuarioDAO.delete(tipoUsuario);

        return "redirect:/tiposusuario";
    }

}
