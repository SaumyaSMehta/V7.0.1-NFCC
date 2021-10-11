package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.codingfreaks.NiagaraFallsCurlingClub.constants.TournamentRequestStatus;
import com.codingfreaks.NiagaraFallsCurlingClub.constants.TournamentRequestStatus.StatusENUM;
import com.codingfreaks.NiagaraFallsCurlingClub.constants.WeeklyTimings.WeeklyTimingsENUM;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "tblTournaments")
public class Tournament
{

    @MongoId(FieldType.OBJECT_ID)
	private String tournamentId;

    private String name,description;
    private int maximumParticipants;
    private String startTime,endTime;



    public Tournament(String name, String description, String startTime, String endTime,
            int maximumParticipants) {
  
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maximumParticipants = maximumParticipants;
    }





    public Tournament() {
    }





    public String getTournamentId() {
        return tournamentId;
    }
    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }





    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public int getMaximumParticipants() {
        return maximumParticipants;
    }
    public void setMaximumParticipants(int maximumParticipants) {
        this.maximumParticipants = maximumParticipants;
    }

    
}