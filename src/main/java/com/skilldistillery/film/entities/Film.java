package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Locale.Category;
import java.util.Objects;

public class Film {

	private int filmId;
	private String filmTitle;
	private String filmDesc;
	private int releaseYear;
	private int langId;
	private String languageName;
	private int rentDur;
	private int rentRate;
	private int filmLength;
	private double replCost;
	private String filmRating;
	private String specFeat;
	private List<Actor> actors;
	private List<String> categories;

	public Film() {
		super();
	}



	public Film(int filmId, String filmTitle, String filmDesc, int releaseYear, int langId, String languageName,
			int rentDur, int rentRate, int filmLength, double replCost, String filmRating, String specFeat,
			List<Actor> actors, List<String> categories) {
		super();
		this.filmId = filmId;
		this.filmTitle = filmTitle;
		this.filmDesc = filmDesc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.languageName = languageName;
		this.rentDur = rentDur;
		this.rentRate = rentRate;
		this.filmLength = filmLength;
		this.replCost = replCost;
		this.filmRating = filmRating;
		this.specFeat = specFeat;
		this.actors = actors;
		this.categories = categories;
	}



	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getFilmDesc() {
		return filmDesc;
	}

	public void setFilmDesc(String filmDesc) {
		this.filmDesc = filmDesc;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentDur() {
		return rentDur;
	}

	public void setRentDur(int rentDur) {
		this.rentDur = rentDur;
	}

	public int getRentRate() {
		return rentRate;
	}

	public void setRentRate(int rentRate) {
		this.rentRate = rentRate;
	}

	public int getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(int filmLength) {
		this.filmLength = filmLength;
	}

	public double getReplCost() {
		return replCost;
	}

	public void setReplCost(double replCost) {
		this.replCost = replCost;
	}

	public String getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}

	public String getSpecFeat() {
		return specFeat;
	}

	public void setSpecFeat(String specFeat) {
		this.specFeat = specFeat;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(actors, categories, filmDesc, filmId, filmLength, filmRating, filmTitle, langId,
				languageName, releaseYear, rentDur, rentRate, replCost, specFeat);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(categories, other.categories)
				&& Objects.equals(filmDesc, other.filmDesc) && filmId == other.filmId && filmLength == other.filmLength
				&& Objects.equals(filmRating, other.filmRating) && Objects.equals(filmTitle, other.filmTitle)
				&& langId == other.langId && Objects.equals(languageName, other.languageName)
				&& releaseYear == other.releaseYear && rentDur == other.rentDur && rentRate == other.rentRate
				&& Double.doubleToLongBits(replCost) == Double.doubleToLongBits(other.replCost)
				&& Objects.equals(specFeat, other.specFeat);
	}



	@Override
	public String toString() {
		return "Film filmId=" + filmId + ", filmTitle=" + filmTitle + ", filmDesc=" + filmDesc + ", releaseYear="
				+ releaseYear + ", langId=" + langId + ", languageName=" + languageName + ", rentDur=" + rentDur
				+ ", rentRate=" + rentRate + ", filmLength=" + filmLength + ", replCost=" + replCost + ", filmRating="
				+ filmRating + ", specFeat=" + specFeat + ", actors=" + actors + ", categories=" + categories + "";
	}





}
