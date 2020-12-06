package com.hubino.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

		@Id
		@Column(name="role_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		
		@Column(name="role")
		private String role;
		
		public Role() {

		}

		public Role(String role) {
			
			this.role = role;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

	}

