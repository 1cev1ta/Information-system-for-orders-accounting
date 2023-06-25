package dao.implementations;

import dao.models.OrderTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderTableDAO {

    public static void insertOrderTable(String NZ, String NK, String ID_manager, String ID_auto, String Date, String orderPrice) throws SQLException,ClassNotFoundException{
        String sql = "insert into [Order] ([NK (FK)],[ID_manager (FK)],[ID_auto (FK)],Date,Sum) values('"+NK+"','"+ID_manager+"','"+ID_auto+"','"+Date+"','"+orderPrice+"');";
        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:insertEmployee " +e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void updateOrderTable(String NZ, String NK, String ID_manager, String ID_auto, String Date, String orderPrice) throws SQLException,ClassNotFoundException{
        String sql = "UPDATE [Order] SET [NK (FK)] = '"+NK+"',[ID_manager (FK)] = '"+ID_manager+"',[ID_auto (FK)] = '"+ID_auto+"',Date = '"+Date+"' ,Sum = '"+orderPrice+"' WHERE NZ = '"+NZ+"';";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:updateEmployee! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteOrderById(int NZ) throws ClassNotFoundException,SQLException{
        String sql = "delete from [Order] where NZ = '"+NZ+"';";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Исключение возникает в ManagerPageDAO:deleteEmployeeById! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<OrderTable> getAllRecords_OrderTable() throws ClassNotFoundException,SQLException{
        String sql = "select * from [Order]";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<OrderTable> orderTableList = getOrderObjects(rsSet);
            return orderTableList;
        }catch(SQLException e){
            System.out.println("Исключение возникает в OrderTableDAO:getAllRecords! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<OrderTable> getOrderObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{

        try {
            ObservableList<OrderTable> orderTableList = FXCollections.observableArrayList();

            while(rsSet.next()){
                OrderTable ord = new OrderTable();
                ord.setOrdId(rsSet.getInt("NZ"));
                ord.setClientId(rsSet.getInt("NK (FK)"));
                ord.setManagerId(rsSet.getInt("ID_manager (FK)"));
                ord.setAutomobileId(rsSet.getInt("ID_auto (FK)"));
                ord.setDateOrderProperty(rsSet.getString("Date"));
                ord.setOrderPr(rsSet.getDouble("Sum"));
                orderTableList.add(ord);
            }
            return orderTableList;
        }catch(SQLException e){
            System.out.println("Исключение возникает в OrderTableDAO:getOrderObjects! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<OrderTable> searchOrder (int NZ) throws ClassNotFoundException,SQLException{
        String sql = "select * from [Order] where NZ = "+NZ;
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<OrderTable> list = getOrderObjects(rsSet);
            return list;
        }catch (SQLException e){
            System.out.println("Исключение возникает в OrderTableDAO:searchEmployee! " + e);
            e.printStackTrace();
            throw e;
        }
    }
}

