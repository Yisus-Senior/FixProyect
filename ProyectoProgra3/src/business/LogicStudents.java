package business;

import java.util.ArrayList;
import java.util.List;

import data.StudentsData;
import domain.Student;

public class LogicStudents {

	public LogicStudents() {
		
	}
	
	public boolean isAlreadyAdded(String id) {
		List<Student> studentList = StudentsData.getStudentsList();
		if(studentList!=null) {
			for(int i=0;i<studentList.size();i++) {
				if(studentList.get(i)!=null) {
					if(studentList.get(i).getCarnet().equals(id)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
