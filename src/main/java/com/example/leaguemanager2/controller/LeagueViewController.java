package com.example.leaguemanager2.controller;

import com.example.leaguemanager2.dao.MatchDAO;
import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Match;
import com.example.leaguemanager2.modelDomain.Player;
import com.example.leaguemanager2.modelDomain.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;



public class LeagueViewController implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private TableView<Match> table;
    @FXML
    private Button createCalendar;
    private List<Team> teams;
    private List<Match> matchs;
    TeamDAO teamDAO = new TeamDAO();
    MatchDAO matchDAO = new MatchDAO();

    @FXML
    TableColumn<Match, String> localNameColumn;
    @FXML
    TableColumn<Match, Integer> localResultColumn;
    @FXML
    TableColumn<Match, String> visitorNameColumn;
    @FXML
    TableColumn<Match, Integer> visitorResultColumn;
    @FXML
    TableColumn<Match, Integer> matchweekColumn;

    public ObservableList<Match> matchObservableList;



    //añadir elementos de javafx y linkear con vista
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        matchObservableList= FXCollections.observableArrayList();
        localNameColumn.setCellValueFactory(new PropertyValueFactory<>("local"));
        localResultColumn.setCellValueFactory(new PropertyValueFactory<>("local_result"));
        visitorNameColumn.setCellValueFactory(new PropertyValueFactory<>("visitor"));
        visitorResultColumn.setCellValueFactory(new PropertyValueFactory<>("visitor_result"));
        matchweekColumn.setCellValueFactory(new PropertyValueFactory<>("matchweek"));

        loadMatchs();
    }

    public void loadMatchs() {
        try {
            matchs = matchDAO.findAll();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<Match> matchList = FXCollections.observableArrayList(matchs);
        table.setItems(matchList);
    }

    public void closeWindows() {
    }
}
