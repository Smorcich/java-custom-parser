import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class MainSceneController extends Parser {

    @FXML
    private Label mainText;

    @FXML
    private Button mainButton;

    @FXML
    private Text text;

    @FXML
    private TextFlow textFlow;

    Parser parser = new Parser();

    @FXML
    private void buttonClicked() throws IOException {
        text.setText(createString());
    }

    @FXML
    private void clearButtonClicked() throws IOException {
        text.setText("");
    }

}
