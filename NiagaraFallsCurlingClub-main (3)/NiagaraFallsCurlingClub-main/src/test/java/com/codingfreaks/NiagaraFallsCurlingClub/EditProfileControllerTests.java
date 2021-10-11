package com.codingfreaks.NiagaraFallsCurlingClub;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingfreaks.NiagaraFallsCurlingClub.controllers.EditProfileController;
import com.codingfreaks.NiagaraFallsCurlingClub.controllers.SignUpController;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

@SpringBootTest
class EditProfileControllerTests {
	EditProfileController editProfileController = new EditProfileController();
	@Autowired
	UserRepository userRepo;

	
	
	@SuppressWarnings("static-access")
	@Test
	void testPostalCodeGood() {
		String postalCode="L6Y5K7";
		boolean result= editProfileController.validPostalCode(postalCode);
			assertTrue(result);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testPostalCodeBad() {
		String postalCode="L6Y5K7";
		boolean result=  editProfileController.validPostalCode(postalCode);
			assertFalse(result==false);
	}

	@SuppressWarnings("static-access")
	@Test
	void testPostalCodeBoundaryIn() {
		String postalCode="L6Y 7K7";
		boolean result= editProfileController.validPostalCode(postalCode);
			assertTrue(result);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testPostalCodeBoundaryOut() {
		String postalCode="L6Y%C7";
		boolean result=  editProfileController.validPostalCode(postalCode);
			assertFalse(result);
	}
}
