package com.example.leaguemanager2.controller;

import com.example.leaguemanager2.dao.MatchDAO;
import com.example.leaguemanager2.modelDomain.Match;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SetResultController implements Initializable {

        public Button closeButton;

        MatchDAO matchDAO = new MatchDAO();

        @FXML
        private TextField localResult;
        @FXML
        private TextField visitorResult;
        private Match match;
        public void setMatch(Match match) {this.match = match;
        }

        @FXML
        private void handleCloseButtonAction() {
            if (match != null) {
                match.setLocal_result(Integer.parseInt(localResult.getText()));
                match.setVisitor_result(Integer.parseInt(visitorResult.getText()));

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO");
                alert.setContentText("Resultado actualizado correctamente");
                try {
                    matchDAO.save(match);
                    alert.showAndWait();
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
