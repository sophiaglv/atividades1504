package com.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.show.entities.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{

}
