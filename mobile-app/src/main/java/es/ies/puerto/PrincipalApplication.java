package es.ies.puerto;

import es.ies.puerto.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalApplication extends Application {

    @Override
    public void start(Stage stage) {

        MainController controller = new MainController();

        BorderPane root = controller.getView();

        Scene scene = new Scene(root, 390, 760);
        scene.getStylesheets().add(getClass()
                .getResource("/es/ies/puerto/css/estilos.css")
                .toExternalForm());

        stage.setTitle("Mobile App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}