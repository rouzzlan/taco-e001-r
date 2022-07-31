package com.falcontech.tacoe001r.repo;

import com.falcontech.tacoe001r.model.Taco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {
  @Query(
      value = "SELECT * FROM Taco t WHERE t.taco_order_id = ?1",
      nativeQuery = true)
  Collection<Taco> getTacosForOrder(Long id);
}
