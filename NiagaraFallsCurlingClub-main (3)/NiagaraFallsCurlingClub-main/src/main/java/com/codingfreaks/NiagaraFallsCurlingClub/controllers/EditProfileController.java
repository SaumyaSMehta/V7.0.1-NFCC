package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.Query;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.EmergencyContact;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.UserAddress;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EditProfileController {

    String userId;
    
    @Autowired
    private UserRepository userRepository;
 
    @RequestMapping(value="/editprofile", method = RequestMethod.GET)
	public String signIn(Model model,RedirectAttributes redirectAttrs,@RequestParam("uid") String uid) {
   
        model.addAttribute("userid", uid);
        userId=uid;
        model.addAttribute("userData", userFound(userId));
        if(userFound(userId).getEmergencyContact()!=null)
            model.addAttribute("emergencyContact", userFound(userId).getEmergencyContact());
        else
            model.addAttribute("emergencyContact", new EmergencyContact());

		
        return "views/editProfile";
	}


    @RequestMapping(value="/editprofile_status", method = RequestMethod.GET)
	public String signIn(Model model,RedirectAttributes redirectAttrs,@RequestParam("uid") String uid,@RequestParam("status") String status) {
   
        model.addAttribute("userid", uid);
        userId=uid;
        model.addAttribute("userData", userFound(userId));
        
        if(userFound(userId).getEmergencyContact()!=null)
            model.addAttribute("emergencyContact", userFound(userId).getEmergencyContact());
        else
            model.addAttribute("emergencyContact", new EmergencyContact());

		
        return "views/editProfile";
	}

   

    @PostMapping("/userDetailsForm")
    public String userDetailsForm(
        Model model,RedirectAttributes redirectAttrs,@RequestParam String streetName,@RequestParam String city,
        @RequestParam String province, @RequestParam String postalCode
    ) {

        User user = userFound(userId);
        user.setAddress(new UserAddress(streetName, city, province, postalCode));
        updateUserData(user);
        redirectAttrs.addAttribute("uid",userId);
        return "redirect:editprofile";
    }

    @PostMapping("/userPasswordForm")
    public String userPasswordForm( Model model,RedirectAttributes redirectAttrs,@RequestParam String oldPassword,@RequestParam String newPassword){

        User user = userFound(userId);
        String statusOfPassword = updateUserPassword(user,oldPassword,newPassword);
        redirectAttrs.addAttribute("uid",userId);
        redirectAttrs.addAttribute("status",statusOfPassword);
        return "redirect:editprofile_status";
    }

    @PostMapping("/emergencyContactForm")
    public String emergencyContactForm(
        Model model,@ModelAttribute EmergencyContact emergencyContact,RedirectAttributes redirectAttrs
    ) {
        User user =userRepository.findById(userId).orElse(null);
        updateEmergecy(user, emergencyContact);
        redirectAttrs.addAttribute("uid",userId);
        return "redirect:editprofile";
    }








    @RequestMapping("/udpateUserPasswordForm")
    public String udpateUserPasswordForm(
        Model model, @RequestParam String newPassword,@RequestParam String oldPassword
    ) {
       
        User user =userRepository.findById(userId).orElse(null);
        if(passwordValidated(oldPassword, newPassword, user))
            {
                user.setPassword(newPassword);
                userRepository.save(user);
            }
        else
            return "Password not match";
        //userRepository.
        return "redirect:editprofile";
    }


    private boolean passwordValidated(String oldPassword, String newPassword, User user){

        if(user.getPassword().equals(oldPassword))
        {
           return newPassword.length()>7;
        }

        return false;
    }


    private void updateUserData(User user) {        
        System.out.println("Emergency Email : "+user.getEmail());
        userRepository.save(user);
    }

    private void updateEmergecy(User user, EmergencyContact updatedEmergencyContact) {
        
        System.out.println("Emergency Email : "+updatedEmergencyContact.getEmail());
        user.setEmergencyContact(updatedEmergencyContact);
        userRepository.save(user);

    }

    private String updateUserPassword(User user,String oldPass, String newPass) {
        
       String currentPassword = user.getPassword();
       if(currentPassword.equals(oldPass))
       {
            if(newPass.length()>7)
            {
                user.setPassword(newPass);
                userRepository.save(user);
                return "Password has been changed";
            }
                
            else
                return "Please enter minimum 8 charachters";
       }
       else return "Your entered wrong password";

    }


    public User userFound(String uid){
      User user =  userRepository.findById(uid).orElse(null);
       return user;
    }

    public boolean validPostalCode(String postalCode) {
    	if(postalCode == null)
    		return false;
    	String POSTAL_REGEX = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
    	Pattern pattern = Pattern.compile(POSTAL_REGEX);
    	Matcher matcher = pattern.matcher(postalCode);
    	
    	return matcher.matches();
    }
}
