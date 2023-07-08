package com.ironhack.hellorecipesbook.service;

import com.ironhack.hellorecipesbook.model.Recipe;
import com.ironhack.hellorecipesbook.model.RecipesBook;
import com.ironhack.hellorecipesbook.repository.RecipeRepository;
import com.ironhack.hellorecipesbook.repository.RecipesBookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipesBookService {

    private final RecipesBookRepository recipesBookRepository;
    private final RecipeRepository recipeRepository;

    public List<RecipesBook> findAll() {
        return recipesBookRepository.findAll();
    }

    @Transactional
    public void printAllRecipesBooks() {
        List<RecipesBook> allBooks = recipesBookRepository.findAll();
        allBooks.forEach(book -> {
            System.out.println("Book: " + book.getName());
            book.getRecipes().forEach(recipe -> System.out.println("  Recipe: " + recipe.getName()));
        });
    }

    @Transactional
    public RecipesBook addNewRecipesBook(RecipesBook recipesBook) {
        return recipesBookRepository.save(recipesBook);
    }

    @Transactional
    public Recipe addRecipeToRecipesBook(Long recipesBookId, Recipe recipe) {
        RecipesBook recipesBook = recipesBookRepository.findById(recipesBookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid RecipesBook Id:" + recipesBookId));

        recipe.setRecipesBook(recipesBook);

        return recipeRepository.save(recipe);
    }
}
