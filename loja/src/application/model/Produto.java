package application.model;

public class Produto {
	
	private int id;
    private String nome;
    private String fornecedor;
    private Double valor;
    private String descricao;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "| ID: " + id + " | Nome: " + nome + " | Fornecedor: " + fornecedor + " | Valor: " + valor + " | Descrição: " + descricao+" |";
	}
}
