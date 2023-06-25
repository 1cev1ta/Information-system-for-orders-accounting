package controllers.pages;

import io.github.palexdev.materialfx.controls.MFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AdminPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MFXButton autoTableButton;

    @FXML
    private MFXButton clientTableButton;

    @FXML
    private MFXButton detailsTableButton;

    @FXML
    private MFXButton managerTableButton;

    @FXML
    private MFXButton orderTableButton;

    @FXML
    private BorderPane borderPane;

    @FXML
    private MFXButton exitButton_Admin;

    @FXML
    void initialize() {
    }

    @FXML
    private void btnOrderTable(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/fxml/tables/Order.fxml"));
        borderPane.setCenter(view);
    }

    @FXML
    private void btnManagerTable(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/fxml/tables/Manager.fxml"));
        borderPane.setCenter(view);
    }

    @FXML
    private void btnClientTable(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/fxml/tables/Client.fxml"));
        borderPane.setCenter(view);
    }

    @FXML
    private void btnDetailsTable(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/fxml/tables/Details.fxml"));
        borderPane.setCenter(view);
    }

    @FXML
    private void btnAutomobileTable(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/fxml/tables/Automobile.fxml"));
        borderPane.setCenter(view);
    }

    @FXML
    void getSelectedExitButton (ActionEvent event){
        exitButton_Admin.getScene().getWindow().hide();
    }
}

