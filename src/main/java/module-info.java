module com.example.leaguemanager2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.leaguemanager2 to javafx.fxml;
    exports com.example.leaguemanager2;
}