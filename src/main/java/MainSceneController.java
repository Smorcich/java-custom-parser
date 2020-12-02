import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Hyperlink hyperLink;

    @FXML
    private TextFlow textFlow;

    @FXML
    private TextField textField;

    @FXML
    private TextField chooseLink;

    private String link;

    private String[] linksArr = new String[100];

    private int linkNumber;

    Parser parser = new Parser();

    @FXML
    private void buttonClicked() throws IOException {
        text.setText(createString() + " ");
    }

    HostServices hostServices ;
    public void setGetHostController(HostServices hostServices)
    {
        this.hostServices = hostServices;
    }

    @FXML
    private void hyperLinkClicked() throws IOException {
        linksArr = linksArray();
        link = chooseLink.getText();
        linkNumber = Integer.parseInt(link);
        String str = linksArr[linkNumber];
        hostServices.showDocument(str);
    }

    @FXML
    private void clearButtonClicked() throws IOException {
        text.setText("");
    }

}
