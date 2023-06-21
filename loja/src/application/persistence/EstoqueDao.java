package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Estoque;

public class EstoqueDao implements IEstoqueDao{
	private GenericDao gDao;
	
	public EstoqueDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public void AdicionaEstoque(Estoque e) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql =  "INSERT INTO estoque VALUES (?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,e.getIdProd());
		ps.setInt(2,e.getQuantidade());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void AlterarEstoque(Estoque e) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql ="UPDATE estoque SET quantidade = ? WHERE idproduto = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,e.getQuantidade());
		ps.setInt(2,e.getIdProd());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void ExcluiEstoque(int i) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql =  	"DELETE FROM estoque WHERE idproduto = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Estoque BuscarEstoque(int i) throws SQLException, ClassNotFoundException {
		Estoque e = new Estoque();
		Connection c = gDao.getConnection();
		String sql =  	"SELECT idproduto, quantidade FROM estoque WHERE idproduto = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			e.setIdProd(i);
			e.setQuantidade(rs.getInt("quantidade"));
		}
		rs.close();
		ps.close();
		c.close();
		return e;
	}
}