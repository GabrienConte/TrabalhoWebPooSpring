package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.dao.EntidadeDAO;
import br.com.ufsm.projetowebspring.dao.PedidoDAO;
import br.com.ufsm.projetowebspring.dao.UsuarioDAO;
import br.com.ufsm.projetowebspring.models.Entidade;
import br.com.ufsm.projetowebspring.models.Pedido;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoDAO pedidoDAO;
    @Autowired
    private EntidadeDAO entidadeDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping
    public ModelAndView visualizarPedidos() {
        ModelAndView mv = new ModelAndView("PedidoView/pedidos");
        mv.addObject("pedidos", pedidoDAO.findAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView criarPedido() {
        ModelAndView mv = new ModelAndView("PedidoView/pedidoCriarOuEditar");
        mv.addObject("entidades", entidadeDAO.findAll());
        mv.addObject("usuarios", usuarioDAO.findAll());
        mv.addObject("pedido", new Pedido());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarPedido(@PathVariable int id) {
        Pedido pedido = pedidoDAO.getById(id);
        ModelAndView mv = new ModelAndView("PedidoView/pedidoCriarOuEditar");
        mv.addObject("entidades", entidadeDAO.findAll());
        mv.addObject("usuarios", usuarioDAO.findAll());
        mv.addObject("pedido", pedido);
        return mv;
    }

    @PostMapping
    public String salvarPedido(@Valid Pedido pedido) {
        pedidoDAO.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/{id}/delete")
    public String excluirPedido(@PathVariable int id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedidoDAO.delete(pedido);
        return "redirect:/pedidos";
    }
}
