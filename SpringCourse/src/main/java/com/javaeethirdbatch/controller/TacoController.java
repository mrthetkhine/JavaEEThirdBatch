package com.javaeethirdbatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaeethirdbatch.model.Taco;

@Controller
@RequestMapping("/taco")
public class TacoController {

	@GetMapping
	public String getTaco(Model model)
	{
		Taco taco = new Taco();
		model.addAttribute("taco", taco);
		
		return "taco";
	}
	
}
