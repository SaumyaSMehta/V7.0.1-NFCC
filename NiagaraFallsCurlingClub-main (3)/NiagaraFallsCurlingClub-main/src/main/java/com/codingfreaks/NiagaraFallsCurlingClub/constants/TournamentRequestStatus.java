package com.codingfreaks.NiagaraFallsCurlingClub.constants;

public class TournamentRequestStatus {

	public enum StatusENUM {
		accepted,
		declined,
		pending,
		}
//comment for push
	
	public static String statusName(StatusENUM status)
	{
	

		    switch(status) {
		    
		      case accepted:
		    	  return "Accepted";
		      case declined:
		    	  return "Declined";
		      case pending:
		    	  return "Pending";   
			  default : 
				  return "null";
		    }
	}
}



