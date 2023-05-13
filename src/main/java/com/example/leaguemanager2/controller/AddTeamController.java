package com.example.leaguemanager2.controller;

import com.example.leaguemanager2.modelDomain.Player;
import com.example.leaguemanager2.modelDomain.Team;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTeamController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private TextField abbreviationField;
    @FXML
    private TextField teamIdField;

    @FXML
    private Button saveBtn;
    @FXML
    private Button  backBtn;

    private Team team;
    @FXML
    private ObservableList<Team> teams;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void initAtributtes(ObservableList<Player> players) {
        this.teams = teams;
    }

    @FXML
    public void saveTeam(ActionEvent event) {

        String name = this.nameField.getText();
        String abbreviation = this.abbreviationField.getText();
        int id =  Integer.parseInt(this.teamIdField.getText());

        Team t = new Team(id,name,abbreviation);

        if(!teams.contains(t)){
            this.team = t;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setContentText("Añadido Correctamente");
            alert.showAndWait();

            Stage stage = (Stage) this.saveBtn.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setContentText("Equipo ya existente");
            alert.showAndWait();
        }
    }

    @FXML
    private void back(ActionEvent event){
        this.team=null;
        Stage stage = (Stage) this.saveBtn.getScene().getWindow();
        stage.close();

    }

    public Team getTeam() {
        return team;
    }
}