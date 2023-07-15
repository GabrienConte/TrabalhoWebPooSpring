package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.ProdutoDAO;
import br.com.ufsm.projetowebspring.models.Produto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping
    public ModelAndView visualizarProdutos() {
        ModelAndView mv = new ModelAndView("ProdutoView/produtos");
        mv.addObject("produtos", produtoDAO.findAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView criarProduto() {
        ModelAndView mv = new ModelAndView("ProdutoView/produtoCriarOuEditar");
        mv.addObject("produto", new Produto());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarProduto(@PathVariable int id) {
        Produto produto = produtoDAO.getReferenceById(id);
        ModelAndView mv = new ModelAndView("ProdutoView/produtoCriarOuEditar");
        mv.addObject("produto", produto);
        return mv;
    }

    @PostMapping
    public String salvarProduto(@Valid Produto produto) {
        produtoDAO.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/{id}/delete")
    public String excluirProduto(@PathVariable int id) {
        Produto produto = new Produto();
        produto.setId(id);
        produtoDAO.delete(produto);
        return "redirect:/produtos";
    }
}
