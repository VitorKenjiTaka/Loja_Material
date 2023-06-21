package application.persistence;

import java.sql.SQLException;

import application.model.Estoque;

public interface IEstoqueDao {
	
	public void AdicionaEstoque(Estoque e)  throws SQLException, ClassNotFoundException;
	
	public void AlterarEstoque(Estoque e)  throws SQLException, ClassNotFoundException;
	
	public void ExcluiEstoque(int i)  throws SQLException, ClassNotFoundException;
	
	public Estoque BuscarEstoque(int i)  throws SQLException, ClassNotFoundException;
	
}
