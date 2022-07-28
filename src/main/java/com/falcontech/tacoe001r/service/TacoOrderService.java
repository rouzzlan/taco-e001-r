package com.falcontech.tacoe001r.service;

import com.falcontech.tacoe001r.model.TacoOrder;
import com.falcontech.tacoe001r.repo.TacoOrderRepository;
import com.falcontech.tacoe001r.repo.TacoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TacoOrderService {
  private final TacoRepository tacoRepository;
  private final TacoOrderRepository tacoOrderRepository;

  public TacoOrderService(TacoRepository tacoRepository, TacoOrderRepository tacoOrderRepository) {
    this.tacoRepository = tacoRepository;
    this.tacoOrderRepository = tacoOrderRepository;
  }

  @Transactional(readOnly = true)
  public Iterable<TacoOrder> getOrders() {
    return tacoOrderRepository.findAll();
  }

  @Transactional
  public TacoOrder saveTacoOrder(TacoOrder tacoOrder) {
//    Iterable<Taco> savedTacos = tacoRepository.saveAll(tacoOrder.getTacos());

    return tacoOrderRepository.save(tacoOrder);
  }

  @Transactional(readOnly = true)
  public Optional<TacoOrder> findOrderById(Long id) {
    return tacoOrderRepository.findById(id);
  }

  @Transactional
  public void deleteTacoById(Long id) {
    tacoRepository.deleteById(id);
  }
}
