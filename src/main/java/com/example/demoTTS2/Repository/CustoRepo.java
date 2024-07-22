package com.example.demoTTS2.Repository;

import com.example.demoTTS2.Model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustoRepo extends JpaRepository<CustomerEntity,Integer> {
    Boolean existsByEmpno(Integer mnv);
    CustomerEntity findByName(String name);

    @Override
    List<CustomerEntity> findAll();
}
