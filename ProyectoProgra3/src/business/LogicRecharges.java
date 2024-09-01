package business;

import java.util.ArrayList;
import java.util.List;

import data.StudentsData;
import data.StudentsRechargeData;
import domain.Student;
import domain.StudentRecharge;

public class LogicRecharges {

	public LogicRecharges() {
		
	}
	
	public static List<StudentRecharge> getStudentRecharges(String carnet){
		List<StudentRecharge> studentRecharges = new ArrayList<StudentRecharge>();
		for(StudentRecharge eR : StudentsRechargeData.getRechargeList()) {
			if(eR.getCarnet().equals(carnet)) {
				studentRecharges.add(eR);
			}
		}
		return studentRecharges;
	} 
	
	public static String studentName(String carnet){
		for(Student e : StudentsData.getStudentsList()) {
			if(e.getCarnet().equals(carnet)) {
				return e.getName();
			}
		}
		return "";
	}
}
