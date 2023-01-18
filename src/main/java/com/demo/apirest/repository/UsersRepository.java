package com.demo.apirest.repository;

import com.demo.apirest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository
        extends JpaRepository<Users, Long> {
}
