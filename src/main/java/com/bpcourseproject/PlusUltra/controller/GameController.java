package com.bpcourseproject.PlusUltra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpcourseproject.PlusUltra.model.Game;
import com.bpcourseproject.PlusUltra.service.GameService;
import org.springframework.data.repository.query.Param;

@Controller
public class GameController {
    
    @Autowired
    private GameService service;
    
    @RequestMapping("/")
    public String viewIndexPage(Model model, @Param("keyword") String keyword){
        List<Game> gameList = service.listAll(keyword);
        model.addAttribute("getAllGames", gameList);
        model.addAttribute("keyword", keyword);
        
        return "index";
    }
    
    @RequestMapping("/new_add")
    public String viewNewGameForm(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);
        return "insert";
    }
    
    @RequestMapping(value = "/save_game", method = RequestMethod.POST)
    public String addNewGame(@ModelAttribute("game") Game game) {
        service.create(game);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView viewEditGameForm(@PathVariable(name = "id") long id) {
  
        ModelAndView mav = new ModelAndView("update"); 
        Game game = service.updateid(id);
        mav.addObject("game", game);
        return mav; 
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteGame(@PathVariable(name = "id") long id) {
  
        service.delete(id);
        return "redirect:/";
    }
}
