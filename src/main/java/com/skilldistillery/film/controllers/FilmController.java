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
	
	@RequestMapping(path = "GetFilmById.do", params = "filmId", method = RequestMethod.GET )
	public ModelAndView GetFilmById(@RequestParam ( "filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(path = "CreateFilm.do", method= RequestMethod.POST)
	public ModelAndView CreateFilm(Film film, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		Film newFilm = filmDao.createFilm(film);
//		mv.addObject("film", filmDao.findFilmById(film.getFilmId()));
		redirect.addFlashAttribute("film", filmDao.findFilmById(newFilm.getFilmId()));
		mv.setViewName("redirect:CreateFilm.do");
		return mv;
	}
	@RequestMapping(path = "CreateFilm.do", method= RequestMethod.GET)
	public ModelAndView filmAdded (Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", film);
		mv.setViewName("home");
		return mv;
	}
	
	
	
//	@RequestMapping(path = "NewState.do", method = RequestMethod.POST)
//	public ModelAndView createNewState(State state, RedirectAttributes redirect) {
//		ModelAndView mv = new ModelAndView();
//		stateDAO.addState(state);
////		mv.addObject("state", state); 
//		redirect.addFlashAttribute("state", state); // add this data to be displayed in the next request
//		mv.setViewName("redirect:stateAdded.do");
//		
//		return mv;
//	}
}
