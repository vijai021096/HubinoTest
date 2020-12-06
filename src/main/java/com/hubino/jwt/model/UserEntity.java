package com.hubino.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="user_entity",uniqueConstraints = {@UniqueConstraint(columnNames = "user_name"),@UniqueConstraint(columnNames = "email")})
public class UserEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="user_id")
		private long userId;
		
		@Column(name="user_name")
		private String userName;
		
		private String email;
	
		private String password;
		
	    @OneToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = true, name = "dept_id")
		private Department department;

	    @OneToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "role_id")
	    private Role role;

	    
	    
		public UserEntity() {
			super();
		}

		public UserEntity(String userName, String email, String password) {
			
			this.userName = userName;
			this.email = email;
			this.password = password;
		}

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}
	    
	    
	    
	    
	
	
}
