package student;

import abstracts.CRUD;

import java.sql.*;
import java.util.Arrays;

import static db.DatabaseConnection.connect;

public class Student_Info_CRUD extends CRUD<Student> {

    //abstract methods override (CRUD)
    @Override
    public void setStatementParams(PreparedStatement pstmt, Student student) throws SQLException {
        pstmt.setString(1, student.getFirstName());
        pstmt.setString(2, student.getLastName());
        pstmt.setString(3, student.getEmail());
        pstmt.setInt(4, student.getAge());
        pstmt.setString(5,student.getPassword());
    }

    @Override
    public void create(Student student) {
        try (Connection conn = connect(getDatabaseName())) {
            conn.setAutoCommit(false); // Transaction başlat

            // 1️⃣ Əvvəlcədən sonuncu ID-ni tap
            int lastID = 0;
            String getLastID = "SELECT MAX(id) FROM " + getTableName();

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(getLastID)) {
                if (rs.next()) {
                    lastID = rs.getInt(1); // 🔥 Sonuncu uğurlu ID
                }
            }

            String query = "INSERT INTO " + getTableName() + " (first_name, last_name, email, age,password) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Student məlumatını əlavə et
                setStatementParams(pstmt, student);
                pstmt.executeUpdate();
                System.out.println("✅ Məlumat əlavə edildi: " + getTableName());

                // Has_teacher_CRUD istifadə edirik
                Has_teacher_CRUD hasTeacherCrud = new Has_teacher_CRUD();
                hasTeacherCrud.createWithConnection(student, conn);

                conn.commit(); // ✅ Hər şey uğurlu olarsa, commit edirik
            } catch (SQLException e) {
                conn.rollback(); // ❌ Xəta baş verərsə, AUTO_INCREMENT geri alınır
                System.out.println("❌ Xəta(create): " + e.getMessage());

                // 2️⃣ `AUTO_INCREMENT`-i əvvəlki dəyərə qaytar
                String resetAutoIncrement = "ALTER TABLE " + getTableName() + " AUTO_INCREMENT = ?";
                try (PreparedStatement resetStmt = conn.prepareStatement(resetAutoIncrement)) {
                    resetStmt.setInt(1, lastID + 1); // 🔥 Sonuncu uğurlu ID + 1
                    resetStmt.executeUpdate();
                    System.out.println("🔄 AUTO_INCREMENT bərpa olundu: " + (lastID + 1));
                }

                System.out.println("Save edilmədi və auto-increament işləmədi");
            } finally {
                conn.setAutoCommit(true); // 🔄 Safe mode-a qayıdırıq
            }
        } catch (SQLException e) {
            System.out.println("❌ Xəta(create): " + e.getMessage());
        }
    }

    @Override
    public void read () {
        String query = "SELECT * FROM " + getTableName();

        try (PreparedStatement pstmt = connect(getDatabaseName()).prepareStatement(query);
             ResultSet rs = pstmt.executeQuery();) {
            System.out.println("📌 Student Info:");

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                System.out.println();

                System.out.println("🆔 ID: " + id +
                                   ", 👤 Name: " + firstName + " " + lastName +
                                   ", 📧 Email: " + email +
                                   ", 🎂 Age: " + age);
            }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public void update (Student student) {
        String query = "UPDATE " + getTableName() + " SET first_name = ?, last_name = ?, email = ?, age = ? WHERE id = ?";

        try (Connection conn = connect(getDatabaseName());
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Yeni məlumatları set edirik
            setStatementParams(pstmt, student);
            pstmt.setInt(5, student.getId()); // ID parametr olaraq əlavə edilir

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ Məlumat yeniləndi: " + getTableName());
            } else {
                System.out.println("⚠️ Yenilənəcək tələbə tapılmadı: ID = " + student.getId());
            }
        } catch (SQLException e) {
            System.out.println("❌ Xəta(update): " + e.getMessage());
        }
    }

    @Override
    public void delete (int id) {
        String query = "DELETE FROM " + getTableName() + " WHERE id = ?";

        try (Connection conn = connect(getDatabaseName());
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("✅ Məlumat silindi (ID: " + id + ")");
            } else {
                System.out.println("⚠️ Belə bir ID tapılmadı: " + id);
            }

        } catch (SQLException e) {
            System.out.println("❌ Xəta(delete): " + e.getMessage());
        }
    }

    public Student find(String email, String password) {
        String query = "SELECT * FROM student_info WHERE email = ? AND password = ?";

        Student student = null;

        try (PreparedStatement pstmt = connect(getDatabaseName()).prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                Timestamp timestamp = rs.getTimestamp("registration_date");

                Has_teacher_CRUD hasTeacherCrud = new Has_teacher_CRUD();

                student = new Student(firstName, lastName, email,age, hasTeacherCrud.find(id).getHasTeacher(), hasTeacherCrud.find(id).getTeacherName(),password);
            }
        } catch (SQLException e) {
            System.out.println("Error msg: " + Arrays.toString(e.getStackTrace()));
        }

        return student;
    }

    //Additional Methods
    @Override
    public String getTableName () {
        return "student_info";
    }

    @Override
    public String getDatabaseName () {
        return "student";
    }
}