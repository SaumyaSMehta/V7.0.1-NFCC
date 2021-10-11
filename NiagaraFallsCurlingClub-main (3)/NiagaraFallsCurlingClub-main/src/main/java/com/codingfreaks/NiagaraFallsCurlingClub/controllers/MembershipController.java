package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeList;

import com.codingfreaks.NiagaraFallsCurlingClub.constants.TournamentRequestStatus;
import com.codingfreaks.NiagaraFallsCurlingClub.constants.WeeklyTimings;
import com.codingfreaks.NiagaraFallsCurlingClub.constants.WeeklyTimings.WeeklyTimingsENUM;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Tournament;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.TournamentRequest;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.Tournament.TournamentRepository;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.Tournament.TournamentRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MembershipController{

    String userId;
    @Autowired
    private UserRepository userRepository;
 

    @RequestMapping(value="/membership", method = RequestMethod.GET)
	public String signIn(Model model,RedirectAttributes redirectAttrs,@RequestParam("uid") String uid) {
        Tournament tournament=new Tournament();
        model.addAttribute("tournamentData", tournament);
        model.addAttribute("userid", uid);
        userId=uid;
		return "views/setupMembership";
	}

    @PostMapping("/saveMembershipInfo")
    public String saveMembershipInfo(
        Model model,@ModelAttribute Tournament tournamentData, RedirectAttributes redirectAttrs, boolean MONseniorMen,
        boolean	MONpartnersLeague,
		boolean TUEdayLadies,
		boolean TUEseniorMen,
		boolean TUErecreationalCoed,
		boolean WEDdayLadies,
		boolean WEDseniorMen,
		boolean WEDbrodie,
		boolean THUdayCoed,
		boolean THUbusinessWomen,
		boolean FRInightDoubles,
		boolean SUNlittleRocks,
		boolean SUNyouthCurling, 
		boolean THUgirlsRock,boolean THUmixedLeague
    ) {
        
        List<WeeklyTimingsENUM> weeklyTimings = new ArrayList<>();
        
        if(MONseniorMen)
        weeklyTimings.add(WeeklyTimingsENUM.MONseniorMen);

        if(MONpartnersLeague)
        weeklyTimings.add(WeeklyTimingsENUM.MONpartnersLeague);

        if(MONpartnersLeague)
        weeklyTimings.add(WeeklyTimingsENUM.MONpartnersLeague);

        if(TUEdayLadies)
        weeklyTimings.add(WeeklyTimingsENUM.TUEdayLadies);

        if(TUEseniorMen)
        weeklyTimings.add(WeeklyTimingsENUM.TUEseniorMen);

        if(TUErecreationalCoed)
        weeklyTimings.add(WeeklyTimingsENUM.TUErecreationalCoed);

        if(WEDdayLadies)
        weeklyTimings.add(WeeklyTimingsENUM.WEDdayLadies);

        if(WEDseniorMen)
        weeklyTimings.add(WeeklyTimingsENUM.WEDseniorMen);

        if(WEDbrodie)
        weeklyTimings.add(WeeklyTimingsENUM.WEDbrodie);
        
        if(THUdayCoed)
        weeklyTimings.add(WeeklyTimingsENUM.THUdayCoed);

        if(THUbusinessWomen)
        weeklyTimings.add(WeeklyTimingsENUM.THUbusinessWomen);

        if(FRInightDoubles)
        weeklyTimings.add(WeeklyTimingsENUM.FRInightDoubles);

        if(SUNlittleRocks)
        weeklyTimings.add(WeeklyTimingsENUM.SUNlittleRocks);

        if(SUNyouthCurling)
        weeklyTimings.add(WeeklyTimingsENUM.SUNyouthCurling);

        if(THUgirlsRock)
        weeklyTimings.add(WeeklyTimingsENUM.THUgirlsRock);

        if(THUmixedLeague)
        weeklyTimings.add(WeeklyTimingsENUM.THUmixedLeague);

        User user = userFound();
        user.setTimingsList(weeklyTimings);
        
        userRepository.save(user);

        redirectAttrs.addAttribute("uid", userId);
        System.out.println("Successfully Saved Tournament Data !");
        return "redirect:home";
    }

    
    private User userFound(){
        User user =  userRepository.findById(userId).orElse(null);
          return user;
      }
  
}
