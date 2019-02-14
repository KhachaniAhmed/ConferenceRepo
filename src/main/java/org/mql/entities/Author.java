package org.mql.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("AUTHOR")
@Data
public class Author extends User {
	private String mail;
	@OneToMany(mappedBy = "author")
	private List<Article> articles;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(Long id, String username, String password, Role role) {
		super(id, username, password, role);
		// TODO Auto-generated constructor stub
	}

	public Author(Long id, String username, String password, Role role, String mail, List<Article> articles) {
		super(id, username, password, role);
		this.mail = mail;
		this.articles = articles;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Author [mail=" + mail + ", articles=" + articles + ", getMail()=" + getMail() + ", getArticles()="
				+ getArticles() + ", getId()=" + getId() + ", getUserName()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getRole()=" + getRole();
	}

}
