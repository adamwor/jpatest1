package com.example.nenne.jpatest.service;

import com.example.nenne.jpatest.entity.CarwashEntity;

import java.util.Optional;


public interface UserService {

    Optional<CarwashEntity> getUser(String NAME);

    void saveUser(CarwashEntity userEntity);
}