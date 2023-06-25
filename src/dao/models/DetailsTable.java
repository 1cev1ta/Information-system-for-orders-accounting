package dao.models;

import javafx.beans.property.*;

public class DetailsTable {

    private IntegerProperty detailIdProperty_DetailsTable;

    private StringProperty nameDetailProperty_DetailsTable;

    private IntegerProperty quantityProperty_DetailsTable;

    private DoubleProperty priceProperty_DetailsTable;

    private StringProperty producerProperty_DetailsTable;

    public DetailsTable(){
        this.detailIdProperty_DetailsTable = new SimpleIntegerProperty();
        this.nameDetailProperty_DetailsTable = new SimpleStringProperty();
        this.quantityProperty_DetailsTable = new SimpleIntegerProperty();
        this.priceProperty_DetailsTable = new SimpleDoubleProperty();
        this.producerProperty_DetailsTable = new SimpleStringProperty();
    }

    //this is for Detail ID
    public int getDetID(){
        return detailIdProperty_DetailsTable.get();
    }

    public void setDetailId(int idDetail){
        this.detailIdProperty_DetailsTable.set(idDetail);
    }

    public IntegerProperty getDetailId(){
        return detailIdProperty_DetailsTable;
    }


    //this is for Name Detail
    public String getNameDetProperty(){
        return nameDetailProperty_DetailsTable.get();
    }

    public void setNameDetailProperty(String Name){
        this.nameDetailProperty_DetailsTable.set(Name);
    }

    public StringProperty getNameDetailProperty(){
        return nameDetailProperty_DetailsTable;
    }

    //this is for Quantity Details
    public int getQuanProperty(){
        return quantityProperty_DetailsTable.get();
    }

    public void setQuantityDetailsProperty(int Quantity){
        this.quantityProperty_DetailsTable.set(Quantity);
    }

    public IntegerProperty getQuantityDetailsProperty(){
        return quantityProperty_DetailsTable;
    }


    //this is for Price Detail
    public double getPriceDet(){
        return priceProperty_DetailsTable.get();
    }

    public void setPriceDetail(double Price){
        this.priceProperty_DetailsTable.set(Price);
    }

    public DoubleProperty getPriceDetail(){
        return priceProperty_DetailsTable;
    }


    //this is for Producer Detail
    public String getProducer(){
        return producerProperty_DetailsTable.get();
    }

    public void setProducerDetail(String Producer){
        this.producerProperty_DetailsTable.set(Producer);
    }

    public StringProperty getProducerDetail(){
        return producerProperty_DetailsTable;
    }

}

