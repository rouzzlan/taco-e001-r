package com.falcontech.tacoe001r.v1;

import com.falcontech.tacoe001r.model.Taco;
import com.falcontech.tacoe001r.service.TacoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/v1/tacos")
public class TacoController {
  private final TacoService tacoService;

  public TacoController(TacoService tacoService) {
    this.tacoService = tacoService;
  }

  @GetMapping("/all")
  public Iterable<Taco> getTacos() {
    return tacoService.getTacos();
  }

  @GetMapping("/{id}")
  public Optional<Taco> findById(@PathVariable Long id) {
    return tacoService.getTacoById(id);
  }

  @PostMapping("/add")
  public Taco addTaco(@RequestBody Taco taco) {
    return tacoService.saveTaco(taco);
  }

  @PutMapping("/update")
  public Taco updateTaco(@RequestBody Taco taco) {
    return tacoService.saveTaco(taco);
  }

  @DeleteMapping("/{id}")
  public void deleteTacoById(@PathVariable Long id) {
    tacoService.deleteTacoByID(id);
  }
}