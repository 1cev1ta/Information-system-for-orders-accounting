package dao.implementations;

import dao.models.DetailsTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailsTableDAO {

    public static void insertDetailsTable(String ID_details, String Name_details, String Quantity, String Price, String Producer) throws SQLException,ClassNotFoundException{
        String sql = "insert into [Details] (Name_details,Quantity,Price,Producer) values('"+Name_details+"','"+Quantity+"','"+Price+"','"+Producer+"');";
        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в DetailsTableDAO:insertDetailsTable " +e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void updateDetailsTable(String ID_details, String Name_details, String Quantity, String Price, String Producer) throws SQLException,ClassNotFoundException{
        String sql = "UPDATE [Details] SET Name_details = '"+Name_details+"',Quantity = '"+Quantity+"',Price = '"+Price+"',Producer = '"+Producer+"' WHERE ID_details = '"+ID_details+"';";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Исключение возникает в DetailsTableDAO:updateDetailsTable! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteDetailById(int ID_details) throws ClassNotFoundException,SQLException{
        String sql = "delete from [Details] where ID_details = '"+ID_details+"';";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Исключение возникает в DetailsTableDAO:deleteDetailById! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<DetailsTable> getAllRecords_DetailsTable() throws ClassNotFoundException,SQLException{
        String sql = "select * from [Details]";

        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<DetailsTable> detailsTableList = getDetailsObjects(rsSet);
            return detailsTableList;
        }catch(SQLException e){
            System.out.println("Исключение возникает в DetailsTableDAO:getAllRecords_DetailsTable! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<DetailsTable> getDetailsObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException{

        try {
            ObservableList<DetailsTable> detailsTableList = FXCollections.observableArrayList();

            while(rsSet.next()){
                DetailsTable detail = new DetailsTable();
                detail.setDetailId(rsSet.getInt("ID_details"));
                detail.setNameDetailProperty(rsSet.getString("Name_details"));
                detail.setQuantityDetailsProperty(rsSet.getInt("Quantity"));
                detail.setPriceDetail(rsSet.getDouble("Price"));
                detail.setProducerDetail(rsSet.getString("Producer"));
                detailsTableList.add(detail);
            }
            return detailsTableList;
        }catch(SQLException e){
            System.out.println("Исключение возникает в DetailsTableDAO:getDetailsObjects! " + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<DetailsTable> searchDetail (int ID_details) throws ClassNotFoundException,SQLException{
        String sql = "select * from [Details] where ID_details = "+ID_details;
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<DetailsTable> list = getDetailsObjects(rsSet);
            return list;
        }catch (SQLException e){
            System.out.println("Исключение возникает в DetailsTableDAO:searchDetail! " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
