package com.example.leaguemanager2.controller;

import com.example.leaguemanager2.LeagueManagerApp;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadingPageController implements Initializable {
    private Runnable loadingFinishedAction;

    @FXML
    private BorderPane bp;

    @FXML
    private ProgressBar barraDeProgreso;
    @FXML
    private Button changeViewBtn;
    @FXML
    private Button closeButton;

    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    /*
    Method to set the main menu view
     */
    @FXML
    public void changeView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/leaguemanager2/mainScene.fxml"));
            //loader.setLocation(new URL("file:/C:/Users/Acer%20E15/Desktop/Programación/LeagueManager/src/main/resources/com/example/leaguemanager2/mainScene.fxml"));


            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();


            MainSceneController controller = loader.getController();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> changeView());
            Stage myStage = (Stage) this.changeViewBtn.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void setLoadingFinishedAction(Runnable action) {
        loadingFinishedAction = action;
    }

    /*
     this function set a timer to change the visiblity of a button that allows to enter the app
     */

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        changeViewBtn.setVisible(false);
        PauseTransition loading = new PauseTransition(Duration.seconds(3));
        loading.setOnFinished(event -> {

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(3), e -> {
                        changeViewBtn.setVisible(true); // hacemos visible el botón después de los 3 segundos
                    })
            );
            timeline.play();
        });
        loading.play();

    }
}
