package application;

import java.sql.SQLException;

import application.model.Estoque;
import application.persistence.EstoqueDao;
import application.persistence.GenericDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class estoqueController {
	GenericDao gDao = new GenericDao();
	EstoqueDao eDao = new EstoqueDao(gDao); 
	Estoque e = new Estoque();
	
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfQuantidade;
	
	public void btnAdicionarClick(ActionEvent event) {
		int idP = Integer.parseInt(tfId.getText());
		int quantidade = Integer.parseInt(tfQuantidade.getText());
		
		e.setIdProd(idP);
		e.setQuantidade(quantidade);
		
		try {
			eDao.AdicionaEstoque(e);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void btnAlterarClick(ActionEvent event) {
		int idP = Integer.parseInt(tfId.getText());
		int quantidade = Integer.parseInt(tfQuantidade.getText());
		
		e.setIdProd(idP);
		e.setQuantidade(quantidade);
		
		try {
			eDao.AlterarEstoque(e);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void btnExcluirClick(ActionEvent event) {
		int idP = Integer.parseInt(tfId.getText());
		try {
			eDao.ExcluiEstoque(idP);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void btnBuscarClick(ActionEvent event) {
		Estoque et = new Estoque();
		int idP = Integer.parseInt(tfId.getText());
		try {
			et = eDao.BuscarEstoque(idP);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		String idt = String.valueOf(et.getIdProd());
		String quantt = String.valueOf(et.getQuantidade());
		
		tfId.setText(idt);
		tfQuantidade.setText(quantt);
	}
}