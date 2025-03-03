package az.The_Best.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Arrays;

public class Admin_Controller {
    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        backButton.setOnAction(event -> goBack());
    }

    private void goBack() {
        try {
            // Cari pəncərəni bağlayır
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.close();

            // Yeni pəncərə açır (FirstScreen.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/FirstScreen.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Start Screen");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error Message: " + Arrays.toString(e.getStackTrace()));
        }
    }
}
