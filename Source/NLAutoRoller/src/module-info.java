module nlautoroll{
	requires transitive javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;
	exports application to javafx.graphics;
	opens roller to javafx.fxml;
}