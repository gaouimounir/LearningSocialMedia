package com.roadtocda.twiplon.model;

import java.io.Serializable;
import java.util.Objects;

public class CommentId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id_user;
    private Long idpost;
    
     
	// constructeur, getters et setters (à générer ou écrire manuellement)
    
    public CommentId(Long id_user, Long idpost) {
		super();
		this.id_user = id_user;
		this.idpost = idpost;
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
	
	
    
    
    // Assurez-vous de bien implémenter les méthodes equals() et hashCode()
	
@Override
	public int hashCode() {
		return Objects.hash(id_user, idpost);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentId other = (CommentId) obj;
		return Objects.equals(id_user, other.id_user) && Objects.equals(idpost, other.idpost);
	}
    
   
    
}
