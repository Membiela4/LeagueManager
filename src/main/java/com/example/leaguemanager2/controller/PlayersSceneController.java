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
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;
import org.controlsfx.control.action.Action;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PlayersSceneController implements Initializable {

    PlayerDAO playerDAO = new PlayerDAO();

    @FXML
    private Button backBtn;

    @FXML
    private Button closeButton;
    @FXML
    private Button addPlayerBtn;
    @FXML
    private Button deletePlayerBtn;
    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<Player, Integer> idColumn;
    @FXML
    private TableColumn<Player, String> nameColumn;
    @FXML
    private TableColumn<Player, String> aliasColumn;
    @FXML
    private TableColumn<Player, Integer> dorsalColumn;
    @FXML
    private TableColumn<Player, Team> teamColumn;
    @FXML
    private Button refreshBtn;

    private ObservableList<Player> playersList;
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

        playersList = FXCollections.observableArrayList();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("player_id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        aliasColumn.setCellValueFactory(new PropertyValueFactory<>("alias"));
        dorsalColumn.setCellValueFactory(new PropertyValueFactory<>("dorsal"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));

        loadPlayers();
    }

    @FXML
    private void addPlayer(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/leaguemanager2/addPlayer.fxml"));
        try {
            Parent root = loader.load();

            AddPlayerController controller = loader.getController();
            Scene scene =new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
            
            Player p = controller.getPlayer();
            if (p != null) {
                playerDAO.save(p);
                playersList.add(p);
                loadPlayers();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadPlayers()  {
        List<Player> players = null;
        try {
            players = playerDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        playersList.clear();

        playersList.addAll(players);

        table.setItems(playersList);
    }
    @FXML
    private void modify(ActionEvent event) {
        Player p = this.table.getSelectionModel().getSelectedItem();

        if(p==null) {
            //alert
        }else{
            try {
                String name = this.nameColumn.getText();
                Player aux =playerDAO.findByName(name);
                this.table.refresh();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    private void delete(ActionEvent event) {
        Player p = this.table.getSelectionModel().getSelectedItem();

        if(p==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("no se ha encontrado jugador");
            alert.showAndWait();
        }else{
            playersList.remove(p);
            try {
                playerDAO.delete(p);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            this.table.refresh();
        }
    }
    @FXML
    private void refresh() {
        this.table.refresh();
    }
}




