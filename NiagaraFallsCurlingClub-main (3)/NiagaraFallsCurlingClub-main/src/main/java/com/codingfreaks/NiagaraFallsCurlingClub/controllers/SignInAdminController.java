package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import java.util.Map;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Admin;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.AdminRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignInAdminController {
	
	
	
	@Autowired(required = true)
	private AdminRespository adminRepo;
	

	@RequestMapping(value="/signinadmin", method = RequestMethod.GET)
	public String signIn(Model model) {
		
		return "views/signInAdmin";
	}
	
	
	@RequestMapping(value="/signinadmin", method = RequestMethod.POST)
	public String save(ModelMap model,@RequestParam String email,@RequestParam String password, Map<String, Object> map, RedirectAttributes redirectAttrs) {
   

	        if (!validateUserData(model,email,password)) {
	        
	        	 return "redirect:signinadmin";	 
	        	 }	       
	        else
	        {
				Admin adminData = adminRepo.emailExists(email);
	        	model.addAttribute("adminData", adminData).addAttribute("adminId", adminData.getAdminId());
	        	System.out.println("ADMIN ID IS "+adminData.getAdminId());

				redirectAttrs.addAttribute("aid", adminData.getAdminId());
	        	 return "redirect:adminHome";
				 //+userData.getUserId()
	        }
	}
	
	
	
	
	
	public boolean validateUserData(ModelMap model,String email,String password)
	{
		
		System.out.println("Email is : "+emailValidate(email,adminRepo));

		if(emailValidate(email,adminRepo))
		{
				Admin adminData = adminRepo.emailExists(email);
				if(password.equals(adminData.getPassword()))
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
	
	public static boolean emailValidate(String emailAddress, AdminRespository adminRepo) {
        boolean emailExists =	adminRepo.emailExists(emailAddress)!=null;
        System.out.println("Email Found Dude");
        return emailExists;
	}
	
}