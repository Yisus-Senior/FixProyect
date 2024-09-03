package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import data.MenuBreakfastData;
import data.MenuLunchData;
import data.StudentsData;
import domain.Menus;
import domain.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

public class GUIRequestServicesController {
	@FXML
	private ComboBox<Object> cbStudent;
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
	@FXML
	private Label lMessageErrors;
	@FXML
	private Button btnBuyFood;

	public void rbBreakfastIsSelected(ActionEvent event) {
		setAlimentsTV();
	}
	
	@FXML
	public void rbLunchIsSelected(ActionEvent event) {
		setAlimentsTV();
		
	}
	
	@FXML
	public void cbReservationDayIsSelected(ActionEvent event) {
		setAlimentsTV();
		
	}
	
	// Event Listener on Button[#btnBack].onAction
	@FXML
	public void returnToHome(ActionEvent event) {
		closeWindows();
	}
	// Event Listener on Button[#btnAddNewFood].onAction
	@FXML
	public void buyFood(ActionEvent event) {
		
		if(tableViewFood.getSelectionModel().getSelectedItem()!=null) {
			Menus menu = tableViewFood.getSelectionModel().getSelectedItem();
			Student s = StudentsData.getStudent(cbStudent.getSelectionModel().getSelectedItem().toString());
			if(LogicRequestService.makeService(menu, s)) {
				notifyAction("compra realizada\n" + "Monto actual" + StudentsData.getStudent(cbStudent.getSelectionModel().getSelectedItem().toString()).getAvailableMoney());
			}else {
				notifyAction("Saldo actual insuficiente para realizar esta compra");
			}
		}else {
			notifyAction("Selecione una comida");
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
		setStudents();
 		List<Menus> alimentsMonday = MenuBreakfastData.getMenuList(MenuBreakfastData.fileNameMondayBreakfast);
 		ObservableList<Menus> a2 = FXCollections.observableArrayList(alimentsMonday);
 		columnFood.setCellValueFactory(cellData->cellData.getValue().namePlateProperty());
 		columnPrice.setCellValueFactory(cellData->cellData.getValue().priceProperty());
 		tableViewFood.setItems(a2);
 		columnRequest.setCellFactory(CheckBoxTableCell.forTableColumn(columnRequest));
 		columnRequest.setCellValueFactory(cellData-> new SimpleBooleanProperty(false));
 		columnRequest.setEditable(true);
 		  
	}
	
	private void setStudents() {
		cbStudent.getItems().addAll(
		    StudentsData.getStudentsList().stream() // cambiar esto ,sirve, pero mejor quitar
		        .map(Student::getCarnet)
		        .collect(Collectors.toList())
		);
		cbStudent.getSelectionModel().selectFirst();
	}
	
	private void notifyAction(String message) {
		lMessageErrors.setText(message);
		Timeline timeline = new Timeline(
				new KeyFrame(
						Duration.seconds(3),
						e->{lMessageErrors.setText("");
				
						}));
		timeline.setCycleCount(1);
		timeline.play();
		
	}
	
	public void setAlimentsTV() {	
		List<Menus> menus =new ArrayList<Menus>();
		menus = LogicMenus.getMenu(cbReservationDay.getSelectionModel().getSelectedIndex(),rbBreakfast.isSelected());
		ObservableList<Menus> menu = FXCollections.observableArrayList(menus);
		tableViewFood.setItems(menu);
	}
	
	
	@FXML
	public void addNewFood(ActionEvent event) {
try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/presentation/GUIFormAddNewAliment.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //sino lo configuro se nececita agregar aqui
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage temp = (Stage)btnBack.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
