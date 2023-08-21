package com.roadtocda.twiplon.controller;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.model.Users;
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
	
	@PostMapping("/addPost")
	public String addPost(@RequestParam(name = "newPostContent") String newPostContent,
	                      @RequestParam(name = "userId") Long userId) {
	    Post newPost = new Post();
	    newPost.setContent(newPostContent);
	    newPost.setDatecreation(Timestamp.valueOf(LocalDateTime.now()));
	    
	    Users user = new Users();
	    user.setId_user(5);
	    newPost.setUser(user);
	    
	    PostService.savePost(newPost);
	    
	    return "redirect:/";
	}

}
