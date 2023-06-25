package controllers.tables;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.models.ManagerTable;
import dao.implementations.ManagerTableDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class ManagerTableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ManagerTable, Integer> colExpManager;

    @FXML
    private TableColumn<ManagerTable, String> colFIOManager;

    @FXML
    private TableColumn<ManagerTable, Integer> colManagerId;

    @FXML
    private TableColumn<ManagerTable, String> colPhoneManager;

    @FXML
    private TableColumn<ManagerTable, Double> colSalaryManager;

    @FXML
    private TableView<ManagerTable> managerTable;

    @FXML
    private TextArea resultConsole_ManagerTable;

    @FXML
    private TextField searchManagerId;

    @FXML
    private TextField txtExpManager;

    @FXML
    private TextField txtFIOManager;

    @FXML
    private TextField txtManagerID;

    @FXML
    private TextField txtPhoneManager;

    @FXML
    private TextField txtSalaryManager;

    @FXML
    void deleteManager(ActionEvent event) throws ClassNotFoundException, SQLException {

        try {
            ManagerTableDAO.deleteManagerById(Integer.parseInt(searchManagerId.getText()));
            resultConsole_ManagerTable.setText("Операция выполнена успешно!\nДанные были удалены из базы данных.");
            ObservableList<ManagerTable> managerList = ManagerTableDAO.getAllRecords_ManagerTable();
            populateTable(managerList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в EmployeeController:deleteEmployee " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    void insertManager(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            ManagerTableDAO.insertManagerTable(txtManagerID.getText(), txtFIOManager.getText(), txtPhoneManager.getText(), txtExpManager.getText(), txtSalaryManager.getText());
            resultConsole_ManagerTable.setText("Операция выполнена успешно!\nДанные были загружены в базу данных.");
            ObservableList<ManagerTable> managerList = ManagerTableDAO.getAllRecords_ManagerTable();
            populateTable(managerList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в EmployeeController:insertEmployee " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void searchAllManagers(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<ManagerTable> managerList = ManagerTableDAO.getAllRecords_ManagerTable();
        populateTable(managerList);
    }

    @FXML
    private void searchManager(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<ManagerTable> list = ManagerTableDAO.searchManager(Integer.parseInt(searchManagerId.getText()));
        if (list.size() > 0) {
            populateTable(list);
            resultConsole_ManagerTable.setText("Значение было найдено в таблице.");
        } else {
            resultConsole_ManagerTable.setText("Значение не было найдено в таблице.");
        }
    }

    @FXML
    void updateManager(ActionEvent event) throws ClassNotFoundException, SQLException {

        try {
            ManagerTableDAO.updateManagerTable(txtManagerID.getText(), txtFIOManager.getText(), txtPhoneManager.getText(), txtExpManager.getText(), txtSalaryManager.getText());
            resultConsole_ManagerTable.setText("Операция выполнена успешно!\nДанные были обновлены в базе данных.");
            ObservableList<ManagerTable> managerList = ManagerTableDAO.getAllRecords_ManagerTable();
            populateTable(managerList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в EmployeeController:updateEmployee " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void initialize() throws Exception {
        colManagerId.setCellValueFactory(cellData -> cellData.getValue().getManagerId().asObject());
        colFIOManager.setCellValueFactory(cellData -> cellData.getValue().getFIOManagerProperty());
        colPhoneManager.setCellValueFactory(cellData -> cellData.getValue().getPhoneManagerProperty());
        colExpManager.setCellValueFactory(cellData -> cellData.getValue().getExperience().asObject());
        colSalaryManager.setCellValueFactory(cellData -> cellData.getValue().getSalaryManager().asObject());

        //This will allow the table to select multiple rows at once
        managerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ObservableList<ManagerTable> managerList = ManagerTableDAO.getAllRecords_ManagerTable();
        populateTable(managerList);
    }

    @FXML
    private void populateTable(ObservableList<ManagerTable> managerList) {
        managerTable.setItems(managerList);
    }

    //для метода getSelected()
    int index = -1;

    //Метод для выбора заказа из таблицы и отображения содержимого в текстовых полях слева от таблицы
    @FXML
    void getSelected(MouseEvent event) {
        index = managerTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        txtManagerID.setText(colManagerId.getCellData(index).toString());
        txtFIOManager.setText(colFIOManager.getCellData(index).toString());
        txtPhoneManager.setText(colPhoneManager.getCellData(index).toString());
        txtExpManager.setText(colExpManager.getCellData(index).toString());
        txtSalaryManager.setText(colSalaryManager.getCellData(index).toString());
    }

    //Метод для очистки полей ввода
    @FXML
    void clearTextFields(ActionEvent event) {
        txtManagerID.clear();
        txtFIOManager.clear();
        txtPhoneManager.clear();
        txtExpManager.clear();
        txtSalaryManager.clear();
        resultConsole_ManagerTable.setText("Операция выполнена успешно!\nПоля для ввода данных очищены.");
    }
}

