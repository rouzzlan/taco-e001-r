package com.falcontech.tacoe001r.v1;

import com.falcontech.tacoe001r.model.Ingredient;
import com.falcontech.tacoe001r.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/v1/ingredients")
public class IngredientController {
  private final IngredientService ingredientService;


  public IngredientController(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping("/all")
  public Iterable<Ingredient> getIngredients() {
    return ingredientService.getIngredients();
  }

  @GetMapping("/{id}")
  public Optional<Ingredient> getIngredientById(@PathVariable String id) {
    return ingredientService.getIngredientById(id);
  }

  @PostMapping("/add")
  public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
    return ingredientService.saveIngredient(ingredient);
  }

  @PutMapping("{id}")
  public Ingredient updateIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
    return ingredientService.saveIngredient(ingredient);
  }
}
