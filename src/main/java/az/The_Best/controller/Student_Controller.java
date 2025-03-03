package az.The_Best.controller;

import student.Student;
import student.Student_Info_CRUD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Arrays;

public class Student_Controller {
    public TextField reg_name;
    public TextField reg_surname;
    public TextField reg_age;
    public TextField reg_password;
    public TextField reg_email;
    public Button btn_sign;
    public Button btn_reg;
    public TextField sign_password;
    public TextField sign_email;
    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        backButton.setOnAction(event -> goBack());
        btn_reg.setOnAction(event -> register());
        btn_sign.setOnAction(event -> sign());
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
            stage.setTitle("Starter of Program");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error Message: " + Arrays.toString(e.getStackTrace()));
        }
    }

    @FXML
    public void register() {
        Student student = null;

        try{
            student = new Student(reg_name.getText(),reg_surname.getText(),reg_email.getText(),Integer.parseInt(reg_age.getText()),false,null,reg_password.getText());
        } catch (Exception e) {
            System.out.println("Error msg: " + Arrays.toString(e.getStackTrace()));
            return;
        }

        Student_Info_CRUD studentInfoCrud = new Student_Info_CRUD();
        studentInfoCrud.create(student);

        // Cari pəncərəni bağlayır
        Stage currentStage = (Stage) btn_reg.getScene().getWindow();
        currentStage.close();
        System.out.println("The Window Closed");
        // Yeni pəncərə açır (Student_Main)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Student_Main.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println("Error msg: " + Arrays.toString(e.getStackTrace()));
            return;
        }
        Stage stage = new Stage();
        stage.setTitle("Student Panel");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
//        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.show();
        System.out.println("New Window is opened");
    }

    @FXML
    public void sign() {

        Student_Info_CRUD studentInfoCrud = new Student_Info_CRUD();
        Student student = studentInfoCrud.find(sign_email.getText(), sign_password.getText());

        if(student != null) {
            System.out.println("it works in sign method");
            // Cari pəncərəni bağlayır
            Stage currentStage = (Stage) btn_sign.getScene().getWindow();
            currentStage.close();
            System.out.println("The Window Closed");

            // Yeni pəncərə açır (Student_Cabinet)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Student_Main.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                System.out.println("Error msg: " + Arrays.toString(e.getStackTrace()));
                return;
            }
            Stage stage = new Stage();
            stage.setTitle("Student Panel");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
//        stage.setMaximized(true);
            stage.setFullScreen(true);
            stage.show();
            System.out.println("New Window is opened");
        }
        else {
            System.out.println("its null");
            //send a message window it's not found
        }
    }
}