package br.com.ufsm.projetowebspring.models.relatorios;

public class RelatorioPedidosPorUsuario {
    private String nomeUsuario;
    private int idPedido;
    private String nomeEntidade;
    private String dataVenda;
    private float totalPedido;

    public RelatorioPedidosPorUsuario(String nomeUsuario, int idPedido, String nomeEntidade, String dataVenda, float totalPedido) {
        this.nomeUsuario = nomeUsuario;
        this.idPedido = idPedido;
        this.nomeEntidade = nomeEntidade;
        this.dataVenda = dataVenda;
        this.totalPedido = totalPedido;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getTotal() {
        return totalPedido;
    }

    public void setTotal(float total) {
        this.totalPedido = total;
    }

    @Override
    public String toString() {
        return "RelatorioPedidosPorUsuario{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", idPedido=" + idPedido +
                ", nomeEntidade='" + nomeEntidade + '\'' +
                ", dataVenda='" + dataVenda + '\'' +
                ", totalPedido=" + totalPedido +
                '}';
    }
}
