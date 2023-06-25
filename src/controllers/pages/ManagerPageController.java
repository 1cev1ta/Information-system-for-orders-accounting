package controllers.pages;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.models.ManagerPage;
import dao.implementations.ManagerPageDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class ManagerPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ManagerPage,Integer> colOrderId;
    @FXML
    private TableColumn<ManagerPage,String> colFIOClient;
    @FXML
    private TableColumn<ManagerPage,String> colFIOManager;
    @FXML
    private TableColumn<ManagerPage,String> colDetailName;
    @FXML
    private TableColumn<ManagerPage,Integer> colQuantityDetails;
    @FXML
    private TableColumn<ManagerPage,String> colCarBrandName;
    @FXML
    private TableColumn<ManagerPage,Double> colOrderPrice;

    @FXML
    private TableView<ManagerPage> employeeTable;

    @FXML
    private TextArea resultConsole;

    @FXML
    private TextField searchOrderId;

    @FXML
    private TextField txtOrderID;

    @FXML
    private TextField txtCarBrandName;

    @FXML
    private TextField txtDetailName;

    @FXML
    private TextField txtFIOClient;

    @FXML
    private TextField txtFIOManager;

    @FXML
    private TextField txtOrderPrice;

    @FXML
    private TextField txtQuantityDetails;

    @FXML
    private Button exitButton;

    @FXML
    void deleteEmployee(ActionEvent event) throws ClassNotFoundException,SQLException{

        try{
            ManagerPageDAO.deleteEmployeeById(Integer.parseInt(searchOrderId.getText()));
            resultConsole.setText("Операция выполнена успешно!\nДанные были удалены из базы данных.");
            ObservableList<ManagerPage> empList = ManagerPageDAO.getAllRecords();
            populateTable(empList);
        }catch (SQLException e){
            System.out.println("Исключение возникает в EmployeeController:deleteEmployee "+e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    void insertEmployee(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
            ManagerPageDAO.insertEmployee(txtFIOClient.getText(), txtFIOManager.getText(), txtDetailName.getText(), txtQuantityDetails.getText(),txtCarBrandName.getText(),txtOrderPrice.getText());
            resultConsole.setText("Операция выполнена успешно!\nДанные были загружены в базу данных.");
            ObservableList<ManagerPage> empList = ManagerPageDAO.getAllRecords();
            populateTable(empList);
        }
        catch(SQLException e){
            System.out.println("Исключение возникает в EmployeeController:insertEmployee "+e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void searchAllEmployees(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<ManagerPage> empList = ManagerPageDAO.getAllRecords();
        populateTable(empList);
    }

    @FXML
    private void searchEmployee(ActionEvent event) throws ClassNotFoundException, SQLException{
        ObservableList<ManagerPage> list = ManagerPageDAO.searchEmployee(Integer.parseInt(searchOrderId.getText()));
        if(list.size() > 0){
            populateTable(list);
            resultConsole.setText("Значение было найдено в таблице");
        }else{
            resultConsole.setText("Значение не было найдено в таблице");
        }
    }

    @FXML
    void updateEmployee(ActionEvent event) throws ClassNotFoundException, SQLException{

        try{
            ManagerPageDAO.updateEmployee(Integer.parseInt(txtOrderID.getText()), txtFIOClient.getText(),txtFIOManager.getText(),txtDetailName.getText(),Integer.parseInt(txtQuantityDetails.getText()),txtCarBrandName.getText(),Double.parseDouble(txtOrderPrice.getText()));
            resultConsole.setText("Операция выполнена успешно!\nДанные были обновлены в базе данных.");
            ObservableList<ManagerPage> empList = ManagerPageDAO.getAllRecords();
            populateTable(empList);
        }catch(SQLException e){
            System.out.println("Исключение возникает в EmployeeController:updateEmployee "+e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void initialize() throws Exception {
        colOrderId.setCellValueFactory(cellData -> cellData.getValue().getOrderId().asObject());
        colFIOClient.setCellValueFactory(cellData -> cellData.getValue().getFIOClientName());
        colFIOManager.setCellValueFactory(cellData -> cellData.getValue().getFIOManagerName());
        colDetailName.setCellValueFactory(cellData -> cellData.getValue().getDetailName());
        colQuantityDetails.setCellValueFactory(cellData -> cellData.getValue().getQuantityDetails().asObject());
        colCarBrandName.setCellValueFactory(cellData -> cellData.getValue().getCarBrandProperty());
        colOrderPrice.setCellValueFactory(cellData -> cellData.getValue().getOrderPrice().asObject());

        //This will allow the table to select multiple rows at once
        employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ObservableList<ManagerPage> empList = ManagerPageDAO.getAllRecords();
        populateTable(empList);
    }

    @FXML
    private void populateTable(ObservableList<ManagerPage> empList) {
        employeeTable.setItems(empList);
    }

    //Для метода getSelected()
    int index = -1;

    //Метод для выбора заказа из таблицы и отображения содержимого в текстовых полях слева от таблицы
    @FXML
    void getSelected (MouseEvent event) {
        index = employeeTable.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        txtOrderID.setText(colOrderId.getCellData(index).toString());
        txtFIOClient.setText(colFIOClient.getCellData(index).toString());
        txtFIOManager.setText(colFIOManager.getCellData(index).toString());
        txtDetailName.setText(colDetailName.getCellData(index).toString());
        txtQuantityDetails.setText(colQuantityDetails.getCellData(index).toString());
        txtCarBrandName.setText(colCarBrandName.getCellData(index).toString());
        txtOrderPrice.setText(colOrderPrice.getCellData(index).toString());

    }

    //Метод для очистки полей ввода
    @FXML
    void clearTextFields(ActionEvent event) {
        txtOrderID.clear();
        txtFIOClient.clear();
        txtFIOManager.clear();
        txtDetailName.clear();
        txtQuantityDetails.clear();
        txtCarBrandName.clear();
        txtCarBrandName.clear();
        txtOrderPrice.clear();
        resultConsole.setText("Операция выполнена успешно!\nПоля для ввода данных очищены.");
    }

    @FXML
    void getSelectedExitButton (ActionEvent event){
        exitButton.getScene().getWindow().hide();
    }
}
