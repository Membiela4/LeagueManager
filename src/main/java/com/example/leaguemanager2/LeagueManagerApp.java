package com.example.leaguemanager2;

import com.example.leaguemanager2.dao.PlayerDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.leaguemanager2.controller.LoadingPageController;


import java.io.IOException;

public class LeagueManagerApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loadingPage.fxml"));
        Parent root = loader.load();

        LoadingPageController controller = loader.getController();
        controller.setLoadingFinishedAction(new Runnable() {
            @Override
            public void run() {
                try {
                    Parent siguienteEscena = FXMLLoader.load(getClass().getResource("/views/mainScene.fxml"));
                    Scene scene = new Scene(siguienteEscena);
                    primaryStage.setScene(scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
