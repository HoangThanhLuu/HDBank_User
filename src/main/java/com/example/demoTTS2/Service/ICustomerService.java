package com.example.demoTTS2.Service;

import com.example.demoTTS2.Model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerService {
    CustomerEntity registerCustomer(CustomerEntity customerEntity);

    void deleteById(Integer id);

    Integer getSalary(String name);
}
