package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Funcionario;

public class LoginDao implements ILoginDao{
	private GenericDao gDao;
	
	public LoginDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public ArrayList<Funcionario> buscarFuncionario() throws SQLException, ClassNotFoundException {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		Connection c = gDao.getConnection();
		
		String sql = "SELECT login, senha, area FROM funcionario";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Funcionario f = new Funcionario();
			f.setLogin(rs.getString("login"));
			f.setSenha(rs.getString("senha"));
			f.setArea(rs.getString("area"));
			funcionarios.add(f);
		}
		rs.close();
		ps.close();
		c.close();
		return funcionarios;
	}
}