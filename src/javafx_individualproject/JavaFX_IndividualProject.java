package javafx_individualproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kavisszeto
 */
public class JavaFX_IndividualProject extends Application {

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene1 = new Scene(root);
        
        stage.setScene(scene1);
        stage.show();
        stage.setTitle(" \"The Hideout\" Online Ordering System");
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
