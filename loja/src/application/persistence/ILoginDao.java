package application.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Funcionario;

public interface ILoginDao {

	public ArrayList<Funcionario> buscarFuncionario()  throws SQLException, ClassNotFoundException;
	
}
