package roller;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AboutController {

    @FXML
    private Button donateBtn;

    @FXML
    private Button sourceBtn;

    @FXML
    void openSource(ActionEvent event) throws IOException {
    	URI uri;
		try {
			uri = new URI("https://centralia.aquest.com/downloads/NLRMEv2.pdf");
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void sendToDonatePage(ActionEvent event) throws IOException {
    	URI uri;
		try {
			uri = new URI("https://www.paypal.me/HorologiumTDE");
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

    }

}
