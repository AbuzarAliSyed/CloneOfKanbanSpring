package group.example.KanbanHiringPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Column(name="dasId")
	@Id
	String dasId;
	
	@Column(name="userName")
	String userName;
	
	@Column(name="emailId")
	String emailId;
	
	@Column(name="password")
	String password;

	
	public User() {}
	
	
	public User(String v1,String v2,String v3, String v4) {
		dasId=v1;
		userName =v2;
		emailId=v3;
		password=v4;
	}
	
	
	public String getDasId() {
		return dasId;
	}

	public void setDasId(String dasId) {
		this.dasId = dasId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
