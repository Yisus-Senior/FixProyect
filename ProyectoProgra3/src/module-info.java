module ProyectoProgra3 {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.datatype.jsr310;
	requires javafx.graphics;
	requires javafx.base;

	requires java.desktop;

	exports domain;
	opens business to javafx.graphics, javafx.fxml;
}
