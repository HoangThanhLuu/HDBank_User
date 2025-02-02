package com.example.demoTTS2.Controller.CRUDAdmin;

import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Repository.UserRepo;
import com.example.demoTTS2.Service.ICustomerService;
import com.example.demoTTS2.Service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class CRUDAdminController {
    private final IUserService iUserService;
    private final UserRepo userRepo;
    private final ICustomerService customerService;
    public CRUDAdminController(IUserService iUserService, UserRepo userRepo, ICustomerService customerService) {
        this.iUserService = iUserService;
        this.userRepo = userRepo;
        this.customerService = customerService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity){
        iUserService.createUser(userEntity);
        return ResponseEntity.ok("OK !");
    }
    @DeleteMapping("/api/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        iUserService.deleteUser(id);
        return ResponseEntity.ok("delete success");
    }
}
