package com.example.demoTTS2.Service;

import com.example.demoTTS2.Model.CustomerEntity;
import com.example.demoTTS2.Repository.CustoRepo;
import com.example.demoTTS2.Repository.UserRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements  ICustomerService{
    private final CustoRepo customer;
    private final UserRepo userRepo;

    public CustomerService(CustoRepo customer, UserRepo userRepo) {
        this.customer = customer;
        this.userRepo = userRepo;
    }

    @Override
    public CustomerEntity registerCustomer(CustomerEntity customerEntity) {
        if(customer.existsByEmpno(customerEntity.getEmpno())){
            throw new DataIntegrityViolationException("Customer already exists");
        }
        return  customer.save(customerEntity);

    }

    @Override
    public void deleteById(Integer id) {
        customer.deleteById(id);
    }

    @Override
    public Integer getSalary(String name) {
        if(customer.findByName(name) == null){
            throw  new DataIntegrityViolationException("Name not exists");

        }
        return customer.findByName(name).getSalary();

    }
}
