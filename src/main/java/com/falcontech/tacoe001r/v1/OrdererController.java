package com.falcontech.tacoe001r.v1;

import com.falcontech.tacoe001r.model.Orderer;
import com.falcontech.tacoe001r.service.OrdererService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/v1/orderer")
public class OrdererController {
  private final OrdererService ordererService;

  public OrdererController(OrdererService ordererService) {
    this.ordererService = ordererService;
  }

  @GetMapping("/{id}")
  public Optional<Orderer> getOrdererById(@PathVariable String id) {
    return ordererService.getOrdererById(id);
  }
}
