package com.example.nenne.jpatest.service.impl;

import com.example.nenne.jpatest.entity.CarwashEntity;
import com.example.nenne.jpatest.exceptions.DuplicateException;
import com.example.nenne.jpatest.factory.CEntityManagerFactory;
import com.example.nenne.jpatest.service.UserService;

import javax.persistence.EntityManager;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    @Override
    public Optional<CarwashEntity> getUser(String name) {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        CarwashEntity userEntity = entityManager.find(CarwashEntity.class, name);

        System.out.println(userEntity.getClass().getName());

        entityManager.close();

        return Optional.ofNullable(userEntity);
    }

    @Override
    public void saveUser(CarwashEntity userEntity) {
        EntityManager entityManager = CEntityManagerFactory.createEntityManger();

        // EntityTransaction 으로 객체를 생성해서 트랜잭션 관리를 해도 되지만 EntityManager 만으로도 사용할 수 있음
        entityManager.getTransaction().begin();

        try {
            CarwashEntity foundUser = entityManager.find(CarwashEntity.class, userEntity.getNAME());

            // User 데이터를 추가하기 전에 같은 값이 있는지 체크
            if (foundUser != null) {
                // 기존에 동일한 데이터가 있다면 예외 호출
                throw new DuplicateException();
            }

            // Persistence Context 에 객체 추가
            entityManager.persist(userEntity);
            // 실제 DB 적용
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}