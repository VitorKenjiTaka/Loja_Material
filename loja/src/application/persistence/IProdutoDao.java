package application.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Produto;

public interface IProdutoDao {
	
	public void AdicionaProduto(Produto p)  throws SQLException, ClassNotFoundException;
	
	public void AlterarProduto(Produto p)  throws SQLException, ClassNotFoundException;
	
	public Produto BuscarProduto(int i)  throws SQLException, ClassNotFoundException;
	
	public void ExcluiProduto(int i)  throws SQLException, ClassNotFoundException;
	
	public ArrayList<Produto> ListaProduto() throws SQLException, ClassNotFoundException;
	
	public int IdProduto() throws SQLException, ClassNotFoundException;
	
	public String BuscarNome(int i)  throws SQLException, ClassNotFoundException;
	
	public Double BuscarValor(int i)  throws SQLException, ClassNotFoundException;
}
