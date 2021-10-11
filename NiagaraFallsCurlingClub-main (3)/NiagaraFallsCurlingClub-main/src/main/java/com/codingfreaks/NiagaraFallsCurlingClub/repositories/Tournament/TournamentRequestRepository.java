package com.codingfreaks.NiagaraFallsCurlingClub.repositories.Tournament;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Tournament;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.TournamentRequest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TournamentRequestRepository extends MongoRepository<TournamentRequest, String> {
   

}
