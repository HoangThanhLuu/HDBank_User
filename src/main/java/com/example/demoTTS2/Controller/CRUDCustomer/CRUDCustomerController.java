package com.example.demoTTS2.Controller.CRUDCustomer;

import com.example.demoTTS2.Model.CustomerEntity;
import com.example.demoTTS2.Repository.CustoRepo;
import com.example.demoTTS2.Service.ICustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CRUDCustomerController {

    private final ICustomerService customerService;
    private final CustoRepo custoRepo;

    public CRUDCustomerController(ICustomerService customerService, CustoRepo custoRepo) {
        this.customerService = customerService;
        this.custoRepo = custoRepo;
    }

    @PostMapping("/api/customers/add")
    public ResponseEntity<?> registerUser(@RequestBody CustomerEntity userEntity){
     customerService.registerCustomer(userEntity);
        return ResponseEntity.ok("post success");
    }

    @DeleteMapping("/api/customers/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        customerService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }

    @PostMapping("/api/salary/{name}")
    public Integer getSalary(@PathVariable String name){
      Integer salary =   customerService.getSalary(name);
      return salary;
    }
    @GetMapping("/api/customers/getAllCustomer")
    public List<CustomerEntity> getAllCustomer() {
        return custoRepo.findAll();
    }



}
