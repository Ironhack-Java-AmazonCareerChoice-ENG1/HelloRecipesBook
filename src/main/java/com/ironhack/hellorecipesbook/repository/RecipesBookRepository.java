package com.ironhack.hellorecipesbook.repository;

import com.ironhack.hellorecipesbook.model.RecipesBook;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RecipesBookRepository extends JpaRepository<RecipesBook, Long> {

}