package com.falcontech.tacoe001r.service;

import com.falcontech.tacoe001r.model.Taco;
import com.falcontech.tacoe001r.repo.TacoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class TacoService {
  private final TacoRepository tacoRepository;

  public TacoService(TacoRepository tacoRepository) {
    this.tacoRepository = tacoRepository;
  }

  @Transactional(readOnly = true)
  public Iterable<Taco> getTacos() {
    return tacoRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<Taco> getTacoById(Long id) {
    return tacoRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public Collection<Taco> getTacosForOrder(Long id) {
    return tacoRepository.getTacosForOrder(id);
  }

}
