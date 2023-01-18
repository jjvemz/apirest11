package com.demo.apirest.repository;

import com.demo.apirest.model.Phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository
    extends JpaRepository<Phone, Long> {
}
