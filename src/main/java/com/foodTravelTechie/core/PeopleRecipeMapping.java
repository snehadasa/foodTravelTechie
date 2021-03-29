package com.foodTravelTechie.core;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "people_recipe_mapping")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.example.foodTravelTechie.core.PeopleRecipeMapping.findAll",
                        query = "SELECT p FROM PeopleRecipeMapping p"
                )
        })
public class PeopleRecipeMapping {
    @Column(name = "people_recipe_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long peopleRecipeId;

    @Email
    @Column(name = "people_id", nullable = false)
    @Getter
    @Setter
    private String peopleId;

    @Column(name = "recipe_id", nullable = false)
    @Getter
    @Setter
    private String recipeId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @Getter
    @Setter
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    @Getter
    @Setter
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof People)) {
            return false;
        }

        PeopleRecipeMapping peopleRecipe = (PeopleRecipeMapping) o;

        return peopleRecipeId == peopleRecipe.peopleRecipeId &&
                recipeId == peopleRecipe.recipeId &&
                peopleId == peopleRecipe.peopleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleRecipeId, recipeId, peopleId, createdAt, updatedAt);
    }
}

