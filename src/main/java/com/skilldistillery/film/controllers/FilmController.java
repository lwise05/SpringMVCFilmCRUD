package com.skilldistillery.film.controllers;

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
	
	@RequestMapping(path = {"home.do" , "/"})
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	//User story 1
	@RequestMapping(path = "GetFilmById.do", params = "filmId", method = RequestMethod.GET )
	public ModelAndView GetFilmById(@RequestParam ( "filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(filmId);
		mv.addObject("film", film);
		if (film == null) {
			mv.addObject("SearchFailed", "film not found");
		}
		mv.setViewName("home");
		return mv;
	}

	//User story 2
	@RequestMapping(path = "CreateFilm.do", method = RequestMethod.POST)
	public ModelAndView CreateFilm(Film film, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		Film newFilm = filmDao.createFilm(film);
		if(newFilm !=null) {
		redirect.addFlashAttribute("film", filmDao.findFilmById(newFilm.getFilmId()));
		mv.setViewName("redirect:CreateFilm.do");
		}else {
			//error jsp to showcase error with link to return to home.do
		}
		
		return mv;
	}
	
	@RequestMapping(path = "CreateFilm.do", method = RequestMethod.GET)
	public ModelAndView filmAdded (Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", film);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(path = "DeleteFilm.do", method = RequestMethod.GET)
	public void deleteFilm (@RequestParam(" filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		boolean filmToDelete = filmDao.deleteFilm(filmId);
		Film film = filmDao.findFilmById(filmId);
		mv.addObject(film);
		mv.clear();
		
//		return null;
	}
}
