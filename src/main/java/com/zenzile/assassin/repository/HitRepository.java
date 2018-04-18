package com.zenzile.assassin.repository;

import com.zenzile.assassin.model.Hit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HitRepository extends CrudRepository<Hit, Long> {

}
