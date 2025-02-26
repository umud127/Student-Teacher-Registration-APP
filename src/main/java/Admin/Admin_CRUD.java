package Admin;

import Interfaces.CRUD;

import java.sql.PreparedStatement;

public class Admin_CRUD extends CRUD<Admin> {

    //abstract methods override (CRUD)
    @Override
    public void create(Admin admin) {
        //add a new Admin
    }

    @Override
    public void read() {
        //get a Admin
    }

    @Override
    public void update(Admin admin) {
        //update a Admin
    }

    @Override
    public void delete() {
        //delete a Admin
    }

    //Methods help CRUD Methods
    @Override
    public void setStatementParams(PreparedStatement pstmt, Admin person) {

    }

    @Override
    public String getTableName() {
        return "";
    }

    @Override
    public String getDatabaseName() {
        return "";
    }
}
