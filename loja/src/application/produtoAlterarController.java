package application;

import java.sql.SQLException;

import application.model.Produto;
import application.persistence.GenericDao;
import application.persistence.ProdutoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class produtoAlterarController {
	GenericDao gDao = new GenericDao();
	ProdutoDao pDao = new ProdutoDao(gDao);
	Produto p = new Produto();
	
	@FXML
	private TextField tfId;
	@FXML
    private TextField tfNome;
	@FXML
    private TextField tfFornecedor;
	@FXML
    private TextField tfValor;
	@FXML
    private TextField tfDescricao;
	
	public void btnAlterarClick(ActionEvent event) {
		
		int id = 			Integer.parseInt(tfId.getText());
		Double valor = 		Double.parseDouble(tfValor.getText());
		String descricao = 	tfDescricao.getText();
		String nome = 		tfNome.getText();
		String fornecedor = tfFornecedor.getText();
		
		p.setId(id);
		p.setNome(nome);
		p.setFornecedor(fornecedor);
		p.setValor(valor);
		p.setDescricao(descricao);
		
		try {
			pDao.AlterarProduto(p);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void btnBuscarClick(ActionEvent event) {
		try {
			p = pDao.BuscarProduto(Integer.parseInt(tfId.getText()));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String nome = p.getNome();
		String fornecedor = p.getFornecedor();
		Double valor = p.getValor();
		String descricao = p.getDescricao();
		String valort = String.valueOf(valor);
		
		tfNome.setText(nome);
		tfFornecedor.setText(fornecedor);
		tfValor.setText(valort);
		tfDescricao.setText(descricao);
	}
}