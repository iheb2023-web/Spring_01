package com.iheb.sport.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iheb.sport.entities.Genre;
import com.iheb.sport.entities.sport;
import com.iheb.sport.service.SportService;

import jakarta.validation.Valid;

@Controller
public class SportController2 {

	@Autowired
	SportService sportService;

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/ListeSports")
	public String listeSports(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<sport> sports = sportService.getAllSportsParPage(page, size);
		modelMap.addAttribute("sportss", sports);
		modelMap.addAttribute("pages", new int[sports.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeSports";
	}

	@RequestMapping("/showCreate")
	public String showCreateSport(ModelMap modelMap) {
		modelMap.addAttribute("sport", new sport());
		List<Genre> gens = sportService.getAllGenres();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("genres", gens);
		return "formSport";
	}


	@RequestMapping("/saveSport")
	public String saveSport(@Valid sport sport, BindingResult bindingResult, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) {
			List<Genre> genres = sportService.getAllGenres();
			modelMap.addAttribute("genres", genres);
			modelMap.addAttribute("sport", sport);
			return "formSport";
		}

		sportService.saveSport(sport);

		if (sport.getIdSport() == null) // ajout
			isNew = true;
		sportService.saveSport(sport);
		if (isNew) // ajout
		{
			Page<sport> prods = sportService.getAllSportsParPage(page, size);
			currentPage = prods.getTotalPages() - 1;
		} else // modif
			currentPage = page;

		return ("redirect:/ListeSports?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerSport")
	public String supprimerSport(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		sportService.deleteSportById(id);
		Page<sport> sports = sportService.getAllSportsParPage(page, size);
		modelMap.addAttribute("sports", sports);
		modelMap.addAttribute("pages", new int[sports.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return ("redirect:/ListeSports?page=" + page + "&size=" + size);
	}

	@RequestMapping("/modifierSport")
	public String modifierSport(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		sport sport = sportService.getSport(id);
		List<Genre> cats = sportService.getAllGenres();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("sport", sport);
		modelMap.addAttribute("genres", cats);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);

		return "formSport";
	}

	@RequestMapping("/updateSport")
	public String updateSport(@ModelAttribute("sport") sport sport, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFon = dateFormat.parse(String.valueOf(date));
		sport.setDateFondation(dateFon);

		sportService.updateSport(sport);
		List<sport> prods = sportService.getAllSports();
		modelMap.addAttribute("sports", prods);
		return ("redirect:/ListeSports");
	}

}
