package com.luv2code.asr.emagzine.controller;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.asr.emagzine.entity.Magazine;
import com.luv2code.asr.emagzine.entity.MagazineService;

@Controller
@Transactional
public class HomeMagazineController {
	@Autowired
	MagazineService service;
	
	@GetMapping("/")
	public String getLatestNews(Model model) {
		
		
		String msg="Welcome to eMagazine - New way to get news at any instant";
		
//		List<Magazine> list = service.getAllMagazines();
//		System.out.println("List of Magazines: "+list);
		model.addAttribute("message",msg);
		return "home-news";
	}

	@GetMapping("/newmagazine")
	public String createMagazineForm(Model model) {
		model.addAttribute("magazine", new Magazine());
		return "new-magazine";
	}
	@PostMapping("/newmagazinesubmit")
	  public String greetingSubmit(@ModelAttribute Magazine magazine, Model model) {
	    model.addAttribute("megazine", magazine);
	   service.createMagazine(magazine);
	    return "megazinecreated";
	  }
	@GetMapping("/recentmagazine")
	public String showMagazine(Model model) {
		List<Magazine> list = service.listAll();
		System.out.println("List Count===>"+list.size());
		model.addAttribute("count", list.size());
		model.addAttribute("magazineList", list);
		return "recentmagazine"; 
	}
	
}
