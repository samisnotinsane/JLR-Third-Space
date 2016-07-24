package io.modernfamily;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author baseerfaizan
 */
public class JavaFXApplication3 extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        window.setTitle("JLR Welcome");
        window.setScene(new Scene(root, 850, 450));
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
