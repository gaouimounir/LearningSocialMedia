package com.roadtocda.twiplon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(CommentId.class)
public class Comment {
    @Id
    private Long id_user;

    @Id
    private Long idpost;

    // Relation Many-to-One vers la publication (plusieurs commentaires sont associés à une publication)
    @ManyToOne
    @JoinColumn(name = "idpost", insertable = false, updatable = false)
    private Post post;
    
 
	

// Getters et Setters (à générer ou écrire manuellement)
    
    public Comment(Long id_user, Long idpost, Post post) {
		super();
		this.id_user = id_user;
		this.idpost = idpost;
		this.post = post;
}
    
	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getIdpost() {
		return idpost;
	}

	public void setIdpost(Long idpost) {
		this.idpost = idpost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	
    
    // Autres méthodes et constructeurs si nécessaire
	
	@Override
	public String toString() {
		return "Comment [id_user=" + id_user + ", idpost=" + idpost + ", post=" + post + ", getId_user()="
				+ getId_user() + ", getIdpost()=" + getIdpost() + ", getPost()=" + getPost() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}
