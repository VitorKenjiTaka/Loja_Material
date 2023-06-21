package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Funcionario;
import application.persistence.GenericDao;
import application.persistence.LoginDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class loginController {
	GenericDao gDao = new GenericDao();
	LoginDao lDao = new LoginDao(gDao);

	@FXML
	private TextField tfLogin;
	@FXML
	private PasswordField pfSenha;
	
	@FXML
	public void btnConfirmarClick(ActionEvent event) {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		String login = tfLogin.getText();
        String senha = pfSenha.getText();
        
        System.out.println("Login: " + login);
        System.out.println("Senha: " + senha);
        
        try {
			funcionarios = lDao.buscarFuncionario();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        
        if (login.equals("adm") & senha.equals("123")) {
        	Stage stageL = (Stage) tfLogin.getScene().getWindow();
            stageL.close();
            BorderPane root;
			try {
				root = FXMLLoader.load(getClass().getResource("CadastroFuncionario.fxml"));
				Scene sceneCF = new Scene(root,600,400);
				sceneCF.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stageL.setScene(sceneCF);
				stageL.show();
			} catch (IOException e) {
				e.printStackTrace();
			}  
        }
        
        System.out.println("Lista de funcionário: "+ funcionarios);
        
        for(Funcionario f : funcionarios) {
        	if ( login.equals(f.getLogin()) & senha.equals(f.getSenha())) {
        		String area = f.getArea();
        		
        		if(	area.equalsIgnoreCase("C")) {
        			Stage stageL = (Stage) tfLogin.getScene().getWindow();
                    stageL.close();
                    BorderPane root;
        			try {
        				root = FXMLLoader.load(getClass().getResource("compra.fxml"));
        				Scene sceneCF = new Scene(root,600,400);
        				sceneCF.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        				stageL.setScene(sceneCF);
        				stageL.show();
        			} catch (IOException e) {
        				e.printStackTrace();
        			}
        		}
        		
        		if(area.equalsIgnoreCase("E")) {
        			Stage stageL = (Stage) tfLogin.getScene().getWindow();
                    stageL.close();
                    BorderPane root;
                    try {
        				root = FXMLLoader.load(getClass().getResource("estoquista.fxml"));
        				Scene sceneES = new Scene(root,600,400);
        				sceneES.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        				stageL.setScene(sceneES);
        				stageL.show();
        			} catch (IOException e) {
        				e.printStackTrace();
        			}
        		}
        	}
        }
	}
}