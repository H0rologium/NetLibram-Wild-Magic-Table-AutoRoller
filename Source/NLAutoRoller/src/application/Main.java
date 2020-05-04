package application;
//Net Libram Autoroller by Horologium, 2020	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import roller.Controller;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Append /view/ to the following line to run in debug.
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Net Libram Autoroller");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.initialise();
		launch(args);
	}
}
