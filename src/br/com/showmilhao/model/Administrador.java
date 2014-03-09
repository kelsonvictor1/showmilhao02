package br.com.showmilhao.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
	
	private int adminId;
	private String name;
	private String login; 
	private String senha;
	private final String nivel = "1";
	
	public Administrador(){}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel2) {
		// TODO Auto-generated method stub
		
	}
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	
	
}
