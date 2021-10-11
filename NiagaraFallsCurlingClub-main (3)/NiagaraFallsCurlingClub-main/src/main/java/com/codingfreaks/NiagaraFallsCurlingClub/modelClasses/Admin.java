package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="tblAdmin")
public class Admin {

	@MongoId(FieldType.OBJECT_ID)
	public String adminId;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	
	public Admin() {
		
	}
	
	public Admin(String firstName, String lastName, String email, String password) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public String getAdminId() {
		return adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
