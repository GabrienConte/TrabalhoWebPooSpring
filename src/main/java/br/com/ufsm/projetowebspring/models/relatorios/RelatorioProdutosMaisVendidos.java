package br.com.ufsm.projetowebspring.models.relatorios;

public class RelatorioProdutosMaisVendidos {
    private String descricao;
    private String marca;
    private Double quantidadeTotalVendida;

    public RelatorioProdutosMaisVendidos(String descricao, String marca, Double quantidadeTotalVendida) {
        this.descricao = descricao;
        this.marca = marca;
        this.quantidadeTotalVendida = quantidadeTotalVendida;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getQuantidadeTotalVendida() {
        return quantidadeTotalVendida;
    }

    public void setQuantidadeTotalVendida(Double quantidadeTotalVendida) {
        this.quantidadeTotalVendida = quantidadeTotalVendida;
    }

    @Override
    public String toString() {
        return "RelatorioProdutosMaisVendidos{" +
                "descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", quantidadeTotalVendida=" + quantidadeTotalVendida +
                '}';
    }
}