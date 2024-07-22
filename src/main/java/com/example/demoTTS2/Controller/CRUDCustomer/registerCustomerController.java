package com.example.demoTTS2.Controller.CRUDCustomer;

import com.example.demoTTS2.Model.CustomerEntity;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Service.CustomerService;
import com.example.demoTTS2.Service.ICustomerService;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class registerCustomerController {

    private final ICustomerService customerService;

    public registerCustomerController(ICustomerService customerService) {
        this.customerService = customerService;
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

    @PostMapping("/api/customers/getsalary/{name}")
    public Integer getSalary(@PathVariable String name){
      Integer salary =   customerService.getSalary(name);

      return salary;



    }



}
