package dao.models;

import javafx.beans.property.*;

public class OrderTable {

    private IntegerProperty orderIdProperty_OrderTable;

    private IntegerProperty clientIDProperty_OrderTable;

    private IntegerProperty managerIDProperty_OrderTable;

    private IntegerProperty autoIDProperty_OrderTable;

    private StringProperty dateOrderProperty_OrderTable;

    private DoubleProperty orderPriceProperty_OrderTable;

    public OrderTable(){
        this.orderIdProperty_OrderTable = new SimpleIntegerProperty();
        this.clientIDProperty_OrderTable = new SimpleIntegerProperty();
        this.managerIDProperty_OrderTable = new SimpleIntegerProperty();
        this.autoIDProperty_OrderTable = new SimpleIntegerProperty();
        this.dateOrderProperty_OrderTable = new SimpleStringProperty();
        this.orderPriceProperty_OrderTable = new SimpleDoubleProperty();
    }

    //this is for Order ID
    public int getOrdId(){
        return orderIdProperty_OrderTable.get();
    }

    public void setOrdId(int idOrder){
        this.orderIdProperty_OrderTable.set(idOrder);
    }

    public IntegerProperty getOrderId(){
        return orderIdProperty_OrderTable;
    }


    //this is for Client ID
    public int getCliId(){
        return clientIDProperty_OrderTable.get();
    }

    public void setClientId(int idClient){
        this.clientIDProperty_OrderTable.set(idClient);
    }

    public IntegerProperty getClientId(){
        return clientIDProperty_OrderTable;
    }

    //this is for Manager ID
    public int getManagId(){
        return managerIDProperty_OrderTable.get();
    }

    public void setManagerId(int idManager){
        this.managerIDProperty_OrderTable.set(idManager);
    }

    public IntegerProperty getManagerId(){
        return managerIDProperty_OrderTable;
    }


    //this is for Automobile ID
    public int getAutoId(){
        return autoIDProperty_OrderTable.get();
    }

    public void setAutomobileId(int idAuto){
        this.autoIDProperty_OrderTable.set(idAuto);
    }

    public IntegerProperty getAutomobileId(){
        return autoIDProperty_OrderTable;
    }


    //this is for Date Order
    public String getDateOrdProperty(){
        return dateOrderProperty_OrderTable.get();
    }

    public void setDateOrderProperty(String dateOrder){
        this.dateOrderProperty_OrderTable.set(dateOrder);
    }

    public StringProperty getDateOrderProperty(){
        return dateOrderProperty_OrderTable;
    }

    //this is for Order Price
    public double getOrderPr(){
        return orderPriceProperty_OrderTable.get();
    }

    public void setOrderPr(double orderPrice){
        this.orderPriceProperty_OrderTable.set(orderPrice);
    }

    public DoubleProperty getOrderPrice(){
        return orderPriceProperty_OrderTable;
    }
}
