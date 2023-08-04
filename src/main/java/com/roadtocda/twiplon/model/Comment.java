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
    private int id_user;

    @Id
    private int idpost;
    
    private String text;

    // Relation Many-to-One vers la publication (plusieurs commentaires sont associés à une publication)
    @ManyToOne
    @JoinColumn(name = "idpost", insertable = false, updatable = false)
    private Post post;
    
 
	

// Getters et Setters (à générer ou écrire manuellement)
    
    public Comment() {
		
}
    
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getIdpost() {
		return idpost;
	}

	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	

	
    
    // Autres méthodes et constructeurs si nécessaire
	
	@Override
	public String toString() {
		return "Comment [id_user=" + id_user + ", idpost=" + idpost + ", text=" + text + ", post=" + post
				+ ", getId_user()=" + getId_user() + ", getIdpost()=" + getIdpost() + ", getPost()=" + getPost()
				+ ", getText()=" + getText() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
}
