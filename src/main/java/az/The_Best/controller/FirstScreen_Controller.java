package az.The_Best.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class FirstScreen_Controller {
    @FXML
    private Button admin_button;

    @FXML
    private Button teacher_button;

    @FXML
    private Button student_button;

    @FXML
    public void initialize() {
        admin_button.setOnAction(event -> {
            System.out.println("Admin düyməsinə basıldı!");
            switchWindow("/gui/Admin.fxml", "Admin Panel");
        });

        teacher_button.setOnAction(event -> {
            System.out.println("Teacher düyməsinə basıldı!");
            switchWindow("/gui/Teacher.fxml", "Teacher Panel");
        });

        student_button.setOnAction(event -> {
            System.out.println("Student düyməsinə basıldı!");
            switchWindow("/gui/Student.fxml", "Student Panel");
        });
    }

    private void switchWindow(String fxmlPath, String title) {
        try {
            // closing first screen when button is pressed
            Stage currentStage = (Stage) admin_button.getScene().getWindow();
            currentStage.close();

            // open new screen that is related button u press
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error Message: " + Arrays.toString(e.getStackTrace()));
        }
    }
}