package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import domain.Menus;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class GUIRequestServicesController {
	@FXML
	private ComboBox cbStudent;
	@FXML
	private ComboBox<String> cbReservationDay;
	@FXML
	private RadioButton rbBreakfast;
	@FXML
	private ToggleGroup reservationSchedule;
	@FXML
	private RadioButton rbLunch;
	@FXML
	private TableView<Menus> tableViewFood;
	@FXML
	private TableColumn<Menus,String> columnFood;
	@FXML
	private TableColumn<Menus,String> columnPrice;
	@FXML
	private TableColumn<Menus,Boolean> columnRequest;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnAddNewFood;

	// Event Listener on Button[#btnBack].onAction
	@FXML
	public void returnToHome(ActionEvent event) {
		closeWindows();
	}
	// Event Listener on Button[#btnAddNewFood].onAction
	@FXML
	public void addNewFood(ActionEvent event) {
try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/presentation/GUIFormAddNewAliment.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); sino lo configuro se nececita agregar aqui
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage temp = (Stage)btnBack.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void closeWindows() {
		 try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/presentation/GUIMenuHome.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); sino lo configuro se nececita agregar aqui
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage temp = (Stage)btnBack.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void initialize() {
		tableViewFood.setEditable(true);
		cbReservationDay.getItems().addAll("Lunes","Martes","Miercoles","Jueves","Viernes");
		cbReservationDay.getSelectionModel().selectFirst();
		
		Menus[] a = {new Menus("Gallo pinto con huevo",1500)};//mientras hacemos files
		
 		List<Menus> alimentsMonday = Arrays.asList(a);
 		ObservableList<Menus> a2 = FXCollections.observableArrayList(alimentsMonday);
 		columnFood.setCellValueFactory(cellData->cellData.getValue().namePlateProperty());
 		columnPrice.setCellValueFactory(cellData->cellData.getValue().priceProperty());
 		tableViewFood.setItems(a2);
 		columnRequest.setCellFactory(CheckBoxTableCell.forTableColumn(columnRequest));
 		columnRequest.setCellValueFactory(cellData-> new SimpleBooleanProperty(false));
 		columnRequest.setEditable(true);
 		
	}
}
