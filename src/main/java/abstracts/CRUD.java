package abstracts;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class CRUD<T> {

    //abstract methods override (CRUD)
    public abstract void create(T person) throws SQLException;

    public abstract void read() ;

    public abstract void update(T person) ;

    public abstract void delete(int id);

    //Methods For CRUD Processes
    public abstract void setStatementParams(PreparedStatement pstmt, T person) throws SQLException;

    public abstract String getTableName();

    public abstract String getDatabaseName();
}
