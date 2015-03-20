package org.br.locadora;

import org.br.locadora.VitrineApp.ItensProperty;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CarrinhoApp extends Application {

	private AnchorPane pane;
	private TableView<ItensProperty> tbCarrinho;
	private TableColumn<ItensProperty, String> columnProduto;
	private TableColumn<ItensProperty, Double> columnPreco;
	private Button btExcluirItem, btVoltarVitrine, btConfirmarCompra;
	private static ObservableList<ItensProperty> listItens;
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		pane.setPrefSize(500, 600);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Carrinho - GolFX");
		stage.show();
		initLayout();
		CarrinhoApp.stage = stage;

	}

	private void initItens() {
		for (Produto p : VitrineApp.getCarrinho().getProdutos())
			listItens.add(new ItensProperty(p.getProduto(), p.getPreco()));

	}

	public class ItensProperty {
		private SimpleStringProperty produto;
		private SimpleDoubleProperty preco;

		public ItensProperty(String produto, double preco) {
			this.preco = new SimpleDoubleProperty(preco);
			this.produto = new SimpleStringProperty(produto);
		}

		public String getProduto() {
			return produto.get();
		}

		public void setProduto(String produto) {
			this.produto.set(produto);
		}

		public double getPreco() {
			return preco.get();
		}

		public void setPreco(double preco) {
			this.preco.set(preco);
		}
	}

	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		pane.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, blue 0%, white 100%);");
		tbCarrinho = new TableView<ItensProperty>();
		columnProduto = new TableColumn<ItensProperty, String>();
		columnProduto
				.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>(
						"produto"));
		columnPreco = new TableColumn<ItensProperty, Double>();
		columnPreco
				.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>(
						"preco"));
		tbCarrinho.getColumns().addAll(columnProduto, columnPreco);
		btExcluirItem = new Button("Excluir Item");
		btVoltarVitrine = new Button("Voltar");
		btConfirmarCompra = new Button("Confirmar Compra");

		pane.getChildren().addAll(tbCarrinho, btExcluirItem, btConfirmarCompra,
				btVoltarVitrine);
	}

	private void initLayout() {
		tbCarrinho.setLayoutX(0);
		tbCarrinho.setLayoutY(0);
		btVoltarVitrine.setLayoutX(100);
		btVoltarVitrine.setLayoutY(100);
	}
}
