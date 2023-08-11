package com.roadtocda.twiplon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.roadtocda.twiplon.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService PostService;
	
	@GetMapping("")
    public String Post(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("LesPosts", PostService.getPosts());
        return "index";
    }
	
	

}
