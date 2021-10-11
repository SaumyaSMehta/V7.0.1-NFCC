package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignInController {
	
	
	
	@Autowired(required = true)
	private UserRepository userRepo;
	
	

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	

	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String signIn(Model model) {
		
		return "views/signIn";
	}
	
	
	@RequestMapping(value="/signin", method = RequestMethod.POST)
	public String save(ModelMap model,@RequestParam String email,@RequestParam String password, Map<String, Object> map, RedirectAttributes redirectAttrs) {
   

	        if (!validateUserData(model,email,password)) {
	        
	        	 return "redirect:signin";	 
	        	 }	       
	        else
	        {
				
	        	User userData = userRepo.emailExists(email);
	        	model.addAttribute("userData", userData).addAttribute("userId", userData.getUserId());
	        	System.out.println("USER ID IS "+userData.getUserId());

				redirectAttrs.addAttribute("uid", userData.getUserId());
	        	 return "redirect:home";
				 //+userData.getUserId()
	        }
	}
	
	public boolean validateUserData(ModelMap model,String email,String password)
	{
		
		System.out.println("Hey Email has been found");
		System.out.println("Email is : "+emailValidate(email,userRepo));

		if(emailValidate(email,userRepo))
		{
				System.out.println("email validate me ageya");
				User userData = userRepo.emailExists(email);
				if(password.equals(userData.getPassword()))
				{
					System.out.println("Hey Password got matched");
					return true;
				}
				else
				{
					System.out.println("Hey Password did not match");
					 model.put("errorMessage", "Incorrect Password");
				}
				return false;
			
		}
		else
		{
			  model.put("errorMessage", "Invalid Email.");
			  return false;
		}
	}
	
	public static boolean emailValidate(String emailAddress, UserRepository userRepo) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
        if(matcher.matches())
        {
        boolean emailExists =	userRepo.emailExists(emailAddress)!=null;
        System.out.println("Email Found Dude");
        return emailExists;
        }
        else	
        {
			System.out.println("Hey I am in False");
        	return false;
        }
}
	
}
