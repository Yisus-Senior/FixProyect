package business;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

import domain.StudentRecharge;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GUIStudentRechargeFormController {
	@FXML
	private TextField tfCarnet;
	@FXML
	private TextField tfRechargeAmount;
	@FXML
	private Button btnRecharge;
	@FXML
	private Label labelAlert;
	@FXML
	private Button btnReturnHome;
	// Event Listener on Button[#btnRecharge].onAction
	@FXML
	public void recharge(ActionEvent event) {
		String message = validForm();
		if(message.equals("")) {
			//if() { 
				StudentRecharge sR = new StudentRecharge();
				sR.setAmount(Integer.parseInt(tfRechargeAmount.getText()));
				sR.setCarnet(tfCarnet.getText());
				sR.setRechargeDate(LocalDate.now());
			//}
			
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
			Stage temp = (Stage)btnRecharge.getScene().getWindow();
			temp.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void returnHome(ActionEvent event) {
		closeWindows();
	}
	
	private String validForm() {
		String message = "";
		if(tfCarnet.getText().isBlank() || tfCarnet.getText().isEmpty() || tfCarnet.getText()==null){
			message += "Ingrese un carnet valido";
		}
		if(tfRechargeAmount.getText().isBlank() || tfRechargeAmount.getText().isEmpty() || tfRechargeAmount.getText()==null){
			message += "Ingrese un monto valido";
		}
		
		try {
			if(Integer.parseInt(tfRechargeAmount.getText())<0) {
				message += "Ingrese un monto valido(positivo)";
				
			}
		}catch(NumberFormatException e) {
			message += "Ingrese un valor numerico";
			
		}
		return message;
	}
}
