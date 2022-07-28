package com.falcontech.tacoe001r.v1;

import com.falcontech.tacoe001r.model.TacoOrder;
import com.falcontech.tacoe001r.service.TacoOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/v1/order")
public class TacoOrderController {
  private final TacoOrderService tacoOrderService;

  public TacoOrderController(TacoOrderService tacoOrderService) {
    this.tacoOrderService = tacoOrderService;
  }

  @GetMapping("/all")
  public Iterable<TacoOrder> getOrders() {
    return tacoOrderService.getOrders();
  }

  @GetMapping("/{id}")
  public Optional<TacoOrder> getTacoOrderById(@PathVariable Long id) {
    return tacoOrderService.findOrderById(id);
  }
}
