package domain;

import java.time.LocalDate;

public class StudentRecharge{
	private String carnet;
	private double amount;
	private LocalDate rechargeDate;
	
	public StudentRecharge(String carnet, double amount, LocalDate rechargeDate) {
		super();
		this.carnet = carnet;
		this.amount = amount;
		this.rechargeDate = rechargeDate;
	}
	
	public StudentRecharge() {
		
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getRechargeDate() {
		return rechargeDate;
	}

	public void setRechargeDate(LocalDate rechargeDate) {
		this.rechargeDate = rechargeDate;
	}
	
	
}
