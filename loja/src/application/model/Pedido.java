package application.model;

import java.util.ArrayList;

public class Pedido {

	private int id;
	private Double valorTotal;
	private ArrayList<Item> itens = new ArrayList<>(); 
	private String data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valorTotal=" + valorTotal + ", itens=" + itens + ", data=" + data + "]";
	}
	
	
}