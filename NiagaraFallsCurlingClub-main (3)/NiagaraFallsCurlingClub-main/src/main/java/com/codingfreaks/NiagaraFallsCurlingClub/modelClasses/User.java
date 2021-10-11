package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses;

import java.util.List;

import org.apache.tomcat.jni.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.codingfreaks.NiagaraFallsCurlingClub.constants.WeeklyTimings.WeeklyTimingsENUM;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "tblUsers")
public class User {
    
	@MongoId(FieldType.OBJECT_ID)
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String primaryPhone;
	private String alternatePhone;
	private int curlingExperience;
	private List<WeeklyTimingsENUM> timingsList;
	private EmergencyContact emergencyContact;
	private UserAddress address;
	private List<String> leagueId;
	private List<String> teamId;
	
	public User()
	{
	  
	}
	public User(String firstName, String lastName, String email, String password,String primaryPhone) {
	  super();
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.email = email;
	  this.password = password;
	  this.primaryPhone = primaryPhone;
	}
	
	  
	
	
	
	public String getUserId() {
	  return userId;
	}
	public void setUserId(String userId) {
	  this.userId = userId;
	}
	public String getFirstName() {
	  return firstName;
	}
	public void setFirstName(String firstName) {
	  this.firstName = firstName;
	}
	public String getLastName() {
	  return lastName;
	}
	public void setLastName(String lastName) {
	  this.lastName = lastName;
	}
	public String getEmail() {
	  return email;
	}
	public void setEmail(String email) {
	  this.email = email;
	}
	public String getPassword() {
	  return password;
	}
	public void setPassword(String password) {
	  this.password = password;
	}
	
	public String getPrimaryPhone() {
	  return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
	  this.primaryPhone = primaryPhone;
	}
	
	public String getAlternatePhone() {
	  return alternatePhone;
	}
	public void setAlternatePhone(String alternatePhone) {
	  this.alternatePhone = alternatePhone;
	}
	
	public int getCurlingExperience() {
	  return curlingExperience;
	}
	public void setCurlingExperience(int curlingExperience) {
	  this.curlingExperience = curlingExperience;
	}
	public List<WeeklyTimingsENUM> getTimingsList() {
	  return timingsList;
	}
	public void setTimingsList(List<WeeklyTimingsENUM> timingsList) {
	  this.timingsList = timingsList;
	}
	public EmergencyContact getEmergencyContact() {
	  return emergencyContact;
	}
	public void setEmergencyContact(EmergencyContact emergencyContact) {
	  this.emergencyContact = emergencyContact;
	}
	public UserAddress getAddress() {
	  return address;
	}
	public void setAddress(UserAddress address) {
	  this.address = address;
	}
	public List<String> getLeagueId() {
	  return leagueId;
	}
	public void setLeagueId(List<String> leagueId) {
	  this.leagueId = leagueId;
	}
	public List<String> getTeamId() {
		return teamId;
	}
	public void setTeamId(List<String> teamId) {
		this.teamId = teamId;
	}


	
  }