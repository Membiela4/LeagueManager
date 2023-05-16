package com.example.leaguemanager2.controller;

import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Match;
import com.example.leaguemanager2.modelDomain.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateCalendarController implements Initializable {

    private Match match;
    private List<Team> teams;
    TeamDAO teamDAO = new TeamDAO();
    @FXML
    private ComboBox comboBoxTeams;
    @FXML
    private Button closeButton;

    @FXML
    private TableView<Team> tableTeams;
    @FXML
    private TableColumn<Team, String> teamNameColumn;
    @FXML
    private TableColumn<Team, String> teamAbbColumn;
    @FXML
    private Button refreshBtn;
    public ObservableList<Team> teamObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Team> allTeams = null;
        try {
            allTeams = teamDAO.findAll();
            teamNameColumn.setCellFactory(new PropertyValueFactory("name"));
            teamAbbColumn.setCellFactory(new PropertyValueFactory("abbreviation"));
            comboBoxTeams.setItems(FXCollections.observableArrayList(allTeams));
            tableTeams.setItems(teamObservableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        comboBoxTeams.setCellFactory(param -> new ListCell<Team>() {

            protected void updateItem(Team team, boolean empty) {
                super.updateItem(team, empty);
                if (empty || team == null) {
                    setText(null);
                } else {
                    setText(team.getName());
                }
            }
        });
        comboBoxTeams.setButtonCell(new ListCell<Team>() {

            protected void updateItem( Team team, boolean empty) {
                super.updateItem(team, empty);
                if (empty || team == null) {
                    setText(null);
                } else {
                    setText(team.getName());
                }
            }
        });
    }

    @FXML
    private void addTeam(ActionEvent event) {
        List<Team> teams = new ArrayList<>();
        Team choosedTeam = (Team) comboBoxTeams.getValue();
        if (choosedTeam != null && !teams.contains(choosedTeam)) {
            teams.add(choosedTeam);
        }else{
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("ERROR");
          alert.setContentText("Escoge un equipo valido");
        }
        ObservableList<Team> teamObservableList = FXCollections.observableArrayList(teams);
        tableTeams.refresh();
    }


    public List<Team> getTeams() {return teams;}
    @FXML
    private void handleCloseButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void refresh(ActionEvent event) {
        this.tableTeams.refresh();
    }
}
