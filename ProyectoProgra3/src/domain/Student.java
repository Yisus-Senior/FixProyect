package domain;

import java.time.LocalDate;

public class Student {

	private String carnet;
	private String name;
	private String email;
	private int phoneNumber;
	private boolean isActive;
	private LocalDate entryDate;
	private char gender;
	private double availableMoney;
	
	public Student(String carnet, String name, String email, int phoneNumber, char gender, boolean isActive, LocalDate entryDate,
			double availableMoney) {
		this.carnet = carnet;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.isActive = isActive;
		this.entryDate = entryDate;
		this.availableMoney = availableMoney;
	}
	
	public Student() {
		
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getAvailableMoney() {
		return availableMoney;
	}

	public void setAvailableMoney(double availableMoney) {
		this.availableMoney = availableMoney;
	}
	
}
