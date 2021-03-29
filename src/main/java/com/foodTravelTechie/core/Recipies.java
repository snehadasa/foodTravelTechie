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
@Table(name = "recipies")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.example.foodTravelTechie.core.Recipies.findAll",
                        query = "SELECT r FROM Recipies r"
                )
        })
public class Recipies {
    @Column(name = "recipe_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long recipeId;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Email
    @Column(name = "description", nullable = false)
    @Getter
    @Setter
    private String description;

    @Column(name = "instructions")
    @Min(value = 0)
    @Getter
    @Setter
    private long instructions;

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

        Recipies recipe = (Recipies) o;

        return recipeId == recipe.recipeId &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(instructions, recipe.instructions) &&
                Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, name, description, instructions, createdAt, updatedAt);
    }
}
