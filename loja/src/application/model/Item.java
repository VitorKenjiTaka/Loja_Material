package application.model;

public class Item {

	private int idproduto;
	private int quantidade;
	private int idpedido;
	
	public int getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	
	@Override
	public String toString() {
		return "item [idproduto=" + idproduto + ", quantidade=" + quantidade + ", idpedido=" + idpedido + "]";
	}
}