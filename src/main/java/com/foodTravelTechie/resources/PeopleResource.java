package com.foodTravelTechie.resources;

import com.codahale.metrics.annotation.Timed;
import com.foodTravelTechie.core.People;
import com.foodTravelTechie.db.PeopleDao;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.OptionalLong;
import java.util.Optional;

@Path("/person/")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {
    private PeopleDao peopleDao;

    public PeopleResource(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("{id}")
    public Optional<People> findPerson(@PathParam("id") OptionalLong id) {
        return peopleDao.findById(id.getAsLong());
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("savedRecipies")
    public Optional<People> findSavedRecipies(@PathParam("savedRecipies") OptionalLong savedRecipies) {
        return peopleDao.findBySavedRecipies(savedRecipies.getAsLong());
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public People createOrUpdateRecord(People people) {
        return peopleDao.create(people);
    }


}
