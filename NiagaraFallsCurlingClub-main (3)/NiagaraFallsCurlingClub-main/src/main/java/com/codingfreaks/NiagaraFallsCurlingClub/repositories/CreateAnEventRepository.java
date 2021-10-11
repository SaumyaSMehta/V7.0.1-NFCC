package com.codingfreaks.NiagaraFallsCurlingClub.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Event;

public interface CreateAnEventRepository extends MongoRepository<Event, String>{

}