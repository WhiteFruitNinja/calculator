package com.spring.calculator.service;

import com.spring.calculator.model.Number;

import com.spring.calculator.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service - servisų sluoksnis biznio logikai
// Po serviso sluoksniu kreipiamės į DAO
@Service
public class NumberServiceImpl implements NumberService {
    // autowire - naudojamas automatinei priklausomybių injekcijai
    // Kad panaudoti @Autowired anotaciją, reikia pirmiausiai turėti apsirašius @Bean @Configuration klasėje
    @Autowired
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkrečiai bean susieti priklausomybę.
    // Jeigu @Configuration klasėje yra daugiau negu vienas bean, @Qualifier antoacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    private NumberRepository numberRepository;

    @Override
    public List<Number> getAll(){
        return numberRepository.findAll();
    }

    @Override
    public void save(Number number){
        numberRepository.save(number);
    }

    @Override
    public Number getById(int id){
        return numberRepository.findById(id);
    }

    public void update(Number number){
        numberRepository.save(number);
    }

    @Override
    public void delete(int id){
        numberRepository.deleteById(id);
    }

}
