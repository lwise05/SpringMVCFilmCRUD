package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDAOImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private String user = "student";
	private String pass = "student";

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String query = "SELECT * FROM film " + " JOIN language ON film.language_id = language.id"
					+ " WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				film = new Film();
				film.setFilmId(rs.getInt("id"));
				film.setFilmTitle(rs.getString("title"));
				film.setFilmDesc(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLangId(rs.getInt("language_id"));
				film.setRentRate(rs.getInt("rental_Rate"));
				film.setFilmLength(rs.getInt("length"));
				film.setReplCost(rs.getDouble("replacement_cost"));
				film.setFilmRating(rs.getString("rating"));
				film.setSpecFeat(rs.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));
				film.setLanguageName(rs.getString("name"));

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String query = "SELECT * FROM actor WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, actorId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				actor = new Actor();
				actor.setActorId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String query = "SELECT first_name, last_name, id FROM actor "
					+ " JOIN film_actor ON actor.id = film_actor.actor_id " + " WHERE film_actor.film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Actor actor = new Actor();
				actor.setActorId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));

				actors.add(actor);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public List<Film> findFilmByKeyword(String filmKeyWord) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String query = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? OR description LIKE ?";
			filmKeyWord = "%" + filmKeyWord + "%";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, filmKeyWord);
			stmt.setString(2, filmKeyWord);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Film film = new Film();
				film.setFilmId(rs.getInt("id"));
				film.setFilmTitle(rs.getString("title"));
				film.setFilmDesc(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLangId(rs.getInt("language_id"));
				film.setRentRate(rs.getInt("rental_Rate"));
				film.setFilmLength(rs.getInt("length"));
				film.setReplCost(rs.getDouble("replacement_cost"));
				film.setFilmRating(rs.getString("rating"));
				film.setSpecFeat(rs.getString("special_features"));
				film.setActors(findActorsByFilmId(rs.getInt("id")));
				film.setLanguageName(rs.getString("name"));

				films.add(film);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Film createFilm(Film newFilm) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			String query = "INSERT INTO Film (title, description, release_year, language_id, rental_duration, rental_rate, ";
					query+= " length, replacement_cost, rating, special_features) ";
					query+= " VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newFilm.getFilmTitle());
			stmt.setString(2, newFilm.getFilmDesc());
			stmt.setInt(3, newFilm.getReleaseYear());
			stmt.setInt(4, newFilm.getLangId());
			stmt.setInt(5, newFilm.getRentDur());
			stmt.setDouble(6, newFilm.getRentRate());
			stmt.setInt(7, newFilm.getFilmLength());
			stmt.setDouble(8, newFilm.getReplCost());
			stmt.setString(9, newFilm.getFilmRating());
			stmt.setString(10, newFilm.getSpecFeat());

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					newFilm.setFilmId(keys.getInt(1));
					
				}
			}

			conn.commit();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {

				}
				System.out.println("Film addition failed.");
				return null;
			}
		}
		return newFilm;
	}

	@Override
	public boolean deleteFilm(int filmToDelete) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			String sql = "DELETE FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmToDelete);

			int updateCount = stmt.executeUpdate();

			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.out.println("Rollback error.");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film updateFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE film SET title=?, description=? ,release_year=?" + " WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getFilmTitle());
			stmt.setString(2, film.getFilmDesc());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getFilmId());
			int updateCount = stmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {

			System.out.println(e);
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}

		}
		return film;

	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database driver:");
			e.printStackTrace();
			System.err.println("Exiting.");
			System.exit(1);
		}
	}

}
