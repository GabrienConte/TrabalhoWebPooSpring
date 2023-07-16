package br.com.ufsm.projetowebspring.controllers;

import br.com.ufsm.projetowebspring.models.relatorios.*;
import br.com.ufsm.projetowebspring.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {
    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public ModelAndView visualizarPedidos() {
        ModelAndView mv = new ModelAndView("RelatorioView/relatorios");
        mv.addObject("pedidosPorUsuario", relatorioService.gerarRelatorioPedidosPorUsuario());
        mv.addObject("vendasPorCliente", relatorioService.gerarRelatorioPedidosPorEntidade());
        mv.addObject("produtosMaisVendidos", relatorioService.gerarRelatorioProdutosMaisVendidos());

        System.out.println("-----------------------pedidosPorUsuario---------------------");
        for(RelatorioPedidosPorUsuario row : relatorioService.gerarRelatorioPedidosPorUsuario()) {
            System.out.println(row.toString());
        }
        System.out.println("------------------------------------------------------------");

        System.out.println("-----------------------vendasPorCliente---------------------");
        for(RelatorioVendasPorEntidade row :relatorioService.gerarRelatorioPedidosPorEntidade()) {
            System.out.println(row.toString());
        }
        System.out.println("------------------------------------------------------------");

        System.out.println("-----------------------produtosMaisVendidos---------------------");
        for(RelatorioProdutosMaisVendidos row : relatorioService.gerarRelatorioProdutosMaisVendidos()) {
            System.out.println(row.toString());
        }
        System.out.println("------------------------------------------------------------");
        return mv;
    }
}
