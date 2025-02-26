package Teacher;

import Interfaces.CRUD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teacher_Students_CRUD extends CRUD {

    @Override
    public void create(Object person) throws SQLException {

    }

    @Override
    public void read() {

    }

    @Override
    public void update(Object person) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void setStatementParams(PreparedStatement pstmt, Object person) throws SQLException {

    }

    @Override
    public String getTableName() {
        return "students";
    }

    @Override
    public String getDatabaseName() {
        return "teacher";
    }
}
