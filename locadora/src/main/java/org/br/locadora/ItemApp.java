package org.br.locadora;

import java.awt.Panel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ItemApp extends Application {

	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbPreco, lbDescricao;
	private Button btAddCarrinho;
	private static Stage stage;
	private static Produto produto;

	private static int index;
	private static String[] images = {
			"http://www.sportcenterlopes.com.br/images/"
					+ "250_topper_campo_2009replic.jpg",
			"http://1.bp.blogspot.com/_H8uGs8K8kaY/TLZTXR8nIgI/"
					+ "AAAAAAAAF_0/BvpxdqGF4PE/s1600/luva_umbro.png",
			"http://bimg2.mlstatic.com/camisa-nike-active-importada-manga-"
					+ "longa-esportiva-vermelha_MLB-F-199843960_1391.jpg",
			"http://www.showtenis.com.br/images/_product/979/979112/"
					+ "chuteira-nike-mercurial-glide-3-fg-campo--199fd9.jpg",
			"http://www.katy.com.br/imagens/produtos/original/"
					+ "caneleira-topper-trainning-difusion-13340619502673137.jpg" };

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		ItemApp.index = index;
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		initComponents();
		initListeners();
		pane.setPrefSize(600, 400);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Vitrine - GolFX");
		stage.show();
		initLayout();
		ItemApp.stage = stage;

	}

	public static Stage getStage() {
		return stage;
	}

	public static Produto getProduto() {
		return produto;
	}

	public static void setProduto(Produto produto) {
		ItemApp.produto = produto;
	}

	private void initComponents() {
		Image img = new Image(images[index]);
		pane = new AnchorPane();
		pane.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, blue 0%, white 100%);");
		imgItem = new ImageView(img);

		imgItem.setLayoutX(0);
		imgItem.setLayoutY(0);
		imgItem.setFitHeight(150);
		imgItem.setFitWidth(150);

		lbDescricao = new Label(produto.getProduto());
		lbPreco = new Label(produto.getPreco().toString());
		btAddCarrinho = new Button("Adicionar ao carrinho");
		pane.getChildren().addAll(imgItem, lbDescricao, lbPreco, btAddCarrinho);

	}

	private void initLayout() {

		lbDescricao.setLayoutX(400);
		lbDescricao.setLayoutY(50);
		lbPreco.setLayoutX(400);
		lbPreco.setLayoutY(0);
		btAddCarrinho.setLayoutX(300);
		btAddCarrinho.setLayoutY(300);
	}

	private void initListeners() {
		btAddCarrinho.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				VitrineApp.getCarrinho().addProdutos(produto);
				try {
					new CarrinhoApp().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
