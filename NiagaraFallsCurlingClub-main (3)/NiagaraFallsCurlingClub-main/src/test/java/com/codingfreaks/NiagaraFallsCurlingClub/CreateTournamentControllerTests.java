package com.codingfreaks.NiagaraFallsCurlingClub;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingfreaks.NiagaraFallsCurlingClub.controllers.CreateTournamentController;
import com.codingfreaks.NiagaraFallsCurlingClub.controllers.EditProfileController;
import com.codingfreaks.NiagaraFallsCurlingClub.controllers.SignUpController;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

@SpringBootTest
class CreateTournamentControllerTests {
	CreateTournamentController createTournamentController = new CreateTournamentController();

	
	
	@SuppressWarnings("static-access")
	@Test
	void testDatesVerifiedGood() {
		String startDate="2021-09-14 02:53";
		String endDate="2021-09-24 02:53";
		boolean result = createTournamentController.verifyDates(startDate,endDate);
			assertTrue(result);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testDatesVerifiedBad() {
		String startDate="";
		String endDate="";
		boolean result = createTournamentController.verifyDates(startDate,endDate);
			assertFalse(result);
	}

	@SuppressWarnings("static-access")
	@Test
	void testDatesVerifiedBoundaryIn() {
		String startDate="2021-09-14 02:53";
		String endDate="2021-09-15 02:53";
		boolean result = createTournamentController.verifyDates(startDate,endDate);
			assertTrue(result);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testDatesVerifiedBoundaryOut() {
		String startDate="2021-09-14 02:53";
		String endDate="2021-09-13 02:53";
		boolean result = createTournamentController.verifyDates(startDate,endDate);
			assertFalse(result);
	}

}
