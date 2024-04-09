package com.spring.calculator.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final String PERSITENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory(){
        if (factory == null){
            factory = Persistence.createEntityManagerFactory(PERSITENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown(){
        if (factory != null){
            factory.close();
        }
    }

}
