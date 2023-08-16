package com.roadtocda.twiplon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.model.Comment;
import com.roadtocda.twiplon.repository.CommentRepository;
import com.roadtocda.twiplon.repository.PostRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	public Optional<Comment>getComment(final long id ){
		return commentRepository.findById(id);
	}
	public Iterable<Comment> getComments(){
		return commentRepository.findAll();
	}
	
	public void deleteComment(final Long id) {
		commentRepository.deleteById(id);
	}
	public Comment saveComment(Comment Comment) {
		Comment savedComment = commentRepository.save(Comment);
		return savedComment;
	}

	public void commentSave(int id_user, int idpost, String text) {
		Comment commentSaved = new Comment(id_user, idpost, text);
		commentRepository.save(commentSaved);
	}
	
	//-----------------
	
	public PostRepository getPostRepository() {
		return postRepository;
	}
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	
	
}