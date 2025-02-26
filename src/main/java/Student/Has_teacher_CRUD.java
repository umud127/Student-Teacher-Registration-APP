package Student;

import DB.DatabaseConnection;
import Interfaces.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Has_teacher_CRUD extends CRUD<Student> {

    //CRUD Methods
    @Override
    public void create(Student student) {
        String query = "INSERT INTO " + getTableName() + " VALUES (null, ?, ?)";

        try (Connection conn = DatabaseConnection.connect(getDatabaseName());
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            setStatementParams(pstmt, student);

            pstmt.executeUpdate();
            System.out.println("✅ Məlumat əlavə edildi: " + getTableName());
        } catch (SQLException e) {
            System.out.println("❌ Xəta(create): " + e.getMessage());
        }
    }

    @Override
    public void read() {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete() {

    }

    //Additional Methods
    @Override
    public void setStatementParams(PreparedStatement pstmt, Student student) throws SQLException {
        pstmt.setBoolean(1, student.getHasTeacher());
        pstmt.setString(2, student.getTeacherName());
    }

    @Override
    public String getTableName() {
        return "has_teacher";
    }

    @Override
    public String getDatabaseName() {
        return "student";
    }

    public void createWithConnection(Student student, Connection conn) {
        String query = "INSERT INTO " + getTableName() + " (has_teacher, teacher_name) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            setStatementParams(pstmt, student);
            pstmt.executeUpdate();
            System.out.println("✅ Has_teacher məlumatı əlavə edildi: " + getTableName());
        } catch (SQLException e) {
            System.out.println("❌ Xəta(create): " + e.getMessage());
        }
    }
}
