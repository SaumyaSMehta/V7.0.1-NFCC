package com.codingfreaks.NiagaraFallsCurlingClub.repositories;

import java.util.List;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String>{

    @Query("{email : ?0 }")
    public User emailExists(String emailAdrress);
	
    @org.springframework.data.mongodb.repository.Query("{_id : ?0 }")
    public User getUserData(String userId);

	@org.springframework.data.mongodb.repository.Query("{_id: ?0 , curlingExperience : { $exists : true } }")
    public User firstTimeSignIn(String idOfUser);

    @org.springframework.data.mongodb.repository.Query(" { _id: ?0} , { $set: ?1 }")
    public void updateUser(String userId,User user);

    @Query("{leagueId : ?0}")
    public List<User> usersWithParticularLeagueId(String leagueId);
    

}
