package com.data.controller;

import com.data.entity.Movie;
import com.data.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAll());
        return "movie/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie/form";
    }

    @PostMapping("/add")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie movie,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "movie/form";
        }
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getById(id);
        if (movie == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie);
        return "movie/form";
    }

    @PostMapping("/edit")
    public String updateMovie(@Valid @ModelAttribute("movie") Movie movie,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "movie/form";
        }
        movieService.update(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteOrDisable(id);
        return "redirect:/movies";
    }
}