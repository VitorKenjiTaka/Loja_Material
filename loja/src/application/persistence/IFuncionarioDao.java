package application.persistence;

import java.sql.SQLException;

import application.model.Funcionario;

public interface IFuncionarioDao {
	
	public void CadastraFuncionario(Funcionario f)  throws SQLException, ClassNotFoundException;
	
}
