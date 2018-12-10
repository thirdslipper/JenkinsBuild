package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.beans.Book;
import com.revature.beans.Genre;
import com.revature.driver.Main;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class GenreOracle implements GenreDAO{
	private static ConnectionUtil cu = ConnectionUtil.getInstance();
	private static Logger log = Logger.getLogger(GenreOracle.class);
	
	@Override
	public Integer addGenre(Genre g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre getGenre(Integer id) {
		log.trace("Attempting to find genre with id = "+id);
		Genre genre = null;
		String sql = "select id, genre from genre where id =?";
		try(Connection conn = cu.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				log.trace("Found genre: "+rs.getInt("id")+" "+rs.getString("genre"));
				genre = new Genre();
				genre.setId(rs.getInt("id"));
				genre.setGenre(rs.getString("genre"));
			} else {
				log.trace("Genre not found.");
			}
		} catch(SQLException e) {
			LogUtil.logException(e, Main.class);
		}
		log.trace("Returning genre: "+genre);
		return genre;
	}

	@Override
	public Genre getGenreByGenre(String genre) {
		log.trace("Attempting to find genre with genre = "+genre);
		Genre g = null;
		String sql = "select id, genre from genre where genre =?";
		try(Connection conn = cu.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,genre);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				log.trace("Found genre: "+rs.getInt("id")+" "+rs.getString("genre"));
				g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenre(rs.getString("genre"));
			} else {
				log.trace("Genre not found.");
			}
		} catch(SQLException e) {
			LogUtil.logException(e, Main.class);
		}
		log.trace("Returning genre: "+g);
		return g;
	}

	@Override
	public Set<Genre> getGenres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Genre> getGenresByBook(Book b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGenre(Genre g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGenre(Genre g) {
		// TODO Auto-generated method stub
		
	}

}
