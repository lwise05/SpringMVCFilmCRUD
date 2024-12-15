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
	public ModelAndView GetFilmById(@RequestParam ("filmId") int filmId) {
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

	//User story 2
	@RequestMapping(path = "CreateFilm.do", method = RequestMethod.POST)
	public ModelAndView CreateFilm(Film film, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		Film newFilm = filmDao.createFilm(film);
		if(newFilm !=null) {
		redirect.addFlashAttribute("film", filmDao.findFilmById(newFilm.getFilmId()));
		mv.setViewName("redirect:CreateFilm.do");
		}else {
//			mv.addObject("FilmNotCreated", "Invalid entry. Film not created");
			//error jsp to showcase error with link to return to home.do
		}
		return mv;
	}
	
	@RequestMapping(path = "CreateFilm.do", method= RequestMethod.GET)
	public ModelAndView filmAdded (Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", film);
		mv.setViewName("home");
		return mv;
	}

	
	//User story 3
	@RequestMapping(path = "UpdateFilm.do", method= RequestMethod.POST)
	public ModelAndView updateFilm (Film film, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView();
		Film updatedFilm = filmDao.updateFilm(film);
		if(updatedFilm !=null) {
		redirect.addFlashAttribute("film", filmDao.findFilmById(updatedFilm.getFilmId()));
		mv.setViewName("redirect:UpdateFilm.do");
		}
		return mv;
	}
	@RequestMapping(path = "UpdateFilm.do", method= RequestMethod.GET)
	public ModelAndView filmUpdated (Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", film);
		mv.setViewName("updatefilm");
		return mv;
	}
	

	@RequestMapping(path = "DeleteFilm.do", method = RequestMethod.GET)
	public ModelAndView deleteFilm (@RequestParam("filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		boolean filmToDelete = filmDao.deleteFilm(filmId);
		
		return mv;
	}
}
