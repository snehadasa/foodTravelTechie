package com.foodTravelTechie.db;

import com.foodTravelTechie.core.PeopleRecipeMapping;
import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PeopleRecipeMappingDao extends AbstractDAO<PeopleRecipeMapping> {

    public PeopleRecipeMappingDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<PeopleRecipeMapping> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

//    public Optional<People> findByName(String id) {
//        return
//    }

    public PeopleRecipeMapping create(PeopleRecipeMapping recipeIngredientMapping) {
        return persist(recipeIngredientMapping);
    }
}

