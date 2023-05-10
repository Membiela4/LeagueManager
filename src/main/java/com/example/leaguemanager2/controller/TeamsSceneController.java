package com.example.leaguemanager2.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TeamsSceneController {
    @FXML
    private Button backBtn;
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:/C:/Users/Acer%20E15/Desktop/Programación/LeagueManager/src/main/resources/com/example/leaguemanager2/mainScene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        MainSceneController controller = loader.getController();

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> controller.closeWindows());
        Stage myStage = (Stage) this.backBtn.getScene().getWindow();
        myStage.close();

    }

    public void closeWindows() {
    }
}
