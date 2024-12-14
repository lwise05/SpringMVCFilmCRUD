package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao;
	
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

	@RequestMapping(path = {"home.do" , "/"})
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	
//	@RequestMapping(path = "GetStateData.do", params = "name", method = RequestMethod.GET)
//	public ModelAndView getStateByName(@RequestParam("name") String name) {
//		ModelAndView mv = new ModelAndView();
//		State s = stateDAO.getStateByName(name);
//		mv.addObject("state", s);
//		mv.setViewName("result");
//		return mv;
//	}
}
