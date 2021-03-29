package com.foodTravelTechie.db;

import com.foodTravelTechie.core.People;
import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PeopleDao extends AbstractDAO<People> {

    public PeopleDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<People> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Optional<People> findBySavedRecipies(Long savedRecipies) {
        return Optional.ofNullable(get(savedRecipies));
    }

//    public Optional<People> findByName(String id) {
//        return
//    }

    public People create(People person) {
        return persist(person);
    }
}
