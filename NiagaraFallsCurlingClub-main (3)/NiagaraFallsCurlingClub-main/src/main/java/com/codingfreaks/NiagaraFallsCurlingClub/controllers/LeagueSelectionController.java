package com.codingfreaks.NiagaraFallsCurlingClub.controllers;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.management.AttributeList;
import com.codingfreaks.NiagaraFallsCurlingClub.constants.TournamentRequestStatus;
import com.codingfreaks.NiagaraFallsCurlingClub.constants.WeeklyTimings;
import com.codingfreaks.NiagaraFallsCurlingClub.constants.WeeklyTimings.WeeklyTimingsENUM;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.League;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Tournament;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.TournamentRequest;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.LeagueRepository;
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
public class LeagueSelectionController{
    String userId;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeagueRepository leagueRepository;
 
    User user;
    @RequestMapping(value="/league_selection", method = RequestMethod.GET)
    public String signIn(Model model,RedirectAttributes redirectAttrs,@RequestParam("uid") String uid) {
        userId=uid;

        model.addAttribute("leagues", allLeagues());
        user = userFound();
        
        model.addAttribute("user", user);
        return "views/leagueSelection";
    }
    @PostMapping("/saveLeagueDetails")
    public String saveMembershipInfo(
        Model model,@ModelAttribute Tournament tournamentData, RedirectAttributes redirectAttrs,@ModelAttribute("user") User userWithLeagueId) {
        
            System.out.println("iski maa kaa -------- "+userWithLeagueId.getLeagueId().toString());
                
            user.setLeagueId(userWithLeagueId.getLeagueId());
       
            userRepository.save(user);
        redirectAttrs.addAttribute("uid", userId);
        System.out.println("Successfully Saved Tournament Data !");
        return "redirect:home";
    }
    
    private User userFound(){
         User user =  userRepository.findById(userId).orElse(null);
          return user;
      }
    private List<League> allLeagues(){
        List<League> leagues=leagueRepository.findAll();
        return leagues;
    }
  
}