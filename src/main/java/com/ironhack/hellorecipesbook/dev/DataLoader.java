package com.ironhack.hellorecipesbook.dev;

import com.ironhack.hellorecipesbook.model.Recipe;
import com.ironhack.hellorecipesbook.model.RecipesBook;
import com.ironhack.hellorecipesbook.service.RecipesBookService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {
    private final RecipesBookService recipesBookService;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initDatabase();
//        recipesBookService.findAll().forEach(System.out::println);
        recipesBookService.printAllRecipesBooks();
    }

    private void initDatabase() {

        var faker = new Faker();
        RecipesBook book1 = recipesBookService.addNewRecipesBook(new RecipesBook("Book from " + faker.country().name()));
        RecipesBook book2 = recipesBookService.addNewRecipesBook(new RecipesBook("Book from " + faker.country().name()));
        RecipesBook book3 = recipesBookService.addNewRecipesBook(new RecipesBook("Book from " + faker.country().name()));

        // add 4 recipes to each book
        for (int i = 1; i <= 4; i++) {
            recipesBookService.addRecipeToRecipesBook(book1.getId(), new Recipe("Recipe " + faker.dessert()));
            recipesBookService.addRecipeToRecipesBook(book2.getId(), new Recipe("Recipe " + faker.food().fruit()));
            recipesBookService.addRecipeToRecipesBook(book3.getId(), new Recipe("Recipe" + faker.food().dish() ));
        }
    }
}
