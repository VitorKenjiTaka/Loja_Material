package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Produto;
import application.persistence.GenericDao;
import application.persistence.ProdutoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class compraController {
	GenericDao gDao = new GenericDao();
	ProdutoDao pDao = new ProdutoDao(gDao);
	ArrayList<Produto> produtos = new ArrayList<>();
	
	@FXML
	private ListView lvProduto;
	@FXML
	private Button btnListar;
	
	public void btnListarClick(ActionEvent event) {
		try {
			produtos = pDao.ListaProduto();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		lvProduto.getItems().addAll(produtos);
	}
	
	public void btnRealizarClick(ActionEvent event) {
		Stage stageP = new Stage();
        BorderPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("finalizarCompra.fxml"));
			Scene sceneP = new Scene(root,600,400);
			sceneP.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stageP.setScene(sceneP);
			stageP.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
