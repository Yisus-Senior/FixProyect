package data;

import java.io.IOException;
import java.util.List;

import domain.StudentRecharge;

public class StudentsRechargeData {
	
	private static JsonUtils<StudentRecharge> jsonUtils = new JsonUtils<StudentRecharge>(); 
	public static final String fileName = "student_recharges.json";
	
	public static boolean saveRecharge(StudentRecharge sR,String filePath) {
		try {
			jsonUtils.saveElement(sR,filePath);
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	public static List<StudentRecharge> getRechargeList(String filePath){
		try {
			return  jsonUtils.getElement(StudentRecharge.class,filePath);
		}catch (IOException e) {
			return null;
		}
	}
	
	
}
