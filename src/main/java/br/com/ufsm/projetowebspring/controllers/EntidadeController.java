package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.EntidadeDAO;
import br.com.ufsm.projetowebspring.models.Entidade;
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
@RequestMapping("/entidades")
public class EntidadeController {
    @Autowired
    private EntidadeDAO entidadeDAO;

    @GetMapping
    public ModelAndView visualizarEntidades() {
        ModelAndView mv = new ModelAndView("EntidadeView/entidades");
        mv.addObject("entidades", entidadeDAO.findAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView criarEntidade() {
        ModelAndView mv = new ModelAndView("EntidadeView/entidadeCriarOuEditar");
        mv.addObject("entidade", new Entidade());
        mv.addObject("opcao", "criar");
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarEntidade(@PathVariable int id) {
        Entidade entidade = entidadeDAO.getById(id);
        ModelAndView mv = new ModelAndView("EntidadeView/entidadeCriarOuEditar");
        mv.addObject("entidade", entidade);
        mv.addObject("opcao", "editar");
        return mv;
    }

    @PostMapping
    public String salvarEntidade(@Valid Entidade entidade) {
        entidadeDAO.save(entidade);
        return "redirect:/entidades";
    }

    @GetMapping("/{id}/delete")
    public String excluirEntidade(@PathVariable int id) {
        Entidade entidade = new Entidade();
        entidade.setId(id);
        entidadeDAO.delete(entidade);
        return "redirect:/entidades";
    }
}