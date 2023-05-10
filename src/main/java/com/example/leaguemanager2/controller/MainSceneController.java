package com.example.leaguemanager2.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainSceneController {


    @FXML
    private ToggleButton btnPlayers;
    @FXML
    private ToggleButton btnTeams;
    @FXML
    private ToggleButton btnLeague;

    @FXML
    private Pane pane;
    public void closeWindows() {

    }
    /*
    Method asigned to a Button that change the view to the players manager
     */
    @FXML
    public void playersScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new URL("file:/C:/Users/Acer%20E15/Desktop/Programación/LeagueManager/src/main/resources/com/example/leaguemanager2/playersScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            PlayersSceneController controller = loader.getController();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeWindows());
            Stage myStage = (Stage) this.btnPlayers.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*
    Method that change the view to the teams manager
     */
    @FXML
    public void teamsScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new URL("file:/C:/Users/Acer%20E15/Desktop/Programación/LeagueManager/src/main/resources/com/example/leaguemanager2/teamsScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            TeamsSceneController controller = loader.getController();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> controller.closeWindows());
            Stage myStage = (Stage) this.btnTeams.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
