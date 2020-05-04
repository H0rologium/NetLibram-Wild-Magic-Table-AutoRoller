package roller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Controller extends Table {

	@FXML
	private MenuItem showHideToggle;

	@FXML
	private MenuItem aboutBtn;

	@FXML
	private Button rollBtn;

	@FXML
	private TextArea rollhistory;

	@FXML
	private TextArea out;

	@FXML
	private Button clrHistory;

	@FXML
	public void initialise() {
		// Using class instead of enum because I read from a txt file.
		try {
			createList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Initialized");
	}

	@FXML
	void clearRollHistory(ActionEvent event) {
		rollhistory.setText("");
	}

	@FXML
	void rollTable(ActionEvent event) {
		Random r = new Random();
		String buffer = "";
		int index = r.nextInt(9999);
		System.out.println(index);
		try {
			buffer = getRoll(index);
		} catch (IndexOutOfBoundsException e) {
			rollTable(event);
			return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		out.setText(buffer);
		rollhistory.appendText("\n\n" + buffer);
	}

	@FXML
	void showAbout(ActionEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("AboutView.fxml"));
			Stage stage = new Stage();
			stage.setTitle("About NL Auto Roller");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void showOrHide(ActionEvent event) {
		if (clrHistory.isVisible() && rollhistory.isVisible()) {
			rollhistory.setVisible(false);
			clrHistory.setVisible(false);
		} else {
			rollhistory.setVisible(true);
			clrHistory.setVisible(true);

		}

	}

}
