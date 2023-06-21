package application.persistence;

import java.sql.SQLException;

import application.model.Pedido;

public interface IPedidoDao {
	
	public int IdPedido() throws SQLException, ClassNotFoundException;
	
	public void guardaPedido(Pedido p) throws SQLException, ClassNotFoundException;
	
}
