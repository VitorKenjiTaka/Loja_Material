package application;

import java.sql.SQLException;

import application.model.Produto;
import application.persistence.GenericDao;
import application.persistence.ProdutoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class produtoAdicionarController {
	GenericDao gDao = new GenericDao();
	ProdutoDao pDao = new ProdutoDao(gDao);
	Produto p = new Produto();
	
	@FXML
    private TextField tfNome;
	@FXML
    private TextField tfFornecedor;
	@FXML
    private TextField tfValor;
	@FXML
    private TextField tfDescricao;
	
	public void btnAdicionarClick(ActionEvent event) {
		int i = 0;
		try {
			i = pDao.IdProduto();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		int id = i + 1;
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
			pDao.AdicionaProduto(p);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}