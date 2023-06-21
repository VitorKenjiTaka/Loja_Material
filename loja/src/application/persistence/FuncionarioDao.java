package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.model.Funcionario;

public class FuncionarioDao implements IFuncionarioDao{
	private GenericDao gDao;
	
	public FuncionarioDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public void CadastraFuncionario(Funcionario f) throws SQLException, ClassNotFoundException {
		
		Connection c = gDao.getConnection();
		String sql =  "INSERT INTO funcionario VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,f.getLogin());
		ps.setString(2,f.getSenha());
		ps.setString(3,f.getArea());
		ps.execute();
		ps.close();
		c.close();
	}
}
