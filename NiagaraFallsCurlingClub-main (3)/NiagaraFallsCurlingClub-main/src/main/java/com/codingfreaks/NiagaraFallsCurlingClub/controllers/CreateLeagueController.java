package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import java.lang.ProcessBuilder.Redirect;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.League;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.extern.apachecommons.CommonsLog;

@Controller
public class CreateLeagueController {

  String adminId;
  @Autowired
  private LeagueRepository leagueRepository;

  @GetMapping(value = "/create_league")
  public String createLeague(Model model, RedirectAttributes redirectAttrs, @RequestParam("aid") String uid) {
    adminId = uid;
    return "views/createLeague";
  }

  @PostMapping(value = "/saveLeague")
  public String saveLeague(Model model, RedirectAttributes redirectAttributes, @RequestParam String leagueName) {
    League league = new League(leagueName);
    leagueRepository.save(league);
    System.out.println(leagueName);
    redirectAttributes.addAttribute("aid", adminId);
    return "redirect:home";
  }
}