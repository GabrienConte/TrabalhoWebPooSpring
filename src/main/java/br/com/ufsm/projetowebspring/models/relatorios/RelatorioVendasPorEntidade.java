package br.com.ufsm.projetowebspring.models.relatorios;

public class RelatorioVendasPorEntidade {
    private String nomeEntidade;
    private String cpf;
    private String telefone;
    private Long quantidadeDeVendas;
    private Double totalGasto;

    public RelatorioVendasPorEntidade(String nomeEntidade, String cpf, String telefone, Long quantidadeDeVendas, Double totalGasto) {
        this.nomeEntidade = nomeEntidade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.quantidadeDeVendas = quantidadeDeVendas;
        this.totalGasto = totalGasto;
    }

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getQuantidadeDeVendas() {
        return quantidadeDeVendas;
    }

    public void setQuantidadeDeVendas(Long quantidadeDeVendas) {
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

    public Double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(Double totalGasto) {
        this.totalGasto = totalGasto;
    }

    @Override
    public String toString() {
        return "RelatorioVendasPorCliente{" +
                "nomeEntidade='" + nomeEntidade + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", quantidadeDeVendas=" + quantidadeDeVendas +
                ", totalGasto=" + totalGasto +
                '}';
    }
}
