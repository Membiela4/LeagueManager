package com.example.leaguemanager2.controller;

import com.example.leaguemanager2.modelDomain.Player;
import com.example.leaguemanager2.modelDomain.Team;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPlayerController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField aliasField;
    @FXML
    private TextField dorsalField;
    @FXML
    private ChoiceBox teamField;
    @FXML
    private Button saveBtn;
    @FXML
    private Button  backBtn;

    private Player player;
    @FXML
    private ObservableList<Player> players;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void initAtributtes(ObservableList<Player> players) {
        this.players = players;
    }

    @FXML
    public void savePlayer(ActionEvent event) {

        String name = this.nameField.getText();
        String lastName = this.lastNameField.getText();
        String alias = this.aliasField.getText();
        int dorsal = Integer.parseInt(this.dorsalField.getText());
        Team team = (Team) teamField.getValue();

         Player p = new Player(name,lastName,alias,dorsal,team);

         if(!players.contains(p)){
             this.player = p;
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("INFO");
             alert.setContentText("Añadido Correctamente");
             alert.showAndWait();

             Stage stage = (Stage) this.saveBtn.getScene().getWindow();
             stage.close();
         }else{
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERROR");
             alert.setContentText("Jugador ya existente");
             alert.showAndWait();
         }
    }

    @FXML
    private void back(ActionEvent event){
        this.player=null;
        Stage stage = (Stage) this.saveBtn.getScene().getWindow();
        stage.close();

    }

    public Player getPlayer() {
        return player;
    }
}
