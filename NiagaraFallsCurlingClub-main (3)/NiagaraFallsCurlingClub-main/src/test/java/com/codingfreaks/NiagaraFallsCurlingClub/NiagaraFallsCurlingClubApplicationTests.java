package com.codingfreaks.NiagaraFallsCurlingClub;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingfreaks.NiagaraFallsCurlingClub.controllers.SignUpController;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

@SpringBootTest
class NiagaraFallsCurlingClubApplicationTests {
	SignUpController signUpController;
	@Autowired
	UserRepository userRepo;

	
	
	@SuppressWarnings("static-access")
	@Test
	void testPhoneNumberGood() {
		String phoneNumber="6451234123";
		assertTrue(signUpController.onlyDigits(phoneNumber,phoneNumber.length()));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testPhoneNumberBad() {
		String phoneNumber="";
		assertFalse(signUpController.onlyDigits(phoneNumber,phoneNumber.length()));
	}

	@SuppressWarnings("static-access")
	@Test
	void testPhoneNumberBoundaryIn() {
		String phoneNumber="62533234123";
		assertTrue(signUpController.onlyDigits(phoneNumber,phoneNumber.length()));
	}
	
//	@SuppressWarnings("static-access")
//	@Test
//	void testPhoneNumberBoundaryOut() {
//		String phoneNumber="6451222234234234";
//		assertFalse(signUpController.onlyDigits(phoneNumber,phoneNumber.length()));
//	}
}
