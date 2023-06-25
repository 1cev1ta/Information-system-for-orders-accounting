import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/pages/LoginPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Image anotherIcon = new Image("assets/program_logo.png");
        primaryStage.getIcons().add(anotherIcon);
        primaryStage.setTitle("Details App");
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
    }
}