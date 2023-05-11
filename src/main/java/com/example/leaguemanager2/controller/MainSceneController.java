package com.example.leaguemanager2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private Button closeButton;

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();;
        currentStage = (Stage) closeButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    private Pane pane;
    public void closeWindows() {

    }
    /*
    Method asigned to a Button that change the view to the players manager
     */
    @FXML
    public void playersScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new URL("file:/C:/Users/Acer%20E15/Desktop/Programación/LeagueManager/src/main/resources/com/example/leaguemanager2/playersScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();;


            PlayersSceneController controller = loader.getController();

            currentStage.setScene(scene);
            currentStage.show();

            currentStage.setOnCloseRequest(e -> controller.closeWindows());
            currentStage = (Stage) this.btnPlayers.getScene().getWindow();
            if (currentStage != null) {
                currentStage.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*
    Method that change the view to the teams manager
     */
    @FXML
    public void teamsScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new URL("file:/C:/Users/Acer%20E15/Desktop/Programación/LeagueManager/src/main/resources/com/example/leaguemanager2/teamsScene.fxml"));

            //loader.getClass().getResource("teamsScene.fxml");
            //URL url = getClass().getClassLoader().getResource("teamsScene.fxml");
            //loader.setLocation(url);

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();;

            TeamsSceneController controller = loader.getController();

            currentStage.setScene(scene);
            currentStage.show();

            currentStage.setOnCloseRequest(e -> controller.closeWindows());
            currentStage = (Stage) this.btnTeams.getScene().getWindow();
            if (currentStage != null) {
                currentStage.close();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
