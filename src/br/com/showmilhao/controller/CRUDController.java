package br.com.showmilhao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.showmilhao.model.CrudDao;
import br.com.showmilhao.model.Pergunta;
import br.com.showmilhao.model.User;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;


public class CRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CrudDao dao;

	public CRUDController() throws InstantiationException, IllegalAccessException {
		dao=new CrudDao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if(request.getParameter("action")!=null){
		
			List<User> lstUser=new ArrayList<User>();
			List<Pergunta> lstPergunta = new ArrayList<Pergunta>(); 
			
			String action=(String)request.getParameter("action");
			
			Gson gson = new Gson();
			
			response.setContentType("application/json");

			if(action.equals("list")){
				try{      
					//Fetch Data from User Table
					lstUser=dao.getAllUsers();   
					//Convert Java Object to Json    
					JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<User>>() {}.getType());
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
				User user=new User();
				if(request.getParameter("id")!=null){       
					int userid=Integer.parseInt(request.getParameter("id"));
					user.setId(userid);
				}
				if(request.getParameter("name")!=null){
					String firstname=(String)request.getParameter("name");
					user.setName(firstname);
				}
				if(request.getParameter("login")!=null){
					String lastname=(String)request.getParameter("login");
					user.setName(lastname);
				}
				if(request.getParameter("senha")!=null){
					String senha=(String)request.getParameter("senha");
					user.setSenha(senha);
				}
				try{           
					if(action.equals("create")){//Create new record
						dao.addUser(user);     
						lstUser.add(user);
						//Convert Java Object to Json    
						String json=gson.toJson(user);     
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";           
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateUser(user);
						String listData="{\"Result\":\"OK\"}";         
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
					response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("userid")!=null){
						String userid=(String)request.getParameter("userid");
						dao.deleteUser(Integer.parseInt(userid));
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
