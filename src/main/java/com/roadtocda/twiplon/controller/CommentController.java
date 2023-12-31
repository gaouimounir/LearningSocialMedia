package com.roadtocda.twiplon.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roadtocda.twiplon.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	/*@PostMapping("/commentaire")
	public void Comments(@RequestBody Map <String, String> requestBody) {
		String commentId = requestBody.get("commentId");
		String textComment = requestBody.get("textComment");
		commentService.commentSave(7, Integer.parseInt(commentId), textComment);
	} */
	
	 @PostMapping("/commentaire")
	    public ResponseEntity<String> addComment(@RequestParam int id_user, @RequestParam int idpost, @RequestParam String text) {
	        commentService.commentSave(5, idpost, text);
	        return ResponseEntity.ok("Comment added successfully");
	    } 
}