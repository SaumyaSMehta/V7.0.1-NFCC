package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.codingfreaks.NiagaraFallsCurlingClub.constants.TournamentRequestStatus.StatusENUM;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "tblEvent")
public class Event {

    @MongoId(FieldType.OBJECT_ID)
    private String eventId;
    private String eventName;
    private String eventStartDT;
    private String eventEndDT;
    private String eventDescription;
    
    public Event(String eventName, String eventStartDT, String eventEndDT, String eventDescription) {
    	this.eventName = eventName;
    	this.eventStartDT = eventStartDT;
    	this.eventEndDT = eventEndDT;
    	this.eventDescription = eventDescription;
    }
}