package com.app.payloads;


public class UserDTO {
	
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String CustomerImage;
	private String projectName;
	private String status;
	private String statusBg;
	private String weeks;
	private String budget;
	private String location;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerImage() {
		return CustomerImage;
	}
	public void setCustomerImage(String customerImage) {
		CustomerImage = customerImage;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusBg() {
		return statusBg;
	}
	public void setStatusBg(String statusBg) {
		this.statusBg = statusBg;
	}
	public String getWeeks() {
		return weeks;
	}
	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
