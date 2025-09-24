package com.ivanov.antony;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CalculatorFrame extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ivanov/antony/CalculatorView.fxml")));
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Calculator");
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());
        // Image icon = new Image("file:icon.png");
        // stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
