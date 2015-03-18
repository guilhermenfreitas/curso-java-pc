package org.br.locadora;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		pane = new AnchorPane();
		pane.setPrefSize(600, 400);
		stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Login - GolFX");
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
		imgItem = new ImageView();
		lbDescricao = new Label();
		lbPreco = new Label();
		btAddCarrinho = new Button();

	}
	
	private void initLayout(){
		
	}

}
