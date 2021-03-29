package com.foodTravelTechie.db;

import com.foodTravelTechie.core.Ingredients;
import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class IngredientsDao extends AbstractDAO<Ingredients> {

    public IngredientsDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Ingredients> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

//    public Optional<People> findByName(String id) {
//        return
//    }

    public Ingredients create(Ingredients ingredients) {
        return persist(ingredients);
    }
}

