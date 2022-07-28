package com.falcontech.tacoe001r.repo;

import com.falcontech.tacoe001r.model.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoOrderRepository extends JpaRepository<TacoOrder, Long> {
}
