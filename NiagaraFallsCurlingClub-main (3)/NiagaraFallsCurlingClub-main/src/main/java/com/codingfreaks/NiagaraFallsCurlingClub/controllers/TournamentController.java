package com.codingfreaks.NiagaraFallsCurlingClub.controllers;



import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeList;

import com.codingfreaks.NiagaraFallsCurlingClub.constants.TournamentRequestStatus;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Tournament;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.TournamentRequest;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.Tournament.TournamentRepository;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.Tournament.TournamentRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TournamentController {

    String userId;

    @Autowired
    private TournamentRepository tournamentRepository;
 
    @Autowired
    private TournamentRequestRepository tournamentRequestRepository;

    @RequestMapping(value="/tournaments", method = RequestMethod.GET)
	public String tournaments(Model model,RedirectAttributes redirectAttrs,@RequestParam("uid") String uid) {
   
        model.addAttribute("userid", uid);
        userId=uid;
        model.addAttribute("tournamentList", totalTournaments());
        System.out.println(totalTournaments().get(0).getTournamentId());
		return "views/tournamentsPage";
	}

    @PostMapping(value="/sendTournamentRegisterRequest")
	public String sendTournamentRegisterRequest(Model model,RedirectAttributes redirectAttrs,@RequestParam("tournamentId") String tournamentId) {
        long currentTimestamp = Instant.now().toEpochMilli();
        TournamentRequest tournamentRequest = new TournamentRequest(tournamentId, userId , currentTimestamp, TournamentRequestStatus.StatusENUM.pending);
        tournamentRequestRepository.save(tournamentRequest);


        redirectAttrs.addAttribute("uid",userId);
		return "redirect:tournaments";
	}

    private List<Tournament> totalTournaments(){
         System.out.println(tournamentRepository.findAll());
      List<Tournament> tournaments =  tournamentRepository.findAll();
      return tournaments;
    }
    
}
