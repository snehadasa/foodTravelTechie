package com.foodTravelTechie.db;

import com.foodTravelTechie.core.Recipies;
import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;

import java.util.Optional;

public class RecipiesDao extends AbstractDAO<Recipies>{

    public RecipiesDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Recipies> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

//    public Optional<People> findByName(String id) {
//        return
//    }

    public Recipies create(Recipies recipie) {
        return persist(recipie);
    }
}
