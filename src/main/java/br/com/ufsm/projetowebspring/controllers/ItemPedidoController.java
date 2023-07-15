package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.ItemPedidoDAO;
import br.com.ufsm.projetowebspring.models.ItemPedido;
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
@RequestMapping("/itempedidos")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoDAO itemPedidoDAO;

    @GetMapping
    public ModelAndView visualizarItensPedido() {
        ModelAndView mv = new ModelAndView("ItemPedidoView/itempedidos");
        mv.addObject("itensPedido", itemPedidoDAO.findAll());
        return mv;
    }

    @GetMapping("/criar")
    public ModelAndView criarItemPedido() {
        ModelAndView mv = new ModelAndView("ItemPedidoView/itempedidoCriarOuEditar");
        mv.addObject("itemPedido", new ItemPedido());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarItemPedido(@PathVariable int id) {
        ItemPedido itemPedido = itemPedidoDAO.getById(id);
        ModelAndView mv = new ModelAndView("ItemPedidoView/itempedidoCriarOuEditar");
        mv.addObject("itemPedido", itemPedido);
        return mv;
    }

    @PostMapping
    public String salvarItemPedido(@Valid ItemPedido itemPedido) {
        itemPedidoDAO.save(itemPedido);
        return "redirect:/itempedidos";
    }

    @GetMapping("/{id}/delete")
    public String excluirItemPedido(@PathVariable int id) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(id);
        itemPedidoDAO.delete(itemPedido);
        return "redirect:/itempedidos";
    }
}
