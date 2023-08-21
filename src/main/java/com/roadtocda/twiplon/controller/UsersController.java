package com.roadtocda.twiplon.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.service.PostService;
import com.roadtocda.twiplon.service.UsersService;



@Controller
public class UsersController {
	@Autowired
	private UsersService UsersService;
	@Autowired 
	private PostService postService;
	
	@GetMapping("/connexion")
    public String connexion(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("LesUserss", UsersService.getUserss());
        return "connexion";
    }
	
	@GetMapping("/inscription")
    public String inscription(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("LesUserss", UsersService.getUserss());
        return "inscription";
    }
	
	@GetMapping("/profil")
    public String Users(@RequestParam(name="id", required = true, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        
        Optional<Users> userOptional = UsersService.getUsers(5);
        if (userOptional.isPresent()) {
        	Users user = userOptional.get();
        	model.addAttribute("user", user);
        	
        	Iterable<Post> userPosts = user.getPosts();
        	model.addAttribute("userPosts", userPosts);
        }
        return "profil";
    }

}


