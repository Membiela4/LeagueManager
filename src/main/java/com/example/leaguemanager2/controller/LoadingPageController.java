package com.example.leaguemanager2.controller;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;

public class LoadingPageController {
    private Runnable loadingFinishedAction;

    @FXML
    private BorderPane bp;

    @FXML
    private ProgressBar barraDeProgreso;
    @FXML
    private Button changeViewBtn;




    @FXML
    void initialize() {
        changeViewBtn.setVisible(false);
        PauseTransition loading = new PauseTransition(Duration.seconds(5));
        loading.setOnFinished(event -> {

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(5), e -> {
                        changeViewBtn.setVisible(true); // hacemos visible el botón después de los 5 segundos
                        })
                );
                timeline.play();
        });
        loading.play();

    }
    @FXML
    public void changeView() {
        try {
            Parent siguienteEscena = FXMLLoader.load(getClass().getResource("/views/mainScene.fxml"));
            Scene scene = new Scene(siguienteEscena);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLoadingFinishedAction(Runnable action) {
        loadingFinishedAction = action;
    }

}
