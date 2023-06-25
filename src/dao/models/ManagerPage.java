package dao.models;

import javafx.beans.property.*;

public class ManagerPage {

    private IntegerProperty orderIdProperty;

    private StringProperty fioClientProperty;

    private StringProperty fioManagerProperty;

    private StringProperty detailNameProperty;

    private IntegerProperty quantityDetailsProperty;

    private StringProperty carBrandProperty;

    private DoubleProperty orderPriceProperty;

    public ManagerPage(){
        this.orderIdProperty = new SimpleIntegerProperty();
        this.fioClientProperty = new SimpleStringProperty();
        this.fioManagerProperty = new SimpleStringProperty();
        this.detailNameProperty = new SimpleStringProperty();
        this.quantityDetailsProperty = new SimpleIntegerProperty();
        this.carBrandProperty = new SimpleStringProperty();
        this.orderPriceProperty = new SimpleDoubleProperty();
    }

    //this is for Order ID
    public int getOrdId(){
        return orderIdProperty.get();
    }

    public void setOrdId(int idOrder){
        this.orderIdProperty.set(idOrder);
    }

    public IntegerProperty getOrderId(){
        return orderIdProperty;
    }


    //this is for Client FIO
    public String getFIOCliName(){
        return fioClientProperty.get();
    }

    public void setFIOCliName(String FIOClient){
        this.fioClientProperty.set(FIOClient);
    }

    public StringProperty getFIOClientName(){
        return fioClientProperty;
    }

    //this is for Manager FIO
    public String getFIOManName(){
        return fioManagerProperty.get();
    }

    public void setFIOManName(String FIOManager){
        this.fioManagerProperty.set(FIOManager);
    }

    public StringProperty getFIOManagerName(){
        return fioManagerProperty;
    }


    //this is for Detail Name
    public String getDetName(){
        return detailNameProperty.get();
    }

    public void setDetName(String detailName){
        this.detailNameProperty.set(detailName);
    }

    public StringProperty getDetailName(){
        return detailNameProperty;
    }


    //this is for Quantity Details
    public int getQuanDetails(){
        return quantityDetailsProperty.get();
    }

    public void setQuanDetails(int quantityDetails){
        this.quantityDetailsProperty.set(quantityDetails);
    }
    public IntegerProperty getQuantityDetails(){
        return quantityDetailsProperty;
    }

    //this is for Detail Brand Name
    public String getCarBrProperty(){
        return carBrandProperty.get();
    }

    public void setCarBrProperty(String carBrandName){
        this.carBrandProperty.set(carBrandName);
    }

    public StringProperty getCarBrandProperty(){
        return carBrandProperty;
    }

    //this is for Order Price
    public double getOrderPr(){
        return orderPriceProperty.get();
    }

    public void setOrderPr(double orderPrice){
        this.orderPriceProperty.set(orderPrice);
    }

    public DoubleProperty getOrderPrice(){
        return orderPriceProperty;
    }
}
