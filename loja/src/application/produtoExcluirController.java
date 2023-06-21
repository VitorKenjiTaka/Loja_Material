package application;

import java.sql.SQLException;

import application.persistence.GenericDao;
import application.persistence.ProdutoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class produtoExcluirController {
	GenericDao gDao = new GenericDao();
	ProdutoDao pDao = new ProdutoDao(gDao);
	
	@FXML
	private TextField tfId;
	
	public void btnExcluirClick(ActionEvent event) {
		
		try {
			pDao.ExcluiProduto(Integer.parseInt(tfId.getText()));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}