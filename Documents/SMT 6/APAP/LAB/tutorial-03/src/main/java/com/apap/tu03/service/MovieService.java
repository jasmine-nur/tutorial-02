package com.apap.tu03.service;

import java.util.List;

import com.apap.t03.model.MovieModel;

public interface MovieService {
	void addMovie(MovieModel movie);
	List<MovieModel> getMovieList();
	MovieModel getMovieDetail(String id);
	void updateMovie(String id, Integer duration);
	void deleteMovie(MovieModel movie);
	
}
