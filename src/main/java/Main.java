import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world Application");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);

        /*InputStream iconStream = getClass().getResourceAsStream("/icon.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);
         */

        Label helloWorldLabel = new Label("Hello world!");
        helloWorldLabel.setAlignment(Pos.CENTER);
        Scene primaryScene = new Scene(helloWorldLabel);
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }
}
