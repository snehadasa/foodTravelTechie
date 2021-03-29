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
@Table(name = "ingredients")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.example.foodTravelTechie.core.Ingredients.findAll",
                        query = "SELECT i FROM Ingredients i"
                )
        })
public class Ingredients {
    @Column(name = "ingredient_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long ingredientId;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

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

        if (!(o instanceof Ingredients)) {
            return false;
        }

        Ingredients ingredients = (Ingredients) o;

        return ingredientId == ingredients.ingredientId &&
                Objects.equals(name, ingredients.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, name, createdAt, updatedAt);
    }
}

