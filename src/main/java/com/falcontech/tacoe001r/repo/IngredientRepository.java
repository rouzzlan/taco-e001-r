package com.falcontech.tacoe001r.repo;

import com.falcontech.tacoe001r.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
  @Query(
      value = "SELECT * FROM Ingredient i WHERE i.enabled = 1",
      nativeQuery = true)
  Collection<Ingredient> getEnabledIngredients();

}
