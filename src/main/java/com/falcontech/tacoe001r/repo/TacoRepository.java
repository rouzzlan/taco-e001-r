package com.falcontech.tacoe001r.repo;

import com.falcontech.tacoe001r.model.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
