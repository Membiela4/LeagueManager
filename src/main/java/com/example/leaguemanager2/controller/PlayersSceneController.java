package com.example.leaguemanager2.controller;

import com.example.leaguemanager2.dao.PlayerDAO;
import com.example.leaguemanager2.modelDomain.Player;
import com.example.leaguemanager2.modelDomain.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PlayersSceneController implements Initializable {

    PlayerDAO playerDAO =new PlayerDAO();

    @FXML
    private Button backBtn;

    @FXML
    private Button closeButton;
    @FXML
    private Button addpPlayerBtn;
    @FXML
    private Button deletePlayerBtn;
    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<Player,Integer> idColumn;
    @FXML
    private TableColumn<Player, String> nameColumn;
    @FXML
    private TableColumn<Player, String> aliasColumn;
    @FXML
    private TableColumn<Player,Integer> dorsalColumn;
    @FXML
    private TableColumn<Player,Team> teamColumn;






    public void closeWindows() {
    }

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();;
        currentStage = (Stage) closeButton.getScene().getWindow();
        currentStage.close();
    }

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/leaguemanager2/mainScene.fxml"));
        //loader.setLocation(new URL("file:/C:/Users/Acer%20E15/Desktop/Programación/LeagueManager/src/main/resources/com/example/leaguemanager2/mainScene.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.idColumn.setCellFactory(new PropertyValueFactory("player_id"));
        this.nameColumn.setCellFactory(new PropertyValueFactory("name"));
        this.aliasColumn.setCellFactory(new PropertyValueFactory("alias"));
        this.dorsalColumn.setCellFactory(new PropertyValueFactory("dorsal"));
        this.teamColumn.setCellFactory(new PropertyValueFactory("team_id"));

        try {
            loadPlayers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void addPlayer() {

    }

    public void loadPlayers() throws SQLException {

        List<Player> players = playerDAO.findAll();
        ObservableList<Player> playersList = FXCollections.observableArrayList(players);
        table.setItems(playersList);
    }
}
