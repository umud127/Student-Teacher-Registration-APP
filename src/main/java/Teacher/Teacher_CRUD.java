package Teacher;

import Interfaces.CRUD;

import java.sql.PreparedStatement;

public class Teacher_CRUD extends CRUD<Teacher> {

    //abstract methods override (CRUD)
    @Override
    public void create(Teacher teacher) {
        //add a new Teacher
    }

    @Override
    public void setStatementParams(PreparedStatement pstmt, Teacher person) {

    }

    @Override
    public void read() {
        //get a Teacher
    }

    @Override
    public void update(Teacher teacher) {
        //update a Teacher
    }

    @Override
    public void delete() {
        //delete a Teacher
    }

    @Override
    public String getTableName() {
        return "teacher_info";
    }

    @Override
    public String getDatabaseName() {
        return "teacher";
    }
}
