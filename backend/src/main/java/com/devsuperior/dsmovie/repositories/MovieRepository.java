package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.movie;

public interface MovieRepository extends JpaRepository<movie, Long>{

}
