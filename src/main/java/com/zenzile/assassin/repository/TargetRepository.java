package com.zenzile.assassin.repository;

import com.zenzile.assassin.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepository extends CrudRepository<Target, Long> {

}
