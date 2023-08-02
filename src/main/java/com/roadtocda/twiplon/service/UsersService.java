package com.roadtocda.twiplon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.repository.PostRepository;
import com.roadtocda.twiplon.repository.UsersRepository;

@Service
public class UsersService {

	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Optional<Users>getUsers(final long id ){
		return usersRepository.findById(id);
	}
	public Iterable<Users> getUserss(){
		return usersRepository.findAll();
	}
	
	public void deleteUsers(final Long id) {
		usersRepository.deleteById(id);
	}
	public Users saveUsers(Users Users) {
		Users savedUsers = usersRepository.save(Users);
		return savedUsers;
	}

	public Iterable<Users> getUsers() {
		return null;
	}
	//-------------------
	
	public PostRepository getPostRepository() {
		return postRepository;
	}
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
}
