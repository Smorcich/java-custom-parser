import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.InputStream;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/first.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        //these 2 line created for links work
        MainSceneController fXMLDocumentController = loader.getController();
        fXMLDocumentController.setGetHostController(getHostServices());

        primaryStage.setScene(new Scene(root, 1000,700));
        primaryStage.show();
    }
}
