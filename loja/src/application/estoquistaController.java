package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class estoquistaController {
	
	@FXML
	private Button btnProduto;
	
	@FXML
	public void btnProdutoClick(ActionEvent event) {
		Stage stageP = new Stage();
        BorderPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("produto.fxml"));
			Scene sceneP = new Scene(root,600,400);
			sceneP.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stageP.setScene(sceneP);
			stageP.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("abrir tela produto"); 
	}
	
	@FXML
	public void btnEstoqueClick(ActionEvent event) {
		Stage stageP = new Stage();
        BorderPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("estoque.fxml"));
			Scene sceneP = new Scene(root,600,400);
			sceneP.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stageP.setScene(sceneP);
			stageP.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("abrir tela estoque"); 
	}
	
}
