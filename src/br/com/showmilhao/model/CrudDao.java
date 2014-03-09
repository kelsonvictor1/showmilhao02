package br.com.showmilhao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import br.com.showmilhao.model.User;
import br.com.showmilhao.model.DBUtility;

public class CrudDao {

	private Connection connection;

	public CrudDao() throws InstantiationException, IllegalAccessException {
		connection = DBUtility.getConnection();
	}

	
	/* GERENCIAMENTO DAS PERGUNTAS */
	
	public void addPergunta(Pergunta pergunta) {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into perguntas(titulo,alternativa1,alternativa2,alternativa3,alternativa4,alternativa5,alternativa_correta,pontuacao) values (?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, pergunta.getTitulo());
			preparedStatement.setString(2, pergunta.getAlternativa1());
			preparedStatement.setString(3, pergunta.getAlternativa2());   
			preparedStatement.setString(4, pergunta.getAlternativa3());
			preparedStatement.setString(5, pergunta.getAlternativa4());
			preparedStatement.setString(6, pergunta.getAlternativa5());
			preparedStatement.setString(7, pergunta.getAlternativa_correta());
			preparedStatement.setString(8, pergunta.getPontuacao());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deletePergunta(int id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from perguntas where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updatePergunta(Pergunta pergunta) throws ParseException {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("update pergunta set titulo=?,alternativa1=?,alternativa2=?,alternativa3=?,alternativa4=?,alternativa5=?,alternativa_correta=?,pontuacao=?" +
							"where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, pergunta.getTitulo());
			preparedStatement.setString(2, pergunta.getAlternativa1());
			preparedStatement.setString(3, pergunta.getAlternativa2());   
			preparedStatement.setString(4, pergunta.getAlternativa3());
			preparedStatement.setString(5, pergunta.getAlternativa4());
			preparedStatement.setString(6, pergunta.getAlternativa5());
			preparedStatement.setString(7, pergunta.getAlternativa_correta());
			preparedStatement.setString(8, pergunta.getPontuacao());
			
		
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Pergunta> getPerguntas() {
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from perguntas");
			while (rs.next()) {
				Pergunta pergunta = new Pergunta();
				
				pergunta.setTitulo(rs.getString("titulo"));
				pergunta.setAlternativa1(rs.getString("alternativa1"));
				pergunta.setAlternativa2(rs.getString("alternativa2"));
				pergunta.setAlternativa3(rs.getString("alternativa3"));
				pergunta.setAlternativa4(rs.getString("alternativa4"));
				pergunta.setAlternativa5(rs.getString("alternativa5"));
				pergunta.setAlternativa_correta(rs.getString("alternativa_correta"));
				pergunta.setPontuacao(rs.getString("pontuacao"));
				
				perguntas.add(pergunta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return perguntas;
	}
	
	/**GERENCIAMENTO DO USUARIO*/
	
	public void addUser(User user) {
	
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into usuario(name,login,senha) values (?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLogin());   
			preparedStatement.setString(3, user.getSenha());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from usuario where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) throws ParseException {
		try {
			System.out.println("--- "+user.getName()+user.getLogin()+user.getSenha()+user.getId());
			PreparedStatement preparedStatement = connection
					.prepareStatement("update usuario set name=?,login=?,senha=? where id=?");
			// Parameters start with 1   
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLogin());  
			preparedStatement.setString(3, user.getSenha());  
			preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from usuario");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setLogin(rs.getString("login"));    
				user.setSenha(rs.getString("senha"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from usuario where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**GERENCIAMENTO DO ADMINISTRADOR*/
	public void addAdministrador(Administrador admin) {
	
		try {
			List<Administrador> admins = new ArrayList<Administrador>();
			admins = getAllAdministradors();
			if(admins.size() < 1){
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into administrador(name,login,senha,nivel) values (?, ?, ? ,?)");
				// Parameters start with 1
				preparedStatement.setString(1, admin.getName());
				preparedStatement.setString(2, admin.getLogin());   
				preparedStatement.setString(3, admin.getSenha());
				preparedStatement.setString(4, admin.getNivel());
				preparedStatement.setInt(5, admin.getAdminId());
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void deleteAdministrador(int adminId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from administrador where adminId=?");
			// Parameters start with 1
			preparedStatement.setInt(1, adminId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAdministrador(Administrador admin) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update administrador set name=?,login=?,senha=?,nivel=?" +
							"where adminId=?");
			// Parameters start with 1   
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getLogin());  
			preparedStatement.setString(3, admin.getSenha()); 
			preparedStatement.setString(4, admin.getNivel());
			preparedStatement.setInt(5, admin.getAdminId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Administrador> getAllAdministradors() {
		List<Administrador> admins = new ArrayList<Administrador>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from administrador");
			while (rs.next()) {
				Administrador admin = new Administrador();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setName(rs.getString("name"));
				admin.setLogin(rs.getString("login"));    
				admin.setSenha(rs.getString("senha"));
				admin.setSenha(rs.getString("nivel"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admins;
	}

	public Administrador getAdministradorById(int adminId) {
		Administrador admin = new Administrador();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from administrador where adminId=?");
			preparedStatement.setInt(1, adminId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				admin.setAdminId(rs.getInt("adminId"));
				admin.setName(rs.getString("name"));
				admin.setLogin(rs.getString("login"));
				admin.setSenha(rs.getString("senha"));
				admin.setSenha(rs.getString("nivel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
}