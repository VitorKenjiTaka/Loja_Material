package application;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Item;
import application.model.ItemTela;
import application.model.Pedido;
import application.persistence.GenericDao;
import application.persistence.PedidoDao;
import application.persistence.ProdutoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class finalizarCompraController {
	GenericDao gDao = new GenericDao();
	PedidoDao peDao = new PedidoDao(gDao);
	ProdutoDao pDao = new ProdutoDao(gDao);
	private ArrayList<Item> itens = new ArrayList<>();
	private int idPedido;
	private Double valorTotal = 0.0;
	
	@FXML
	private Button btnCartao;
	@FXML
	private ListView lvItem;
	@FXML
	private Button btnAdicionar;
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfQuantidade;
	@FXML
	private Label lblValor;
	
	
	public void btnAdicionarClick(){
		System.out.println("AdicionarClick");
		try {
			idPedido = peDao.IdPedido();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		idPedido = idPedido + 1;
		ItemTela itemTela = new ItemTela();
		Item item = new Item();
		int idProd = Integer.parseInt(tfId.getText());
		int quantidade = Integer.parseInt(tfQuantidade.getText());
		item.setIdproduto(idProd);
		item.setQuantidade(quantidade);
		item.setIdpedido(idPedido);
		itens.add(item);
		System.out.println("item = " + item);
		
		itemTela.setQuantidade(quantidade);
		try {
			itemTela.setNome(pDao.BuscarNome(idProd));
			itemTela.setValor(pDao.BuscarValor(idProd));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		lvItem.getItems().addAll(itemTela);
		System.out.println("Itens = "+ itens);
		System.out.println("ItemTela = "+ itemTela);
		
		valorTotal = valorTotal + (itemTela.getValor() * quantidade);
		lblValor.setText(Double.toString(valorTotal));
	}
	
	public void btnCartaoClick(ActionEvent event) {
		LocalDate dataAtual = LocalDate.now();
		Pedido p = new Pedido();
		p.setId(idPedido);
		p.setValorTotal(valorTotal);
		p.setData(dataAtual.toString());
		p.setItens(itens);
		try {
			peDao.guardaPedido(p);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Stage stageL = (Stage) btnCartao.getScene().getWindow();
        stageL.close();
		System.out.println("pagou com cartão");
	}
	
	public void btnDinheiroClick(ActionEvent event) {
		LocalDate dataAtual = LocalDate.now();
		Pedido p = new Pedido();
		p.setId(idPedido);
		p.setValorTotal(valorTotal);
		p.setData(dataAtual.toString());
		p.setItens(itens);
		try {
			peDao.guardaPedido(p);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Stage stageL = (Stage) btnCartao.getScene().getWindow();
        stageL.close();
		System.out.println("pagou com dinheiro");
	}
}