package az.The_Best.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import student.Student;

public class Student_Main_Controller {

    public Text student_email;
    public Text student_surname;
    public Text student_name;
    public AnchorPane news;
    public VBox sideMenu;

    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label emailLabel;

    private Student student;

    public void setStudent(Student student) {
        this.student = student;

        // Tələbə məlumatlarını ekranda göstər
        student_name.setText(student.getFirstName());
        student_surname.setText(student.getLastName());
        student_email.setText(student.getEmail());
    }
}
