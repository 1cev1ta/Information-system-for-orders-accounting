package dao.models;

import javafx.beans.property.*;

public class ManagerTable {

    private IntegerProperty managerIdProperty_ManagerTable;

    private StringProperty fioProperty_ManagerTable;

    private StringProperty phoneProperty_ManagerTable;

    private IntegerProperty experienceProperty_ManagerTable;

    private DoubleProperty salaryProperty_ManagerTable;

    public ManagerTable(){
        this.managerIdProperty_ManagerTable = new SimpleIntegerProperty();
        this.fioProperty_ManagerTable = new SimpleStringProperty();
        this.phoneProperty_ManagerTable = new SimpleStringProperty();
        this.experienceProperty_ManagerTable = new SimpleIntegerProperty();
        this.salaryProperty_ManagerTable = new SimpleDoubleProperty();
    }

    //this is for Manager ID
    public int getManagID(){
        return managerIdProperty_ManagerTable.get();
    }

    public void setManagerId(int idManager){
        this.managerIdProperty_ManagerTable.set(idManager);
    }

    public IntegerProperty getManagerId(){
        return managerIdProperty_ManagerTable;
    }


    //this is for FIO
    public String getFIOProperty(){
        return fioProperty_ManagerTable.get();
    }

    public void setFIOProperty(String FIO){
        this.fioProperty_ManagerTable.set(FIO);
    }

    public StringProperty getFIOManagerProperty(){
        return fioProperty_ManagerTable;
    }

    //this is for Phone
    public String getPhoneProperty(){
        return phoneProperty_ManagerTable.get();
    }

    public void setPhoneProperty(String Phone){
        this.phoneProperty_ManagerTable.set(Phone);
    }

    public StringProperty getPhoneManagerProperty(){
        return phoneProperty_ManagerTable;
    }


    //this is for Experience
    public int getExp(){
        return experienceProperty_ManagerTable.get();
    }

    public void setExp(int Experience){
        this.experienceProperty_ManagerTable.set(Experience);
    }

    public IntegerProperty getExperience(){
        return experienceProperty_ManagerTable;
    }


    //this is for Salary
    public double getSalary(){
        return salaryProperty_ManagerTable.get();
    }

    public void setSalary(double Salary){
        this.salaryProperty_ManagerTable.set(Salary);
    }

    public DoubleProperty getSalaryManager(){
        return salaryProperty_ManagerTable;
    }

}
