package application.model;

public class Estoque {

	private int idProd;
	private int quantidade;
	
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "estoque [idProd=" + idProd + ", quantidade=" + quantidade + "]";
	}
}
