package br.com.ufsm.projetowebspring.service;

import br.com.ufsm.projetowebspring.dao.EntidadeDAO;
import br.com.ufsm.projetowebspring.dao.PedidoDAO;
import br.com.ufsm.projetowebspring.dao.ProdutoDAO;
import br.com.ufsm.projetowebspring.models.relatorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {
    private final PedidoDAO pedidoDAO;
    private final ProdutoDAO produtoDAO;
    private final EntidadeDAO entidadeDAO;

    @Autowired
    public RelatorioService(PedidoDAO pedidoDAO, ProdutoDAO produtoDAO, EntidadeDAO entidadeDAO) {
        this.pedidoDAO = pedidoDAO;
        this.produtoDAO = produtoDAO;
        this.entidadeDAO = entidadeDAO;
    }

    public List<RelatorioPedidosPorUsuario> gerarRelatorioPedidosPorUsuario() {
        return pedidoDAO.obterRelatorioPedidosPorUsuario();
    }

    public List<RelatorioProdutosMaisVendidos> gerarRelatorioProdutosMaisVendidos() {
        return produtoDAO.obterRelatorioProdutosMaisVendidos();
    }

    public List<RelatorioVendasPorEntidade> gerarRelatorioPedidosPorEntidade() {
        return entidadeDAO.obterRelatoriovendasPorEntidade();
    }
}
