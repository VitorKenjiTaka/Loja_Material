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

public class produtoController {
	GenericDao gDao = new GenericDao();
	ProdutoDao pDao = new ProdutoDao(gDao);
	@FXML
	private Button btnAdicionar;
	@FXML
	private ListView lvProduto;
	
	ArrayList<Produto> produtos = new ArrayList<>();
	
	public void btnListarClick(ActionEvent event) {
		try {
			produtos = pDao.ListaProduto();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(produtos);
		lvProduto.getItems().addAll(produtos);
	}
	
	
	public void btnAdicionarClick(ActionEvent event) {
		
		Stage stage = (Stage) btnAdicionar.getScene().getWindow();
		stage.close();
        BorderPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("produtoAdicionar.fxml"));
			Scene sceneAdi = new Scene(root,600,400);
			sceneAdi.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(sceneAdi);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btnAlterarClick(ActionEvent event) {
		Stage stage = (Stage) btnAdicionar.getScene().getWindow();
		stage.close();
        BorderPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("produtoAlterar.fxml"));
			Scene sceneAlt = new Scene(root,600,400);
			sceneAlt.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(sceneAlt);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btnExcluirClick(ActionEvent event) {
		Stage stage = (Stage) btnAdicionar.getScene().getWindow();
		stage.close();
        BorderPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("produtoExcluir.fxml"));
			Scene sceneE = new Scene(root,600,400);
			sceneE.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(sceneE);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}