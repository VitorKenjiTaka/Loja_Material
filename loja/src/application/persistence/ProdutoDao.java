package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Produto;

public class ProdutoDao implements IProdutoDao{
	private GenericDao gDao;
	
	public ProdutoDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public void AdicionaProduto(Produto p) throws SQLException, ClassNotFoundException {
		
		Connection c = gDao.getConnection();
		String sql =  "INSERT INTO produto VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,p.getId());
		ps.setString(2,p.getNome());
		ps.setString(3,p.getFornecedor());
		ps.setDouble(4,p.getValor());
		ps.setString(5,p.getDescricao());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void AlterarProduto(Produto p) throws SQLException, ClassNotFoundException {
		
		Connection c = gDao.getConnection();
		String sql ="UPDATE produto \r\n"
				+ 	"SET nome =?, fornecedor = ?, valor = ?, descricao = ? \r\n"
				+ 	"WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getFornecedor());
		ps.setDouble(3, p.getValor());
		ps.setString(4, p.getDescricao());
		ps.setInt(5, p.getId());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Produto BuscarProduto(int i) throws SQLException, ClassNotFoundException {
		Produto pr = new Produto();
		Connection c = gDao.getConnection();
		
		String sql = "SELECT id, nome, fornecedor, valor, descricao FROM produto p WHERE p.id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			pr.setId(rs.getInt("id"));
			pr.setNome(rs.getString("nome"));
			pr.setFornecedor(rs.getString("fornecedor"));
			pr.setValor(rs.getDouble("valor"));
			pr.setDescricao(rs.getString("descricao"));
		}
		rs.close();
		ps.close();
		c.close();
		return pr;
	}

	@Override
	public void ExcluiProduto(int i) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql =  	"DELETE FROM produto WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, i);
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public ArrayList<Produto> ListaProduto() throws SQLException, ClassNotFoundException {
		ArrayList<Produto> ps = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT id, nome, fornecedor, valor, descricao FROM produto";
		PreparedStatement pre = c.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		
		while(rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setFornecedor(rs.getString("fornecedor"));
			p.setValor(rs.getDouble("valor"));
			p.setDescricao(rs.getString("descricao"));
			
			ps.add(p);
		}
		rs.close();
		pre.close();
		c.close();
		System.out.println("lista da querry: " + ps);
		return ps;
	}

	@Override
	public int IdProduto() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT id FROM produto ORDER BY id DESC";
		PreparedStatement pre = c.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		int i;
		
		if(rs.next()) {
			i = rs.getInt("id");
		}else {
			i = 0;
		}
		rs.close();
		pre.close();
		c.close();
		return i;
	}

	@Override
	public String BuscarNome(int i) throws SQLException, ClassNotFoundException {
		String no;
		Connection c = gDao.getConnection();
		String sql = "SELECT nome FROM produto WHERE id = ?";
		PreparedStatement pre = c.prepareStatement(sql);
		pre.setInt(1, i);
		ResultSet rs = pre.executeQuery();
		rs.next();
		no = rs.getString("nome");
		rs.close();
		pre.close();
		c.close();
		return no;
	}

	@Override
	public Double BuscarValor(int i) throws SQLException, ClassNotFoundException {
		Double d;
		Connection c = gDao.getConnection();
		String sql = "SELECT valor FROM produto WHERE id = ?";
		PreparedStatement pre = c.prepareStatement(sql);
		pre.setInt(1, i);
		ResultSet rs = pre.executeQuery();
		rs.next();
		d = rs.getDouble("valor");
		rs.close();
		pre.close();
		c.close();
		return d;
	}
}