package com.edutecno.model;

public class Persona {
	
	//atributos
	private int id;
	private String name;
	private String password;
	private String email;
	private String sex;
	private String country;
	
	public Persona() {
	}
	
	public Persona(int id, String name, String password, String email, String sex, String country) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.country = country;
	}

	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", sex=" + sex
				+ ", country=" + country + "]";
	}
}
