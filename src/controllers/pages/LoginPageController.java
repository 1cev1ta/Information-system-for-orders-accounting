package controllers.pages;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text AuthorizationText;

    @FXML
    private MFXButton authorizationButton;

    @FXML
    private ImageView groupPeopleLogo;

    @FXML
    private MFXTextField loginField;

    @FXML
    private ImageView loginFieldLogo;

    @FXML
    private Text logoText;

    @FXML
    private MFXPasswordField passwordField;

    @FXML
    private ImageView passwordFieldLogo;

    @FXML
    private ImageView repairLogo;

   @FXML
    private Label loginMessageLabel;

   @FXML
   public void loginButtonOnAction(ActionEvent e) throws IOException {
        if (!loginField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Введите логин и пароль.");
        }
   }

   public void validateLogin() throws IOException {
       if (loginField.getText().equals("admin")  && passwordField.getText().equals("admin")){
           switchToAdminOperations();
       } else if (loginField.getText().equals("manager") && passwordField.getText().equals("manager")){
           switchToManagerOperations();
       } else {
           loginMessageLabel.setText("Не правильный логин или пароль. \n" +
                   "Уточните данные для авторизации\nу администратора.");
       }
   }

   public void switchToManagerOperations() throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pages/ManagerPage.fxml"));
       Parent root = loader.load();
       Stage stage = new Stage();
       stage.setScene(new Scene(root));

       Image anotherIcon = new Image("assets/program_logo.png");
       stage.getIcons().add(anotherIcon);

       stage.setTitle("Manager Operations");
       stage.show();
   }

    public void switchToAdminOperations() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pages/AdminPage.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        Image anotherIcon = new Image("assets/program_logo.png");
        stage.getIcons().add(anotherIcon);

        stage.setTitle("Administrator Operations");
        stage.show();
    }
}
