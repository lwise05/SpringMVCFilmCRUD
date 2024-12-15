package com.skilldistillery.film.data;

import java.util.List;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
  public Film findFilmById(int filmId);
  public Actor findActorById(int actorId);
  public List<Actor> findActorsByFilmId(int filmId);
  public List<Film> findFilmByKeyword(String filmKeyWord);
  
  Film createFilm(Film film);
  Film updateFilm(Film film);
  boolean deleteFilm(int filmToDelete);
  	// in daoImp do a try/catch: return true in Try, return false in Catch
  
}