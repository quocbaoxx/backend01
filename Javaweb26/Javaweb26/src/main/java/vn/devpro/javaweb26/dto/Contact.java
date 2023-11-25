package vn.devpro.javaweb26.dto;

public class Contact {
	
	private String txtName;
	private String txtEmail;
	private String txtMobile;
	private String txtAddress;
	private String txtMessage;
	
	
	public Contact(String txtName, String txtEmail, String txtMobile, String txtAddress, String txtMessage) {
		super();
		this.txtName = txtName;
		this.txtEmail = txtEmail;
		this.txtMobile = txtMobile;
		this.txtAddress = txtAddress;
		this.txtMessage = txtMessage;
	}
	public String getTxtName() {
		return txtName;
	}
	public Contact() {
		super();
	}
	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}
	public String getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}
	public String getTxtMobile() {
		return txtMobile;
	}
	public void setTxtMobile(String txtMobile) {
		this.txtMobile = txtMobile;
	}
	public String getTxtAddress() {
		return txtAddress;
	}
	public void setTxtAddress(String txtAddress) {
		this.txtAddress = txtAddress;
	}
	public String getTxtMessage() {
		return txtMessage;
	}
	public void setTxtMessage(String txtMessage) {
		this.txtMessage = txtMessage;
	}
	
}
