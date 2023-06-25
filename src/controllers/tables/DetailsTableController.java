package controllers.tables;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.models.DetailsTable;
import dao.implementations.DetailsTableDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class DetailsTableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<DetailsTable, Integer> colDetailId;

    @FXML
    private TableColumn<DetailsTable, String> colNameDetail;

    @FXML
    private TableColumn<DetailsTable, Double> colPriceDetails;

    @FXML
    private TableColumn<DetailsTable, String> colProducerDetail;

    @FXML
    private TableColumn<DetailsTable, Integer> colQuantityDetails;

    @FXML
    private TableView<DetailsTable> detailsTable;

    @FXML
    private TextArea resultConsole_DetailsTable;

    @FXML
    private TextField searchDetailId;

    @FXML
    private TextField txtDetailID;

    @FXML
    private TextField txtNameDetail;

    @FXML
    private TextField txtPriceDetails;

    @FXML
    private TextField txtProducerDetails;

    @FXML
    private TextField txtQuantityDetails;

    @FXML
    void deleteDetail(ActionEvent event) throws ClassNotFoundException, SQLException {

        try {
            DetailsTableDAO.deleteDetailById(Integer.parseInt(searchDetailId.getText()));
            resultConsole_DetailsTable.setText("Операция выполнена успешно!\nДанные были удалены из базы данных.");
            ObservableList<DetailsTable> detailsList = DetailsTableDAO.getAllRecords_DetailsTable();
            populateTable(detailsList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в DetailsTableController:deleteDetail " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    void insertDetail(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            DetailsTableDAO.insertDetailsTable(txtDetailID.getText(), txtNameDetail.getText(), txtQuantityDetails.getText(), txtPriceDetails.getText(), txtProducerDetails.getText());
            resultConsole_DetailsTable.setText("Операция выполнена успешно!\nДанные были загружены в базу данных.");
            ObservableList<DetailsTable> detailsList = DetailsTableDAO.getAllRecords_DetailsTable();
            populateTable(detailsList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в DetailsTableController:insertDetail " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void searchAllDetails(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<DetailsTable> detailsList = DetailsTableDAO.getAllRecords_DetailsTable();
        populateTable(detailsList);
    }

    @FXML
    private void searchDetail(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<DetailsTable> list = DetailsTableDAO.searchDetail(Integer.parseInt(searchDetailId.getText()));
        if (list.size() > 0) {
            populateTable(list);
            resultConsole_DetailsTable.setText("Значение было найдено в таблице.");
        } else {
            resultConsole_DetailsTable.setText("Значение не было найдено в таблице.");
        }
    }

    @FXML
    void updateDetail(ActionEvent event) throws ClassNotFoundException, SQLException {

        try {
            DetailsTableDAO.updateDetailsTable(txtDetailID.getText(), txtNameDetail.getText(), txtQuantityDetails.getText(), txtPriceDetails.getText(), txtProducerDetails.getText());
            resultConsole_DetailsTable.setText("Операция выполнена успешно!\nДанные были обновлены в базе данных.");
            ObservableList<DetailsTable> detailsList = DetailsTableDAO.getAllRecords_DetailsTable();
            populateTable(detailsList);
        } catch (SQLException e) {
            System.out.println("Исключение возникает в DetailsTableController:updateDetail " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void initialize() throws Exception {
        colDetailId.setCellValueFactory(cellData -> cellData.getValue().getDetailId().asObject());
        colNameDetail.setCellValueFactory(cellData -> cellData.getValue().getNameDetailProperty());
        colQuantityDetails.setCellValueFactory(cellData -> cellData.getValue().getQuantityDetailsProperty().asObject());
        colPriceDetails.setCellValueFactory(cellData -> cellData.getValue().getPriceDetail().asObject());
        colProducerDetail.setCellValueFactory(cellData -> cellData.getValue().getProducerDetail());

        //This will allow the table to select multiple rows at once
        detailsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ObservableList<DetailsTable> detailsList = DetailsTableDAO.getAllRecords_DetailsTable();
        populateTable(detailsList);
    }

    @FXML
    private void populateTable(ObservableList<DetailsTable> detailsList) {
        detailsTable.setItems(detailsList);
    }

    //для метода getSelected()
    int index = -1;

    //Метод для выбора заказа из таблицы и отображения содержимого в текстовых полях слева от таблицы
    @FXML
    void getSelected(MouseEvent event) {
        index = detailsTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        txtDetailID.setText(colDetailId.getCellData(index).toString());
        txtNameDetail.setText(colNameDetail.getCellData(index).toString());
        txtQuantityDetails.setText(colQuantityDetails.getCellData(index).toString());
        txtPriceDetails.setText(colPriceDetails.getCellData(index).toString());
        txtProducerDetails.setText(colProducerDetail.getCellData(index).toString());
    }

    //Метод для очистки полей ввода
    @FXML
    void clearTextFields(ActionEvent event) {
        txtDetailID.clear();
        txtNameDetail.clear();
        txtQuantityDetails.clear();
        txtPriceDetails.clear();
        txtProducerDetails.clear();
        resultConsole_DetailsTable.setText("Операция выполнена успешно!\nПоля для ввода данных очищены.");
    }
}
