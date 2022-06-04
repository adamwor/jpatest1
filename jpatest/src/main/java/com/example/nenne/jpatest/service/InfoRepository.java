package com.example.nenne.jpatest.service;

import com.example.nenne.jpatest.entity.CarwashEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<CarwashEntity, Long> {
}
