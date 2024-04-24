package com.iheb.sport.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iheb.sport.entities.sport;
import com.iheb.sport.service.SportService;

@Controller
public class SportController {
	
	@Autowired
	SportService sportService;
	
	@RequestMapping("/listeSports")
	public String listeSports(ModelMap modelMap, 
	                          @RequestParam(name = "page", defaultValue = "0") int page,
	                          @RequestParam(name = "size", defaultValue = "2") int size) {
	    Page<sport> sports = sportService.getAllSportsParPage(page, size);
	    modelMap.addAttribute("sports", sports);
	    modelMap.addAttribute("pages", new int[sports.getTotalPages()]);	
	    modelMap.addAttribute("currentPage", page);			
	    return "ListeSports";	
	}
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
	    modelMap.addAttribute("sport", new sport());
	    modelMap.addAttribute("mode", "new");
	    return "formSport";
	}
	
	/*@RequestMapping("/saveSport")
	public String saveSport(@ModelAttribute("sport") sport sport, 
	                        @RequestParam(name = "page", defaultValue = "0") int page,
	                        @RequestParam(name = "size", defaultValue = "2") int size) throws ParseException {
	    sport savedSport = sportService.saveSport(sport);
	    return "redirect:/ListeSports?page=" + page + "&size=" + size;
	}*/
	
	@RequestMapping("/saveSport") 
	public String saveSport(@ModelAttribute("sport") sport sport,  
	                        @RequestParam("date") String date, 
	                        ModelMap modelMap) throws ParseException  
	{ 
	    // Conversion de la date
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateFondation = dateFormat.parse(date);
	    sport.setDateFondation(dateFondation);
	   
	    // Enregistrement du sport
	    sport savedSport = sportService.saveSport(sport); 
	    String msg = "Sport enregistré avec Id " + savedSport.getIdSport(); 
	    modelMap.addAttribute("msg", msg); 
	    return "createProduit"; 
	}

	
	@RequestMapping("/supprimerSport")
	public String supprimerProduit(@RequestParam("id") Long id, 
	                               ModelMap modelMap, 
	                               @RequestParam(name="page", defaultValue = "0") int page, 
	                               @RequestParam(name="size", defaultValue = "2") int size) { 
	    sportService.deleteSportById(id);
	    Page<sport> prods = sportService.getAllSportsParPage(page, size); 
	    
	    modelMap.addAttribute("sports", prods);  
	    modelMap.addAttribute("pages", new int[prods.getTotalPages()]);  
	    modelMap.addAttribute("currentPage", page);  
	    modelMap.addAttribute("size", size);
	    
	    return "ListeSports";
	}


	
	@RequestMapping("/modifierSport")
	public String editerSport(@RequestParam("id") Long id, ModelMap modelMap,
	                          @RequestParam(name = "page", defaultValue = "0") int page,
	                          @RequestParam(name = "size", defaultValue = "2") int size) {
		sport sport = sportService.getSport(id);
	    modelMap.addAttribute("mode", "edit");
	    modelMap.addAttribute("sport", sport);
	    modelMap.addAttribute("page", page);
	    modelMap.addAttribute("size", size);
	    return "formSport";
	}
	
	@RequestMapping("/updateSport")
	public String updateSport(@ModelAttribute("sport") sport sport, 
	                          @RequestParam("dateFondation") String date,
	                          @RequestParam(name = "page", defaultValue = "0") int page,
	                          @RequestParam(name = "size", defaultValue = "2") int size) throws ParseException {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateFondation = dateFormat.parse(date);
	    sport.setDateFondation(dateFondation);
	    sportService.updateSport(sport);
	    return "redirect:/ListeSports?page=" + page + "&size=" + size;
	}
}
