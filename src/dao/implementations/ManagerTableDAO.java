package dao.implementations;

import dao.models.ManagerTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerTableDAO {

    public static void insertManagerTable(String ID_manager, String FIO, String Phone, String Experience, String Salary) throws SQLException,ClassNotFoundException{
        String sql = "insert into [Manager] (FIO,Phone,Experience,Salary) values('"+FIO+"','"+Phone+"','"+Experience+"','"+Salary+"');";
        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerTableDAO:insertManagerTable! " +e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void updateManagerTable(String ID_manager, String FIO, String Phone, String Experience, String Salary) throws SQLException,ClassNotFoundException{
        String sql = "UPDATE [Manager] SET FIO = '"+FIO+"',Phone = '"+Phone+"',Experience = '"+Experience+"' ,Salary = '"+Salary+"' WHERE ID_manager = '"+ID_manager+"';";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerTableDAO:updateManagerTable! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteManagerById(int ID_manager) throws ClassNotFoundException,SQLException{
        String sql = "delete from [Manager] where ID_manager = '"+ID_manager+"';";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Исключение возникает в ManagerTableDAO:deleteManagerById! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<ManagerTable> getAllRecords_ManagerTable() throws ClassNotFoundException,SQLException{
        String sql = "select * from [Manager]";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<ManagerTable> managerTableList = getManagerObjects(rsSet);
            return managerTableList;
        }catch(SQLException e){
            System.out.println("Исключение возникает в ManagerTableDAO:getAllRecords_ManagerTable! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<ManagerTable> getManagerObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{

        try {
            ObservableList<ManagerTable> managerTableList = FXCollections.observableArrayList();

            while(rsSet.next()){
                ManagerTable ord = new ManagerTable();
                ord.setManagerId(rsSet.getInt("ID_manager"));
                ord.setFIOProperty(rsSet.getString("FIO"));
                ord.setPhoneProperty(rsSet.getString("Phone"));
                ord.setExp(rsSet.getInt("Experience"));
                ord.setSalary(rsSet.getDouble("Salary"));
                managerTableList.add(ord);
            }
            return managerTableList;
        }catch(SQLException e){
            System.out.println("Исключение возникает в ManagerTableDAO:getManagerObjects! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<ManagerTable> searchManager (int ID_manager) throws ClassNotFoundException,SQLException{
        String sql = "select * from [Manager] where ID_manager = "+ID_manager;
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<ManagerTable> list = getManagerObjects(rsSet);
            return list;
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerTableDAO:searchManager! " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
