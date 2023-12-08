package com.example.laddersandsnakesfinal;

import com.example.laddersandsnakesfinal.Controller.BoardController;
import com.example.laddersandsnakesfinal.Model.Classes.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/hello-view.fxml"));

        BoardController controller = fxmlLoader.getController();
        if (controller != null) {
            controller.initialize();
        }

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ladders and Snakes");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
//        launch();
       Game game=new Game();
       game.play();
             }
    }
