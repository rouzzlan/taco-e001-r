package com.falcontech.tacoe001r.service;

import com.falcontech.tacoe001r.model.Orderer;
import com.falcontech.tacoe001r.repo.OrdererRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrdererService {
  private final OrdererRepository ordererRepository;

  public OrdererService(OrdererRepository ordererRepository) {
    this.ordererRepository = ordererRepository;
  }

  public Optional<Orderer> getOrdererById(String id) {
    return ordererRepository.findById(UUID.fromString(id));
  }
}
