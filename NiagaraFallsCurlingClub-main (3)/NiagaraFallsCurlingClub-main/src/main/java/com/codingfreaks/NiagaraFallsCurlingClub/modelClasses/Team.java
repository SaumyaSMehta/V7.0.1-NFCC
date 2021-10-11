package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "tblTeams")
public class Team {
  
  @MongoId(FieldType.OBJECT_ID)
  private String teamId;
  private String teamName;
  private String leagueId;

  public Team(){

  }

  public Team(String teamName, String leagueId) {
    this.teamName = teamName;
    this.leagueId = leagueId;
  }

  public String getTeamId() {
    return teamId;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public String getLeagueId() {
    return leagueId;
  }

  public void setLeagueId(String leagueId) {
    this.leagueId = leagueId;
  }



}
