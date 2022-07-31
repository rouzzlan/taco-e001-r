package com.falcontech.tacoe001r.service;

import com.falcontech.tacoe001r.model.Ingredient;
import com.falcontech.tacoe001r.repo.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service
public class IngredientService {
  private final IngredientRepository ingredientRepository;

  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @Transactional(readOnly = true)
  public Iterable<Ingredient> getIngredients() {
    return ingredientRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<Ingredient> getIngredientById(String id) {
    return ingredientRepository.findById(id);
  }

  public Ingredient.Type[] getTypes() {
    return Ingredient.Type.values();
  }
}
