package az.The_Best.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import student.Student;
import student.Student_Info_CRUD;

public class Student_Main_Controller {

    public Text student_email;
    public Text student_surname;
    public Text student_name;
    public AnchorPane news;
    public VBox sideMenu;
    @FXML
    private ImageView profileImage;
    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label emailLabel;

    private final Student_Info_CRUD studentCrud = new Student_Info_CRUD();

}
