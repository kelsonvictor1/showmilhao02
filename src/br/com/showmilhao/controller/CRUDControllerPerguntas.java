package br.com.showmilhao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import br.com.showmilhao.model.CrudDao;
import br.com.showmilhao.model.Pergunta;
import br.com.showmilhao.model.User;


public class CRUDControllerPerguntas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CrudDao dao;

	public CRUDControllerPerguntas() throws InstantiationException, IllegalAccessException {
		dao=new CrudDao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			
			
			//List<User> lstUser=new ArrayList<User>();
			List<Pergunta> lstPergunta = new ArrayList<Pergunta>(); 
			
			String action=(String)request.getParameter("action");
			
			
			
			Gson gson = new Gson();
			
			
			response.setContentType("application/json");

			if(action.equals("list")){
				try{      
					//Fetch Data from User Table
					lstPergunta=dao.getPerguntas();   
					//Convert Java Object to Json    
					JsonElement element = gson.toJsonTree(lstPergunta, new TypeToken<List<Pergunta>>() {}.getType());
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
				Pergunta pergunta = new Pergunta();
				
				if(request.getParameter("titulo")!=null){
					String titulo=(String)request.getParameter("titulo");
					pergunta.setTitulo(titulo);
				}
				if(request.getParameter("alternativa1")!=null){
					String alternativa1=(String)request.getParameter("alternativa1");
					pergunta.setAlternativa1(alternativa1);
				}
				
				if(request.getParameter("alternativa2")!=null){
					String alternativa2=(String)request.getParameter("alternativa2");
					pergunta.setAlternativa2(alternativa2);
				}
				if(request.getParameter("alternativa3")!=null){
					String alternativa3=(String)request.getParameter("alternativa3");
					pergunta.setAlternativa3(alternativa3);
				}
				if(request.getParameter("alternativa4")!=null){
					String alternativa4=(String)request.getParameter("alternativa4");
					pergunta.setAlternativa4(alternativa4);
				}
				if(request.getParameter("alternativa5")!=null){
					String alternativa5=(String)request.getParameter("alternativa5");
					pergunta.setAlternativa5(alternativa5);
				}
				if(request.getParameter("alternativa_correta")!=null){
					String alternativa_correta=(String)request.getParameter("alternativa_correta");
					pergunta.setAlternativa_correta(alternativa_correta);
				}
				if(request.getParameter("pontuacao")!=null){
					String pontuacao=(String)request.getParameter("pontuacao");
					pergunta.setPontuacao(pontuacao);
				}
			
				try{           
					
					
					if(action.equals("create")){//Create new record
						
						
						dao.addPergunta(pergunta);     
						lstPergunta.add(pergunta);
						//Convert Java Object to Json    
						String json=gson.toJson(lstPergunta);
						
						System.out.println("JSONN: "+json);
						
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";  
						
						
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updatePergunta(pergunta);
						String listData="{\"Result\":\"OK\"}";         
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
					response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("id")!=null){
						String id=(String)request.getParameter("id");
						dao.deletePergunta(Integer.parseInt(id));
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
