package com.falcontech.tacoe001r.service;

import com.falcontech.tacoe001r.model.TacoOrder;
import com.falcontech.tacoe001r.repo.TacoOrderRepository;
import com.falcontech.tacoe001r.repo.TacoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TacoOrderService {
  private final TacoOrderRepository tacoOrderRepository;

  public TacoOrderService(TacoOrderRepository tacoOrderRepository) {
    this.tacoOrderRepository = tacoOrderRepository;
  }

  @Transactional(readOnly = true)
  public Iterable<TacoOrder> getOrders() {
    return tacoOrderRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<TacoOrder> findOrderById(Long id) {
    return tacoOrderRepository.findById(id);
  }
}
