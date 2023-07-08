package com.ironhack.hellorecipesbook.repository;

import com.ironhack.hellorecipesbook.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
