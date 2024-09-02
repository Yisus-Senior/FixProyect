package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

import domain.StudentRecharge;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class GUIConsultBalanceController {
	@FXML
	private TextField tfConsultBalance;
	@FXML
	private Button btnConsultBalance;
	@FXML
	private Label labelAlert;
	@FXML
	private TableView<StudentRecharge> tvShowStudentBalance;
	@FXML
	private TableColumn<StudentRecharge, String> tvColumnCarnet;
	@FXML
	private TableColumn<StudentRecharge, String> tvColumnStudent;
	@FXML
	private TableColumn<StudentRecharge, String> tvColumnReloadDate;
	@FXML
	private TableColumn<StudentRecharge, String> tvColumnBalance;
	@FXML
	private Button btnReturnToHome;
	@FXML
	private Button btnAddNewStudent;
	
	@FXML
	public void consultStudentBalance(ActionEvent event) {
		if(validateCarnet()) {
			if(LogicStudents.existCarnet(tfConsultBalance.getText())) {
				List<StudentRecharge> recharges = LogicRecharges.getStudentRecharges(tfConsultBalance.getText());
				if(!recharges.isEmpty()) {
					ObservableList<StudentRecharge> allRecharges = FXCollections.observableList(recharges);
					
//					tvColumnCarnet.setCellValueFactory(cellData -> cellData.getValue().carnetStudentProperty());
//					tvColumnStudent.setCellValueFactory(cellData -> cellData.getValue().nameStudentProperty());
//					tvColumnReloadDate.setCellValueFactory(cellData -> cellData.getValue().rechargeDateProperty());
//					tvColumnBalance.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
					
					tvShowStudentBalance.setItems(allRecharges);
				}else {
					notifyAction("El estudiante no ha realizado recargas");
				}
				
			}else {
				notifyAction("Carnet no existente");
			}
		}
	}
	
	@FXML
	public void initialize() {
		//ObservableList<StudentRecharge> allRecharges = FXCollections.observableList(recharges);
		//para no estar llamando
		tvColumnCarnet.setCellValueFactory(cellData -> cellData.getValue().carnetStudentProperty());
		tvColumnStudent.setCellValueFactory(cellData -> cellData.getValue().nameStudentProperty());
		tvColumnReloadDate.setCellValueFactory(cellData -> cellData.getValue().rechargeDateProperty());
		tvColumnBalance.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
	}
	@FXML
	public void returnHome(ActionEvent event) {
		closeWindows();
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnAddNewStudent].onAction
	@FXML
	public void addNewStudent(ActionEvent event) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/presentation/GUIAddNewStudentForm.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //sino lo configuro se nececita agregar aqui
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage temp = (Stage)btnAddNewStudent.getScene().getWindow();
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
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //sino lo configuro se nececita agregar aqui
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage temp = (Stage)btnReturnToHome.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public boolean validateCarnet() {
		if(tfConsultBalance.getText().isBlank()) {
			notifyAction("Ingrese un carnet");
			return false;
		}else {
			if(tfConsultBalance.getText().length()>10) {
				notifyAction("Ingrese un carnet menor a 10 caracteres");
				return false;
			}
		}
		return true;
	}
	
	public void notifyAction(String message) {
		labelAlert.setText(message);
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),e->labelAlert.setText("")));
		timeline.setCycleCount(1);
		timeline.play();
		
	}
}
