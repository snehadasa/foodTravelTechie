package com.foodTravelTechie.db;

import com.foodTravelTechie.core.RecipeIngredientMapping;
import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class RecipeIngredientMappingDao extends AbstractDAO<RecipeIngredientMapping> {

    public RecipeIngredientMappingDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<RecipeIngredientMapping> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

//    public Optional<People> findByName(String id) {
//        return
//    }

    public RecipeIngredientMapping create(RecipeIngredientMapping recipeIngredientMapping) {
        return persist(recipeIngredientMapping);
    }
}
