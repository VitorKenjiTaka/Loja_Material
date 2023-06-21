package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Estoque;
import application.model.Item;
import application.model.Pedido;

public class PedidoDao implements IPedidoDao{
	private GenericDao gDao;
	GenericDao geDao = new GenericDao();
	EstoqueDao eDao = new EstoqueDao(geDao);
	
	public PedidoDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public int IdPedido() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT id FROM pedido ORDER BY id DESC";
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
	public void guardaPedido(Pedido p) throws SQLException, ClassNotFoundException {
		ArrayList<Item> itens = new ArrayList<>();
		itens = p.getItens();
		Connection c = gDao.getConnection();
		String sql =  "INSERT INTO pedido VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,p.getId());
		ps.setDouble(2,p.getValorTotal());
		ps.setString(3,p.getData());
		ps.execute();
		ps.close();
		
		String sql2 =  "INSERT INTO item VALUES (?,?,?)";
		PreparedStatement ps2 = c.prepareStatement(sql2);
		for(Item i: itens) {
			ps2.setInt(1,i.getIdproduto());
			ps2.setInt(2,i.getQuantidade());
			ps2.setInt(3,i.getIdpedido());
			ps2.execute();	
		}
		ps2.close();
		c.close();
		
		for(Item it: itens) {
			Estoque e = new Estoque();
			e = eDao.BuscarEstoque(it.getIdproduto());
			e.setQuantidade(e.getQuantidade() - it.getQuantidade());
			eDao.AlterarEstoque(e);
		}
	}
}