package com.skilldistillery.film.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "home.do", "/" })
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	// User story 1
	@RequestMapping(path = "GetFilmById.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView GetFilmById(@RequestParam("filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(filmId);
		mv.addObject("film", film);
		if (film == null) {
			mv.addObject("SearchFailed", "film not found");
		}
		if (film != null) {
			mv.setViewName("result");
		}
		return mv;
	}

	// User story 2
	@RequestMapping(path = "CreateFilm.do", method = RequestMethod.POST)
	public ModelAndView CreateFilm(Film film, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		Film newFilm = filmDao.createFilm(film);
		if (newFilm != null) {
			redirect.addFlashAttribute("film", filmDao.findFilmById(newFilm.getFilmId()));
			mv.setViewName("redirect:CreateFilm.do");
		} else {
//			mv.addObject("FilmNotCreated", "Invalid entry. Film not created");
			// error jsp to showcase error with link to return to home.do
		}
		return mv;
	}

	@RequestMapping(path = "CreateFilm.do", method = RequestMethod.GET)
	public ModelAndView filmAdded(Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", film);
		mv.setViewName("home");
		return mv;
	}

	// User story 3
	@RequestMapping(path = "DeleteFilm.do", method = RequestMethod.GET)
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		boolean filmToDelete = filmDao.deleteFilm(filmId);

		return mv;
	}

	// User story 4
	@RequestMapping(path = "UpdateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(Film film, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		Film updatedFilm = filmDao.updateFilm(film);
		if (updatedFilm != null) {
			mv.setViewName("result");
		}
		if (film == null) {
			mv.addObject("SearchFailed", "film not updated");
		}
		return mv;
	}
//		mv.setViewName("updatefilm");
//		if(updatedFilm !=null) {
//		mv.addObject("film", updatedFilm);
//		Film tempFilm = updatedFilm;
//		redirect.addFlashAttribute("film", tempFilm);
//		}

	@RequestMapping(path = "UpdateFilm.do", method = RequestMethod.GET)
	public ModelAndView filmUpdated(Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", film);
		mv.setViewName("updatefilm");
		return mv;
	}

	//User story 5
	@RequestMapping(path = "GetFilmByKeyWord.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView GetFilmByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<>();
			films = filmDao.findFilmByKeyword(keyword);
		
		if (films == null) {
			mv.addObject("SearchFailed", "films not found");
		}
		if (films != null) {
			mv.setViewName("resultByKeyword");
			mv.addObject("films", films);
		}
		return mv;
	}
}
