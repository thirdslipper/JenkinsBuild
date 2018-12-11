package com.revature.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Book;
import com.revature.beans.Genre;
import com.revature.beans.User;
import com.revature.data.BookAppDAOFactory;
import com.revature.data.GenreDAO;
import com.revature.data.GenreOracle;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class Main {
	private static ConnectionUtil cu = ConnectionUtil.getInstance();
	private static Logger log = Logger.getLogger(Main.class);
	private static BookAppDAOFactory bf = BookAppDAOFactory.getInstance();
	
	public static void main(String[] args) {
		//firstAttempt();
		//secondAttempt();
		//System.out.println(getGenre(5));
		//login();
		dao();
	}
	
	private static void dao() {
		GenreDAO gd = bf.getGenreDAO();
		//System.out.println(gd.getGenre(3));
		//System.out.println(gd.getGenres());
		//Book b = new Book();
		//b.setId(1);
		//System.out.println(gd.getGenresByBook(b));
		
//		Genre g = gd.getGenre(5);
//		System.out.println(g);
//		g.setGenre("Historical Romance");
//		gd.updateGenre(g);
//		System.out.println(g);
//		
//		g = gd.getGenre(5);
//		System.out.println(g);
		
		/*Genre g = new Genre();
		g.setGenre("Cyber Punk");
		int i = gd.addGenre(g);
		System.out.println(gd.getGenre(i));*/
		System.out.println(bf.getEmployeeDAO().getEmployees());
	}

	private static void login() {
		Scanner scan = new Scanner(System.in);
		String username = null;
		String password = null;
		User u = null;
		
		System.out.print("Username: ");
		username=scan.nextLine();
		System.out.print("Password: ");
		password=scan.nextLine();
		
		u = getUser2(username, password);
		System.out.println(u);
	}
	private static User getUser2(String user, String pass) {
		// You are no longer allowed to use Statements
		User u= null;
		String sql = "select * from login where username = ? and pswd=?";
		log.trace(sql);
		try(Connection conn = cu.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pswd"));
				u.setFirst(rs.getString("first_name"));
				u.setLast(rs.getString("last_name"));
			}
		} catch(SQLException e) {
			LogUtil.logException(e, Main.class);
		}
		return u;
	}

	private static User getUser(String user, String pass) {
		User u= null;
		String sql = "select * from login where username = '"+user+"' and pswd='"+pass+"'";
		log.trace(sql);
		try(Connection conn = cu.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pswd"));
				u.setFirst(rs.getString("first_name"));
				u.setLast(rs.getString("last_name"));
			}
		} catch(SQLException e) {
			LogUtil.logException(e, Main.class);
		}
		return u;
	}
	
	private static Genre getGenre(int id) {
		Genre genre = null;
		String sql = "select id, genre from genre where id ="+id;
		try(Connection conn = cu.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				log.trace(rs.getInt("id")+" "+rs.getString("genre"));
				genre = new Genre();
				genre.setId(rs.getInt("id"));
				genre.setGenre(rs.getString("genre"));
			}
		} catch(SQLException e) {
			LogUtil.logException(e, Main.class);
		}
		return genre;
	}
	private static void secondAttempt() {
		String sql = "select id, title from book";
		try(Connection conn = cu.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				log.trace(rs.getInt("id")+" "+rs.getString("title"));
			}
		} catch(SQLException e) {
			LogUtil.logException(e, Main.class);
		}
	}
	private static void firstAttempt() {
		String sql = "select * from book";
		try(Connection conn = cu.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				log.trace(rs.getInt(1)+" "+rs.getString(4));
				//log.trace(rs.getInt("id")+" "+rs.getString("title"));
			}
		} catch(SQLException e) {
			LogUtil.logException(e, Main.class);
		}
	}

}
