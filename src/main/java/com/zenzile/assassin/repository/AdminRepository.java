package com.zenzile.assassin.repository;

import com.zenzile.assassin.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    @Query(value = "SELECT * FROM admins WHERE email = ?1", nativeQuery = true)
    List<Admin> findAdminByEmail(String email);

}
