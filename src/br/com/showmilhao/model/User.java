package br.com.showmilhao.model;



public class User {

	private int id;
	private String name;
	private String login; 
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int userid) {
		this.id = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return "User [userid=" + id + ", firstName=" + name + "]";
	}


}
