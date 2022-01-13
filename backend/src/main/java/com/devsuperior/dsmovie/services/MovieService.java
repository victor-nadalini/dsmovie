package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository; 
	
	@Transactional(readOnly = true)
	public Page <MovieDTO>  findAll(Pageable pageable) {
		Page<movie> result = repository.findAll(pageable); 
		Page <MovieDTO> Page = result.map(x -> new MovieDTO(x));
		return Page; 
	}
	@Transactional(readOnly = true)
	public MovieDTO  findById(Long Id) {
		movie result = repository.findById(Id).get(); 
		MovieDTO dto = new MovieDTO(result);
		return dto; 
	}
}
