package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Document(collection="tblLeagues")
public class League {
  
  @MongoId(FieldType.OBJECT_ID)
  private String leagueId;
  private String leagueName;
  public League(){}
  public League(String leagueName) {
    this.leagueName = leagueName;
  }
  public String getLeagueId() {
    return leagueId;
  }
  public String getLeagueName() {
    return leagueName;
  }
  public void setLeagueName(String leagueName) {
    this.leagueName = leagueName;
  }
  
}