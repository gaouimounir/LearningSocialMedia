package com.roadtocda.twiplon.service;

import java.security.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.repository.CommentRepository;
import com.roadtocda.twiplon.repository.LikesRepository;
import com.roadtocda.twiplon.repository.PostRepository;
import com.roadtocda.twiplon.repository.UsersRepository;

@Service
public class PostService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private LikesRepository likesRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LikesService likesService;
	
	public Optional<Post>getPost(final long id ){
		return postRepository.findById(id);
	}
	public Iterable<Post> getPosts(){
		return postRepository.findAll();
	}
	
	public void deletePost(final Long id) {
		postRepository.deleteById(id);
	}
	public Post savePost(Post Post) {
		Post savedPost = postRepository.save(Post);
		return savedPost;
	}
	
	public long getLikesCountForPost(Long postId) {
		return likesService.countLikesByPostId(postId);
	}

	
	public Iterable<Post> getUserPostsSortedByDateDesc(int id_user) {
        Users user = new Users();
        user.setId_user(id_user);
        return postRepository.findByUserOrderByDatecreationDesc(user);
    }
	
	public Iterable<Post> getDatecreation(final Timestamp datecreation){
		return postRepository.findAll();
	}
	
	
	

}
