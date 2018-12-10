package com.revature.driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.revature.beans.Genre;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class Main {
	private static ConnectionUtil cu = ConnectionUtil.getInstance();
	private static Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		//firstAttempt();
		//secondAttempt();
		System.out.println(getGenre(5));
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
