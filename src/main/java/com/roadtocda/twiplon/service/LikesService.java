package com.roadtocda.twiplon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.model.Likes;
import com.roadtocda.twiplon.repository.LikesRepository;
import com.roadtocda.twiplon.repository.PostRepository;

@Service
public class LikesService {
	
	
	@Autowired
	private LikesRepository likesRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Optional<Likes>getLikes(final long id ){
		return likesRepository.findById(id);
	}
	public Iterable<Likes> getLikess(){
		return likesRepository.findAll();
	}
	
	public void deleteLike(final Long id) {
		likesRepository.deleteById(id);
	}
	public Likes saveLikes(Likes Likes) {
		Likes savedLikes = likesRepository.save(Likes);
		return savedLikes;
	}
	
	public long countLikesByPostId(Long postId) {
        return likesRepository.countByidpost(postId);
    }

	public Iterable<Likes> getLikes() {
		return null;
	}
	
	//-----------------
	
	public PostRepository getPostRepository() {
		return postRepository;
	}
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

}
