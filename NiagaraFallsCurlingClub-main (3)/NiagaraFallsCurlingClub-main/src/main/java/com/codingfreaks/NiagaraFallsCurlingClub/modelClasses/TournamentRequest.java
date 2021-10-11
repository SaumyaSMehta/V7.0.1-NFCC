package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses;

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
@Document(collection = "tblTournamentRequest")
public class TournamentRequest {


    @MongoId(FieldType.OBJECT_ID)
	private String tournamentRequestId;
	private String tournamentId;
	private String requestedBy;
	private long requestedTime;
	private StatusENUM requestStatus;


    public TournamentRequest(String tournamentId,String requestedBy,long requestedTime,StatusENUM pending)
    {
        this.tournamentId=tournamentId;
        this.requestedBy = requestedBy;
        this.requestedTime=requestedTime;
        this.requestStatus = pending;
    }

	
}
