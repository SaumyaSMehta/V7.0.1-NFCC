package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

@Controller
public class SignUpController {
	
	
	private UserRepository userRepo;

	public SignUpController(UserRepository repository) {
        this.userRepo = repository;
    }
	
	 
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
			@RequestMapping(value="/signup", method = RequestMethod.GET)
			public String signUp(Model model) {
				return "views/signUp";
			}
			
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String save(ModelMap model, @RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam String phoneNumber,
			@RequestParam String password,@RequestParam String confirmPassword) {
	        if (!validateUserData(model,firstName,lastName,email,phoneNumber,password,confirmPassword)) {
	            return "views/signUp";
	        }
	        else
	        {
	 	       User member = new User(firstName,lastName,email,password,phoneNumber);
		        userRepo.save(member);
				model.addAttribute("transformationForm", model);
		         return "redirect:signin";
	        }
	}
	
	public boolean validateUserData(ModelMap model,String firstName,String lastName,String email,String phoneNumber,String password,String confirmPassword)
	{
		if(emailValidate(email,userRepo))
		{
			if(password.equals(confirmPassword) && password.length() >= 8)
			{
				if(phoneNumber.length()==10)
				{
					if(onlyDigits(phoneNumber,phoneNumber.length()))
					{
						return true;
					}else
					{
						 model.put("errorMessage", "Enter valid phone number");
							return false;
					}}
				else
				{
					 model.put("errorMessage", "Enter 10 digit phone number");
						return false;
				}}
			else
			{
				if(password.length()<8)
				{
					 model.put("errorMessage", "Password must contain 8 characters");
				}
				else
				{
					 model.put("errorMessage", "Password does not match");
				}
				return false;
			}}
		else
		{
			  model.put("errorMessage", "Invalid Email");
			  return false;
		}}
	
	
		public static boolean emailValidate(String emailAddress,UserRepository userRepo) {
			
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
		         if(matcher.find())
		         {
		            boolean userExists = userRepo.emailExists(emailAddress) != null;
		 			System.out.println("Email Found "+userExists);
		 			if(userExists)
		 			{
		 				return false;
		 			}
		 			else
		 			{
		 				return true;
		 			}
		 			
		         }
		         else
		         {
		        	 return false;
		         }
		     }		
		
		 public static boolean onlyDigits(String str, int n) 
		    { 
			 
			 
			 if(str==null)
				 return false;
			 
		        for (int i = 0; i < n; i++) { 
		  
		            if (str.charAt(i) >= '0'
		                && str.charAt(i) <= '9') { 
		                return true; 
		            } 
		            else { 
		                return false; 
		            }
		        } 
		        return false; 
		    } 		 
	 
	 
	
		 
}
