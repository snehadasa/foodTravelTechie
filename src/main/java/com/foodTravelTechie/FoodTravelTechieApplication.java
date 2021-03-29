package com.foodTravelTechie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodTravelTechie.core.People;
import com.foodTravelTechie.db.PeopleDao;
import com.foodTravelTechie.resources.PeopleResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class FoodTravelTechieApplication extends Application<FoodTravelTechieConfiguration> {

    private final HibernateBundle<FoodTravelTechieConfiguration> hibernate = new HibernateBundle<FoodTravelTechieConfiguration>(People.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(FoodTravelTechieConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new FoodTravelTechieApplication().run(args);
    }

    @Override
    public void run(FoodTravelTechieConfiguration FoodTravelTechieConfiguration, Environment environment) throws Exception {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, FoodTravelTechieConfiguration.getDataSourceFactory(), "mysql");
        System.out.println(jdbi.toString());
//        environment.jersey().register(new UserResource(jdbi));
        final PeopleDao peopleDao = new PeopleDao(hibernate.getSessionFactory());
        environment.jersey().register(new PeopleResource(peopleDao));
    }

    @Override
    public void initialize(Bootstrap<FoodTravelTechieConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<FoodTravelTechieConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(FoodTravelTechieConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernate);
    }
}
