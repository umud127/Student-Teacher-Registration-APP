package az.The_Best;

import Student.Student;
import Student.Student_Info_CRUD;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Student_Info_CRUD studentInfoCrud = new Student_Info_CRUD();

        studentInfoCrud.read();

        System.out.println();

        Student umud = new Student("Umud", "Shahmarov", "umudshahmarov@gmail.com", 19, 3);
        studentInfoCrud.update(umud);

        System.out.println();

        studentInfoCrud.read();
    }
}