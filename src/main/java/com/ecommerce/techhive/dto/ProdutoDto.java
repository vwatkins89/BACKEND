package com.ecommerce.techhive.dto;

public class ProdutoDto {
	
	private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
    private String marca;
    private String imagemUrl;
    private Integer quantidadeEstoque;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getImagemUrl() {
		return imagemUrl;
	}
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}
