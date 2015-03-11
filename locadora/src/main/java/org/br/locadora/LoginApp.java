package org.br.locadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginApp extends Application {

	public LoginApp() {

	}

	@Override
	public void start(Stage primarystage) throws Exception {
		Label label = new Label();
		label.setText("Hello Word");
		HBox box = new HBox();
		box.getChildren().add(label);
		primarystage.setScene(new Scene(label));
		primarystage.setWidth(500);
		primarystage.setHeight(400);
		primarystage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
