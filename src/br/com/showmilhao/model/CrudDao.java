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

	
	
	
	
	
	public void addUser(User user) {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into tblUser(userid,firstname,lastname,email) values (?,?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, user.getUserid());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());   
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from tblUser where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update tblUser set lastname=?,email=?" +
							"where userid=?");
			// Parameters start with 1   
			preparedStatement.setString(1, user.getLastName());
			preparedStatement.setString(2, user.getEmail());   
			preparedStatement.setInt(3, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from tblUser");
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));    
				user.setEmail(rs.getString("email"));
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
					prepareStatement("select * from tblUser where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));

				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}