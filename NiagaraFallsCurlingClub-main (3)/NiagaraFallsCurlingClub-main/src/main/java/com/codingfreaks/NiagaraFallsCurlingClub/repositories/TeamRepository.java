package com.codingfreaks.NiagaraFallsCurlingClub.repositories;


import java.util.List;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Team;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TeamRepository extends MongoRepository<Team,String>{

    
    @Query("{leagueId : ?0 }")
    public List<Team> teamsWithParticularLeagueId(String leagueId);



}