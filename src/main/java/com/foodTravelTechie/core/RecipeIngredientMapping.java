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
@Table(name = "recipe_ingredient_mapping")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.example.foodTravelTechie.core.RecipeIngredientMapping.findAll",
                        query = "SELECT p FROM RecipeIngredientMapping p"
                )
        })
public class RecipeIngredientMapping {
    @Column(name = "recipe_ingredient_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long recipeIngredientId;

    @Column(name = "recipe_id", nullable = false)
    @Getter
    @Setter
    private String recipeId;

    @Email
    @Column(name = "ingredient_id", nullable = false)
    @Getter
    @Setter
    private String ingredientId;

    @Column(name = "grams")
    @Min(value = 0)
    @Getter
    @Setter
    private long grams;

    @Column(name = "ml")
    @Min(value = 0)
    @Getter
    @Setter
    private long ml;

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

        RecipeIngredientMapping recipeIngredient = (RecipeIngredientMapping) o;

        return recipeIngredientId == recipeIngredient.recipeIngredientId &&
                recipeId == recipeIngredient.recipeId &&
                ingredientId == recipeIngredient.ingredientId &&
                grams == recipeIngredient.grams &&
                ml == recipeIngredient.ml;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientId, recipeId, ingredientId, grams, ml, createdAt, updatedAt);
    }
}
