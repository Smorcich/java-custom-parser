import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;

public class MainSceneController extends Parser {

    @FXML
    private Label mainText;

    @FXML
    private Button mainButton;

    @FXML
    private Text text;


    @FXML
    private void buttonClicked() throws IOException {
        
        Parser parser = new Parser();
        text.setText(createString());
    }

}
