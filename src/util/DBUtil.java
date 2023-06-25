package util;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtil {
    //Connection
    private static Connection connection = null;

    //Connect to DB
    public static void dbConnect() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://DESKTOP-NPCS35Q\\SQLEXPRESS;database=diplomDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
            connection = DriverManager.getConnection(dburl);
            System.out.println("Connected to Microsoft SQL Server");
        } catch (ClassNotFoundException ex) {
            System.out.println("Oops,there's an error: ");
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //этот метод предназначен для операций вставки / удаления / обновления даннных в базе данных
    public static void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch(SQLException e) {
            System.out.println("Проблема возникла в  DBUtil:dbExecuteQuery : " + e);
            throw e;
        }
        finally {
            if (stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    //этот метод предназначен для извлечения записей из базы данных (извлечение данных из DB)
    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException,SQLException{
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSet crs = null;

        try{
            dbConnect();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);
        }catch(SQLException e){
            System.out.println("Проблема возникла в  DBUtil:dbExecute : "+e);
            throw e;
        }
        finally {
            if (rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }
}
