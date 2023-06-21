package application;

import java.sql.SQLException;

import application.model.Funcionario;
import application.persistence.FuncionarioDao;
import application.persistence.GenericDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class funcionarioController {
	GenericDao gDao = new GenericDao();
	FuncionarioDao fDao = new FuncionarioDao(gDao);
	Funcionario f = new Funcionario();
	
	@FXML
	private TextField tfLoginCad;
	@FXML
	private PasswordField pfSenha;
	@FXML
	private TextField tfAreaCad;
	
	
	public void btnCadastrarClick(ActionEvent event) {
		System.out.println("entrou no cadastrar funcionario");
		
		String loginCad = tfLoginCad.getText();
        String senhaCad = pfSenha.getText();
        String areaCad = tfAreaCad.getText();
        
        if (areaCad.equalsIgnoreCase("estoquista")) {
        	f.setLogin(loginCad);
        	f.setSenha(senhaCad);
        	f.setArea("E");
        	try {
				fDao.CadastraFuncionario(f);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        
        if (areaCad.equalsIgnoreCase("caixa")) {
        	f.setLogin(loginCad);
        	f.setSenha(senhaCad);
        	f.setArea("C");
        	try {
				fDao.CadastraFuncionario(f);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
	}
}
