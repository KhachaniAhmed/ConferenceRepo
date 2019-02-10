package org.mql.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("CHAIR")
public class Chair extends User {
	private String numero;

	public Chair(Long id, String userName, String password, Role role, String numero) {
		super(id, userName, password, role);
		this.numero = numero;
	}

	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chair(Long id, String userName, String password, Role role) {
		super(id, userName, password, role);
		// TODO Auto-generated constructor stub
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
