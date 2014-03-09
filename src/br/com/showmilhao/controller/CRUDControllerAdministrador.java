package br.com.showmilhao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.showmilhao.model.Administrador;
import br.com.showmilhao.model.CrudDao;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class CRUDControllerAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CrudDao dao;

	public  CRUDControllerAdministrador() 
			throws InstantiationException, IllegalAccessException {
		dao=new CrudDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if(request.getParameter("action")!=null){
				
			List<Administrador> lstaAdministrador=new ArrayList<Administrador>();
			//List<Pergunta> lstPergunta = new ArrayList<Pergunta>(); 
			
			String action=(String)request.getParameter("action");
			
			Gson gson = new Gson();
			
			response.setContentType("application/json");

			if(action.equals("list")){
				try{      
					//Fetch Data from User Table
					lstaAdministrador=dao.getAllAdministradors();   
					//Convert Java Object to Json    
					JsonElement element = gson.toJsonTree(lstaAdministrador, new TypeToken<List<Administrador>>() {}.getType());
					JsonArray jsonArray = element.getAsJsonArray();
					String listData=jsonArray.toString();    
					//Return Json in the format required by jTable plugin
					listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";   
					response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}    
			}
			else if(action.equals("create") || action.equals("update")){
				Administrador administrador = new Administrador();				
				if(request.getParameter("name")!=null){
					String name=(String)request.getParameter("name");
					administrador.setName(name);
				}
				if(request.getParameter("login")!=null){
					String login=(String)request.getParameter("login");
					administrador.setLogin(login);
				}				
				if(request.getParameter("senha")!=null){
					String senha=(String)request.getParameter("senha");
					administrador.setSenha(senha);
				}
				if(request.getParameter("nivel")!=null){
					String nivel=(String)request.getParameter("nivel");
					administrador.setNivel(nivel);
				}
				try{           	
					if(action.equals("create")){//Create new record
						dao.addAdministrador(administrador);  						
						lstaAdministrador.add(administrador);
						//Convert Java Object to Json    
						String json=gson.toJson(lstaAdministrador);						
						System.out.println("JSONN: "+json);						
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";  
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateAdministrador(administrador);
						String listData="{\"Result\":\"OK\"}";         
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
					response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("adminId")!=null){
						String adminId=(String)request.getParameter("adminId");
						dao.deleteAdministrador(Integer.parseInt(adminId));
						String listData="{\"Result\":\"OK\"}";        
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
					response.getWriter().print(error);
				}    
			}
		}
	}
}
