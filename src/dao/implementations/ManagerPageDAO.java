package dao.implementations;

import dao.models.ManagerPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerPageDAO {

    public static void insertEmployee(String FIOClient,String FIOManager, String detailName, String quantityDetails,String carBrandName,String orderPrice) throws SQLException,ClassNotFoundException{
        String sql = "insert into Manager_Operations(FIOClient,FIOManager,detailName,quantityDetails,carBrandName,orderPrice) values('"+FIOClient+"','"+FIOManager+"','"+detailName+"','"+quantityDetails+"','"+carBrandName+"','"+orderPrice+"');";
        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:insertEmployee " +e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void updateEmployee(int idOrder,String FIOClient,String FIOManager, String detailName, int quantityDetails,String carBrandName,double orderPrice) throws SQLException,ClassNotFoundException{
        String sql = "UPDATE Manager_Operations SET FIOClient = '"+FIOClient+"',FIOManager = '"+FIOManager+"',detailName = '"+detailName+"',quantityDetails = '"+quantityDetails+"',carBrandName = '"+carBrandName+"' ,orderPrice = '"+orderPrice+"' WHERE idOrder = '"+idOrder+"' ";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:updateEmployee! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteEmployeeById(int idOrder) throws ClassNotFoundException,SQLException{
        String sql = "delete from Manager_Operations where idOrder = '"+idOrder+"'";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:deleteEmployeeById! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<ManagerPage> getAllRecords() throws ClassNotFoundException,SQLException{
        String sql = "select * from Manager_Operations";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<ManagerPage> empList = getEmployeeObjects(rsSet);
            return empList;
        }catch(SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:getAllRecords! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<ManagerPage> getEmployeeObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{

        try {
            ObservableList<ManagerPage> emplist = FXCollections.observableArrayList();

            while(rsSet.next()){
                ManagerPage emp = new ManagerPage();
                emp.setOrdId(rsSet.getInt("idOrder"));
                emp.setFIOCliName(rsSet.getString("FIOClient"));
                emp.setFIOManName(rsSet.getString("FIOManager"));
                emp.setDetName(rsSet.getString("detailName"));
                emp.setQuanDetails(rsSet.getInt("quantityDetails"));
                emp.setCarBrProperty(rsSet.getString("carBrandName"));
                emp.setOrderPr(rsSet.getDouble("orderPrice"));
                emplist.add(emp);
            }
            return emplist;
        }catch(SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:getAllRecords! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<ManagerPage> searchEmployee (int idOrder) throws ClassNotFoundException,SQLException{
        String sql = "select * from Manager_Operations where idOrder = "+idOrder;
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<ManagerPage> list = getEmployeeObjects(rsSet);
            return list;
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:searchEmployee! " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
