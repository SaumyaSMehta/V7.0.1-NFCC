package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Event;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.CreateAnEventRepository;

@Controller
public class CreateEventController {

	@Autowired
	private CreateAnEventRepository eventRepo;

	String adminId;

	@RequestMapping(value = "/create_event", method = RequestMethod.GET)
	public String signUp(Model model, @RequestParam("aid") String aid) {
		adminId = aid;
		return "views/createEvent";
	}

	@RequestMapping(value = "/create_event", method = RequestMethod.POST)
	public String save(ModelMap model, RedirectAttributes redirectAttrs, @RequestParam String eventName,
			@RequestParam String eventStartDT, @RequestParam String eventEndDT, @RequestParam String eventDescription) {
		Event event = new Event(eventName, eventStartDT, eventEndDT, eventDescription);
		eventRepo.save(event);
		model.addAttribute("transformationForm", model);
		redirectAttrs.addAttribute("aid", adminId);
		return "redirect:home";
	}

}