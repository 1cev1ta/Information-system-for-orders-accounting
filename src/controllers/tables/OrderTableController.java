package controllers.tables;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.models.OrderTable;
import dao.implementations.OrderTableDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class OrderTableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<OrderTable, Integer> colOrderID_OrderTable;
    @FXML
    private TableColumn<OrderTable, Integer> colClientID_OrderTable;
    @FXML
    private TableColumn<OrderTable, Integer> colManagerID_OrderTable;
    @FXML
    private TableColumn<OrderTable, Integer> colAutoID_OrderTable;
    @FXML
    private TableColumn<OrderTable, String> colDateOrder_OrderTable;

    @FXML
    private TableColumn<OrderTable, Double> colOrderPrice_OrderTable;

    @FXML
    private TableView<OrderTable> orderTable;

    @FXML
    private TextArea resultConsole_OrderTable;

    @FXML
    private TextField searchOrderID_OrderTable;


    @FXML
    private TextField txtOrderID_OrderTable;
    @FXML
    private TextField txtClientID_OrderTable;

    @FXML
    private TextField txtManagerID_OrderTable;

    @FXML
    private TextField txtAutoID_OrderTable;

    @FXML
    private TextField txtDateOrder_OrderTable;

    @FXML
    private TextField txtOrderPrice_OrderTable;


    @FXML
    void deleteOrder(ActionEvent event) throws ClassNotFoundException, SQLException {

        try {
            OrderTableDAO.deleteOrderById(Integer.parseInt(searchOrderID_OrderTable.getText()));
            resultConsole_OrderTable.setText("Операция выполнена успешно!\nДанные были удалены из базы данных.");
            ObservableList<OrderTable> ordList = OrderTableDAO.getAllRecords_OrderTable();
            populateTable(ordList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в EmployeeController:deleteEmployee " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    void insertOrder(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            OrderTableDAO.insertOrderTable(txtOrderID_OrderTable.getText(), txtClientID_OrderTable.getText(), txtManagerID_OrderTable.getText(), txtAutoID_OrderTable.getText(), txtDateOrder_OrderTable.getText(), txtOrderPrice_OrderTable.getText());
            resultConsole_OrderTable.setText("Операция выполнена успешно!\nДанные были загружены в базу данных.");
            ObservableList<OrderTable> ordList = OrderTableDAO.getAllRecords_OrderTable();
            populateTable(ordList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в EmployeeController:insertEmployee " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void searchAllOrders(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<OrderTable> ordList = OrderTableDAO.getAllRecords_OrderTable();
        populateTable(ordList);
    }

    @FXML
    private void searchOrder(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<OrderTable> list = OrderTableDAO.searchOrder(Integer.parseInt(searchOrderID_OrderTable.getText()));
        if (list.size() > 0) {
            populateTable(list);
            resultConsole_OrderTable.setText("Значение было найдено в таблице");
        } else {
            resultConsole_OrderTable.setText("Значение не было найдено в таблице");
        }
    }

    @FXML
    void updateOrder(ActionEvent event) throws ClassNotFoundException, SQLException {

        try {
            OrderTableDAO.updateOrderTable(txtOrderID_OrderTable.getText(), txtClientID_OrderTable.getText(), txtManagerID_OrderTable.getText(), txtAutoID_OrderTable.getText(), txtDateOrder_OrderTable.getText(), txtOrderPrice_OrderTable.getText());
            resultConsole_OrderTable.setText("Операция выполнена успешно!\nДанные были обновлены в базе данных.");
            ObservableList<OrderTable> ordList = OrderTableDAO.getAllRecords_OrderTable();
            populateTable(ordList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в EmployeeController:updateEmployee " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void initialize() throws Exception {
        colOrderID_OrderTable.setCellValueFactory(cellData -> cellData.getValue().getOrderId().asObject());
        colClientID_OrderTable.setCellValueFactory(cellData -> cellData.getValue().getClientId().asObject());
        colManagerID_OrderTable.setCellValueFactory(cellData -> cellData.getValue().getManagerId().asObject());
        colAutoID_OrderTable.setCellValueFactory(cellData -> cellData.getValue().getAutomobileId().asObject());
        colDateOrder_OrderTable.setCellValueFactory(cellData -> cellData.getValue().getDateOrderProperty());
        colOrderPrice_OrderTable.setCellValueFactory(cellData -> cellData.getValue().getOrderPrice().asObject());

        //This will allow the table to select multiple rows at once
        orderTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ObservableList<OrderTable> ordList = OrderTableDAO.getAllRecords_OrderTable();
        populateTable(ordList);
    }

    @FXML
    private void populateTable(ObservableList<OrderTable> empList) {
        orderTable.setItems(empList);
    }

    //для метода getSelected()
    int index = -1;

    //Метод для выбора заказа из таблицы и отображения содержимого в текстовых полях слева от таблицы
    @FXML
    void getSelected(MouseEvent event) {
        index = orderTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        txtOrderID_OrderTable.setText(colOrderID_OrderTable.getCellData(index).toString());
        txtClientID_OrderTable.setText(colClientID_OrderTable.getCellData(index).toString());
        txtManagerID_OrderTable.setText(colManagerID_OrderTable.getCellData(index).toString());
        txtAutoID_OrderTable.setText(colAutoID_OrderTable.getCellData(index).toString());
        txtDateOrder_OrderTable.setText(colDateOrder_OrderTable.getCellData(index).toString());
        txtOrderPrice_OrderTable.setText(colOrderPrice_OrderTable.getCellData(index).toString());
    }

    //Метод для очистки полей ввода
    @FXML
    void clearTextFields(ActionEvent event) {
        txtOrderID_OrderTable.clear();
        txtClientID_OrderTable.clear();
        txtManagerID_OrderTable.clear();
        txtAutoID_OrderTable.clear();
        txtDateOrder_OrderTable.clear();
        txtOrderPrice_OrderTable.clear();
        resultConsole_OrderTable.setText("Операция выполнена успешно!\nПоля для ввода данных очищены.");
    }
}
