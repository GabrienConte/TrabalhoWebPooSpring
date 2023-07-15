package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.ItemPedidoDAO;
import br.com.ufsm.projetowebspring.dao.PedidoDAO;
import br.com.ufsm.projetowebspring.dao.ProdutoDAO;
import br.com.ufsm.projetowebspring.models.ItemPedido;
import br.com.ufsm.projetowebspring.models.Pedido;
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
@RequestMapping(value = "/itenspedido")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoDAO itemPedidoDAO;
    @Autowired
    private ProdutoDAO produtoDAO;
    @Autowired
    private PedidoDAO pedidoDAO;

    @GetMapping("/{idPedido}")
    public ModelAndView visualizarItensPedido(@PathVariable int idPedido) {
        ModelAndView mv = new ModelAndView("ItemPedidoView/itenspedido");
        mv.addObject("idPedido", idPedido);
        mv.addObject("itensPedido", itemPedidoDAO.findAllByPedidoId(idPedido));
        return mv;
    }

    @GetMapping("/new/{idPedido}")
    public ModelAndView criarItemPedido(@PathVariable int idPedido) {
        ModelAndView mv = new ModelAndView("ItemPedidoView/itempedidoCriarOuEditar");
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedidoDAO.getReferenceById(idPedido));
        mv.addObject("itemPedido", itemPedido);
        mv.addObject("produtos", produtoDAO.findAll());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarItemPedido(@PathVariable int id) {
        ItemPedido itemPedido = itemPedidoDAO.getById(id);
        ModelAndView mv = new ModelAndView("ItemPedidoView/itempedidoCriarOuEditar");
        mv.addObject("itemPedido", itemPedido);
        mv.addObject("produtos", produtoDAO.findAll());
        return mv;
    }

    @PostMapping
    public String salvarItemPedido(@Valid ItemPedido itemPedido) {
        itemPedido.setTotal(itemPedido.getQuantidade() * produtoDAO.getReferenceById(itemPedido.getProduto().getId()).getValor());
        itemPedidoDAO.save(itemPedido);

        Pedido pedido = pedidoDAO.getReferenceById(itemPedido.getPedido().getId());
        pedido.setTotal(itemPedidoDAO.selectTotals(pedido.getId()));
        pedidoDAO.save(pedido);

        return "redirect:/itenspedido/" + itemPedido.getPedido().getId();
    }

    @GetMapping("/{id}/delete")
    public String excluirItemPedido(@PathVariable int id) {
        ItemPedido itemPedido = itemPedidoDAO.getReferenceById(id);
        itemPedido.setId(id);

        itemPedidoDAO.delete(itemPedido);

        Pedido pedido = pedidoDAO.getReferenceById(itemPedido.getPedido().getId());
        pedido.setTotal(itemPedidoDAO.selectTotals(pedido.getId()));
        pedidoDAO.save(pedido);
        return "redirect:/itenspedido/" + itemPedido.getPedido().getId();
    }
}
