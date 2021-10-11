package com.codingfreaks.NiagaraFallsCurlingClub.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Admin;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;

public interface AdminRespository  extends MongoRepository<Admin, String>{
	   @Query("{email : ?0 }")
	    public Admin emailExists(String email);
		
	    @org.springframework.data.mongodb.repository.Query("{_id : ?0 }")
	    public Admin getUserData(String adminId);

}
